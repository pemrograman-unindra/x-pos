package trx;

import java.util.ArrayList;
import java.util.List;

import products.ProductCLIController;
import products.ProductService;
import utils.Icon;
import utils.Input;
import utils.Output;
import utils.Style;
import utils.TableColumn;

public class SalesCLIController {

	public void menu() {
		int choice;
		do {
			Output.clearScreen();
			Output.println("--------------------------------", Style.CYAN);
			Output.println(Icon.SALES + " Transaksi Penjualan");
			Output.println("--------------------------------", Style.CYAN);
			Output.println();
			Output.println("1. Tampilkan daftar transaksi penjualan " + Icon.LIST);
			Output.println("2. Tampilkan rincian transaksi penjualan " + Icon.FIND);
			Output.println("3. Tambah transaksi penjualan " + Icon.CREATE);
			Output.println("4. Ubah transaksi penjualan " + Icon.EDIT);
			Output.println("5. Hapus transaksi penjualan " + Icon.DELETE);
			Output.println();
			Output.println("0. Keluar " + Icon.EXIT);
			Output.println();
			Output.print("Silakan pilih menu (0-5) : ", Style.BLUE);
			try {
				choice = Input.readInteger();
			} catch (Exception e) {
				choice = -1;
			}

			Output.println();
			switch (choice) {
				case 1 -> getAll(true);
				case 2 -> getByNumber();
				case 3 -> create();
				case 4 -> updateByNumber();
				case 5 -> deleteByNumber();
				default -> {
					if (choice != 0) {
						Output.println();
						Output.println("Pilihan tidak valid!", Style.RED);
					}
				}
			}
		} while (choice != 0);
	}

	public static void getAll() {
		List<SalesModel> sales = SalesService.useCase.getAll();

		int salesCount = sales.size();
		if (salesCount > 0) {
			TableColumn[] columns = new TableColumn[] {
					new TableColumn("No. Ref"),
					new TableColumn("Tanggal"),
					new TableColumn("Jam"),
					new TableColumn("Nilai Penjualan")
			};

			int i = 0;
			String[][] rows = new String[salesCount][4];
			for (SalesModel sale : sales) {
				rows[i][0] = Output.formatNumber(sale.getNumber());
				rows[i][1] = sale.getDate();
				rows[i][2] = sale.getTime();
				rows[i][3] = Output.formatNumber(sale.getAmount());
				if (rows[i][0].length() > columns[0].maxLength) {
					columns[0].maxLength = rows[i][0].length();
				}
				if (rows[i][1].length() > columns[1].maxLength) {
					columns[1].maxLength = rows[i][1].length();
				}
				if (rows[i][2].length() > columns[2].maxLength) {
					columns[2].maxLength = rows[i][2].length();
				}
				if (rows[i][3].length() > columns[3].maxLength) {
					columns[3].maxLength = rows[i][3].length();
				}
				i++;
			}
			Output.printTable(columns, rows);
		} else {
			Output.println("Transaksi masih kosong!");
		}
		Output.println();
	}

	// tugas no 2 : Encapsulation, getAll menggunakan private untuk membatasi agar
	// hanya bisa diakses dari class yg sama
	// tugas no 3 : Overload, menerapkan overload atas getAll
	private void getAll(boolean isMenu) {
		Output.clearScreen();
		Output.println("--------------------------------", Style.CYAN);
		Output.println(Icon.LIST + " Daftar Transaksi Penjualan");
		Output.println("--------------------------------", Style.CYAN);
		Output.println();
		getAll();
		Input.hold();
	}

	// tugas no 2 : Encapsulation, getByCode menggunakan private untuk membatasi
	// agar hanya bisa diakses dari class yg sama
	private void getByNumber() {
		Output.clearScreen();
		Output.println("--------------------------------", Style.CYAN);
		Output.println(Icon.FIND + " Rincian Transaksi Penjualan");
		Output.println("--------------------------------", Style.CYAN);
		Output.println();

		getAll();
		Output.print("Nomor transaksi : ", Style.BLUE);
		try {
			int code = Input.readInteger();
			SalesModel sale = SalesService.useCase.getByNumber(code);
			Output.println();
			Output.println("No. Ref         : " + sale.getNumber());
			Output.println("Tanggal         : " + sale.getDate());
			Output.println("Jam             : " + sale.getTime());

			TableColumn[] columns = new TableColumn[] {
					new TableColumn("Deskripsi"),
					new TableColumn("Catatan"),
					new TableColumn("Jumlah"),
					new TableColumn("Harga"),
					new TableColumn("Subtotal")
			};

			int i = 0;
			List<SalesItemModel> items = sale.getItems();
			int itemCount = items.size();
			String[][] rows = new String[itemCount][5];
			for (SalesItemModel item : items) {
				rows[i][0] = item.getProduct().getName();
				rows[i][1] = item.getNote();
				rows[i][2] = Output.formatNumber(item.getQty());
				rows[i][3] = Output.formatNumber(item.getProduct().getPrice());
				rows[i][4] = Output.formatNumber(item.getQty() * item.getProduct().getPrice());
				if (rows[i][0].length() > columns[0].maxLength) {
					columns[0].maxLength = rows[i][0].length();
				}
				if (rows[i][1].length() > columns[1].maxLength) {
					columns[1].maxLength = rows[i][1].length();
				}
				if (rows[i][2].length() > columns[2].maxLength) {
					columns[2].maxLength = rows[i][2].length();
				}
				if (rows[i][3].length() > columns[3].maxLength) {
					columns[3].maxLength = rows[i][3].length();
				}
				if (rows[i][4].length() > columns[4].maxLength) {
					columns[4].maxLength = rows[i][4].length();
				}
				i++;
			}
			Output.printTable(columns, rows);
			TableColumn[] footerColumns = new TableColumn[] {
					new TableColumn(columns[0].maxLength + columns[1].maxLength + columns[2].maxLength
							+ columns[3].maxLength + 9),
					new TableColumn(columns[4].maxLength)
			};
			String[][] footerRows = { { "Total", Output.formatNumber(sale.getAmount()) } };
			Output.printTableFooter(footerColumns, footerRows);

		} catch (TrxException e) {
			Output.println();
			Output.println(e.getMessage(), Style.RED);
		} catch (Exception e) {
			Output.println();
			Output.println("Kode yang anda masukan tidak valid!", Style.RED);
		}
		Output.println();
		Input.hold();
	}

