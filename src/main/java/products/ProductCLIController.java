package products;

import java.util.List;
import utils.Icon;
import utils.Input;
import utils.Output;
import utils.Style;
import utils.TableColumn;

public class ProductCLIController {

	// tugas no 2 : Encapsulation, productService menggunakan private untuk membatasi agar hanya bisa diakses dari class yg sama
	private ProductService productService = new ProductService();

	public void menu() {
		int choice;
		do {
			Output.clearScreen();
			Output.println("--------------------------------", Style.CYAN);
			Output.println(Icon.PRODUCT + " Produk");
			Output.println("--------------------------------", Style.CYAN);
			Output.println();
			Output.println("1. Tampilkan semua produk " + Icon.LIST);
			Output.println("2. Tampilkan rincian produk " + Icon.FIND);
			Output.println("3. Tambah data produk " + Icon.CREATE);
			Output.println("4. Ubah data produk " + Icon.EDIT);
			Output.println("5. Hapus data produk " + Icon.DELETE);
			Output.println();
			Output.println("0. Keluar " + Icon.EXIT);
			Output.println();
			Output.print("Silakan pilih menu (0-5) : ", Style. BLUE);
			try {
				choice = Input.readInteger();
			} catch (Exception e) {
				choice = -1;
			}

			Output.println();
			switch (choice) {
				case 1 -> getAll();
				case 2 -> getBySKU();
				case 3 -> create();
				case 4 -> updateBySKU();
				case 5 -> deleteBySKU();
				default -> {
					if (choice != 0) {
						Output.println();
						Output.println("Pilihan tidak valid!", Style.RED);
					}
				}
			}
		} while (choice != 0);
	}

	// tugas no 2 : Encapsulation, getAll menggunakan private untuk membatasi agar hanya bisa diakses dari class yg sama
	private void getAll() {
		Output.clearScreen();
		Output.println("--------------------------------", Style.CYAN);
		Output.println(Icon.LIST + " Daftar Produk");
		Output.println("--------------------------------", Style.CYAN);
		Output.println();
		List<ProductModel> products = productService.getAll();

		int productCount = products.size();
		if (productCount > 0) {
			TableColumn[] columns = new TableColumn[]{
				new TableColumn("SKU"),
				new TableColumn("Nama"),
				new TableColumn("Harga")
			};

			int i = 0;
			String[][] rows = new String[products.size()][3];
			for (ProductModel product : products) {
				rows[i][0] = Output.formatNumber(product.getSKU());
				rows[i][1] = product.getName();
				rows[i][2] = Output.formatNumber(product.getPrice());
				if (rows[i][0].length() > columns[0].maxLength) {
					columns[0].maxLength = rows[i][0].length();
				}
				if (rows[i][1].length() > columns[1].maxLength) {
					columns[1].maxLength = rows[i][1].length();
				}
				if (rows[i][2].length() > columns[2].maxLength) {
					columns[2].maxLength = rows[i][2].length();
				}
				i++;
			}
			Output.printTable(columns, rows);
		} else {
			Output.println("Data produk masih kosong!");
		}
		Output.println();

		Input.hold();
	}

	// tugas no 2 : Encapsulation, getBySKU menggunakan private untuk membatasi agar hanya bisa diakses dari class yg sama
	private void getBySKU() {
		Output.clearScreen();
		Output.println("--------------------------------", Style.CYAN);
		Output.println(Icon.FIND + " Rincian Produk");
		Output.println("--------------------------------", Style.CYAN);
		Output.println();

		Output.print("Masukan SKU : ", Style.BLUE);
		try {
			int sku = Input.readInteger();
			ProductModel product = productService.getBySKU(sku);
			Output.println();
			Output.println("SKU   : " + product.getSKU());
			Output.println("Nama  : " + product.getName());
			Output.println("Harga : " + Output.formatNumber(product.getPrice()));
		} catch (ProductException e) {
			Output.println();
			Output.println(e.getMessage(), Style.RED);
		} catch (Exception e) {
			Output.println();
			Output.println("SKU yang anda masukan tidak valid!", Style.RED);
		}
		Output.println();
		Input.hold();
	}

	// tugas no 2 : Encapsulation, create menggunakan private untuk membatasi agar hanya bisa diakses dari class yg sama
	private void create() {
		Output.clearScreen();
		Output.println("--------------------------------", Style.CYAN);
		Output.println(Icon.CREATE + " Tambah Produk");
		Output.println("--------------------------------", Style.CYAN);
		Output.println();

		ProductModel product = new ProductModel();
		try {
			Output.print("Masukan SKU   : ", Style.BLUE);
			product.setSKU(Input.readInteger());

			Output.print("Masukan Nama  : ", Style.BLUE);
			product.setName(Input.readString());

			Output.print("Masukan Harga : ", Style.BLUE);
			product.setPrice(Input.readDouble());

			productService.create(product);

			Output.println();
			Output.println("Data produk berhasil disimpan !", Style.GREEN);
		} catch (ProductException e) {
			Output.println();
			Output.println(e.getMessage(), Style.RED);
		} catch (Exception e) {
			Output.println();
			Output.println("Error : " + e.getMessage(), Style.RED);
		}
		Output.println();
		Input.hold();
	}

	// tugas no 2 : Encapsulation, updateBySKU menggunakan private untuk membatasi agar hanya bisa diakses dari class yg sama
	private void updateBySKU() {
		Output.clearScreen();
		Output.println("--------------------------------", Style.CYAN);
		Output.println(Icon.EDIT + " Ubah Produk");
		Output.println("--------------------------------", Style.CYAN);
		Output.println();

		try {
			Output.print("Masukan SKU yang akan diubah : ", Style.BLUE);
			int sku = Input.readInteger();
			ProductModel product = productService.getBySKU(sku);

			Output.print("Masukan Nama  : ", Style.BLUE);
			product.setName(Input.readString());

			Output.print("Masukan Harga : ", Style.BLUE);
			product.setPrice(Input.readDouble());

			productService.updateBySKU(sku, product);

			Output.println();
			Output.println("Data produk berhasil disimpan !", Style.GREEN);
		} catch (ProductException e) {
			Output.println();
			Output.println(e.getMessage(), Style.RED);
		} catch (Exception e) {
			Output.println();
			Output.println("Error : " + e.getMessage(), Style.RED);
		}
		Output.println();
		Input.hold();
	}

	// tugas no 2 : Encapsulation, deleteBySKU menggunakan private untuk membatasi agar hanya bisa diakses dari class yg sama
	private void deleteBySKU() {
		Output.clearScreen();
		Output.println("--------------------------------", Style.CYAN);
		Output.println(Icon.DELETE + " Hapus Produk");
		Output.println("--------------------------------", Style.CYAN);
		Output.println();
		try {
			Output.print("Masukan SKU yang akan dihapus : ", Style.BLUE);
			int sku = Input.readInteger();
			ProductModel product = productService.getBySKU(sku);

			productService.deleteBySKU(sku);

			Output.println();
			Output.println("Data produk berhasil dihapus !", Style.GREEN);
		} catch (ProductException e) {
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