	// tugas no 2 : Encapsulation, create menggunakan private untuk membatasi agar
	// hanya bisa diakses dari class yg sama
	private void create() {
		Output.clearScreen();
		Output.println("--------------------------------", Style.CYAN);
		Output.println(Icon.CREATE + " Tambah Transaksi Penjualan");
		Output.println("--------------------------------", Style.CYAN);
		Output.println();

		SalesModel sale = new SalesModel();
		try {
			boolean isAddProduct = true;
			do {
				SalesItemModel item = new SalesItemModel();

				ProductCLIController.getAll();
				Output.print("Kode produk : ", Style.BLUE);
				item.setProduct(ProductService.useCase.getByCode(Input.readString()));

				Output.print("Jumlah      : ", Style.BLUE);
				item.setQty(Input.readDouble());

				Output.print("Catatan     : ", Style.BLUE);
				item.setNote(Input.readString());

				sale.addItem(item);

				Output.println();
				Output.print("Tambah item? (y/n) : ", Style.BLUE);
				isAddProduct = Input.readBoolean();
				Output.println();
			} while (isAddProduct);

			SalesService.useCase.create(sale);

			Output.println();
			Output.println("Transaksi berhasil disimpan !", Style.GREEN);
		} catch (TrxException e) {
			Output.println();
			Output.println(e.getMessage(), Style.RED);
		} catch (Exception e) {
			Output.println();
			Output.println("Error : " + e.getMessage(), Style.RED);
		}
		Output.println();
		Input.hold();
	}

	// tugas no 2 : Encapsulation, updateByCode menggunakan private untuk membatasi
	// agar hanya bisa diakses dari class yg sama
	private void updateByNumber() {
		Output.clearScreen();
		Output.println("--------------------------------", Style.CYAN);
		Output.println(Icon.EDIT + " Ubah Transaksi Penjualan");
		Output.println("--------------------------------", Style.CYAN);
		Output.println();

		try {
			getAll();
			Output.print("Nomor transaksi yang akan diubah : ", Style.BLUE);
			int number = Input.readInteger();
			SalesModel sale = SalesService.useCase.getByNumber(number);
			List<SalesItemModel> items = new ArrayList<>();

			boolean isAddProduct = true;
			do {
				SalesItemModel item = new SalesItemModel();

				ProductCLIController.getAll();
				Output.print("Kode produk : ", Style.BLUE);
				item.setProduct(ProductService.useCase.getByCode(Input.readString()));

				Output.print("Jumlah      : ", Style.BLUE);
				item.setQty(Input.readDouble());

				Output.print("Catatan     : ", Style.BLUE);
				item.setNote(Input.readString());

				items.add(item);

				Output.println();
				Output.print("Tambah item? (y/n) : ", Style.BLUE);
				isAddProduct = Input.readBoolean();
				Output.println();
			} while (isAddProduct);
			sale.setItems(items);

			SalesService.useCase.updateByNumber(number, sale);

			Output.println();
			Output.println("Transaksi berhasil disimpan !", Style.GREEN);
		} catch (TrxException e) {
			Output.println();
			Output.println(e.getMessage(), Style.RED);
		} catch (Exception e) {
			Output.println();
			Output.println("Error : " + e.getMessage(), Style.RED);
		}
		Output.println();
		Input.hold();
	}

	// tugas no 2 : Encapsulation, deleteByCode menggunakan private untuk membatasi
	// agar hanya bisa diakses dari class yg sama
	private void deleteByNumber() {
		Output.clearScreen();
		Output.println("--------------------------------", Style.CYAN);
		Output.println(Icon.DELETE + " Hapus Transaksi Penjualan");
		Output.println("--------------------------------", Style.CYAN);
		Output.println();
		try {
			getAll();
			Output.print("Nomor transaksi yang akan dihapus : ", Style.BLUE);
			int number = Input.readInteger();
			SalesService.useCase.getByNumber(number);

			SalesService.useCase.deleteByNumber(number);

			Output.println();
			Output.println("Transaksi berhasil dihapus !", Style.GREEN);
		} catch (TrxException e) {
			Output.println();
			Output.println(e.getMessage(), Style.RED);
		} catch (Exception e) {
			Output.println();
			Output.println("Error : " + e.getMessage(), Style.RED);
		}
		Output.println();
		Input.hold();
	}
}
