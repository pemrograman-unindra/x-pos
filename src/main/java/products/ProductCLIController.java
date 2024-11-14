package products;

import java.util.List;

import utils.Icon;
import utils.Input;
import utils.Output;
import utils.Style;
import utils.TableColumn;

public class ProductCLIController {

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
			Output.print("Silakan pilih menu (0-5) : ", Style.BLUE);
			try {
				choice = Input.readInteger();
			} catch (Exception e) {
				choice = -1;
			}

			Output.println();
			switch (choice) {
				case 1 -> getAll(true);
				case 2 -> getByCode();
				case 3 -> create();
				case 4 -> updateByCode();
				case 5 -> deleteByCode();
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
		List<ProductModel> products = ProductService.useCase.getAll();

		int productCount = products.size();
		if (productCount > 0) {
			TableColumn[] columns = new TableColumn[] {
					new TableColumn("Kode"),
					new TableColumn("Nama"),
					new TableColumn("Kategori"),
					new TableColumn("Harga")
			};

			int i = 0;
			String[][] rows = new String[productCount][4];
			for (ProductModel product : products) {
				rows[i][0] = product.getCode();
				rows[i][1] = product.getName();
				rows[i][2] = product.getCategory().getName();
				rows[i][3] = Output.formatNumber(product.getPrice());
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
			Output.println("Data produk masih kosong!");
		}
		Output.println();
	}

	// tugas no 2 : Encapsulation, getAll menggunakan private untuk membatasi agar
	// hanya bisa diakses dari class yg sama
	// tugas no 3 : Overload, menerapkan overload atas getAll
	private void getAll(boolean isMenu) {
		Output.clearScreen();
		Output.println("--------------------------------", Style.CYAN);
		Output.println(Icon.LIST + " Daftar Produk");
		Output.println("--------------------------------", Style.CYAN);
		Output.println();
		getAll();
		Input.hold();
	}

	// tugas no 2 : Encapsulation, getByCode menggunakan private untuk membatasi
	// agar hanya bisa diakses dari class yg sama
	private void getByCode() {
		Output.clearScreen();
		Output.println("--------------------------------", Style.CYAN);
		Output.println(Icon.FIND + " Rincian Produk");
		Output.println("--------------------------------", Style.CYAN);
		Output.println();

		Output.print("Masukan kode produk : ", Style.BLUE);
		try {
			String code = Input.readString();
			ProductModel product = ProductService.useCase.getByCode(code);
			Output.println();
			Output.println("Kode     : " + product.getCode());
			Output.println("Nama     : " + product.getName());
			Output.println("Kategori : " + product.getCategory().getName());
			Output.println("Harga    : " + Output.formatNumber(product.getPrice()));
		} catch (ProductException e) {
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
		Output.println(Icon.CREATE + " Tambah Produk");
		Output.println("--------------------------------", Style.CYAN);
		Output.println();

		ProductModel product = new ProductModel();
		try {
			Output.print("Masukan kode produk          : ", Style.BLUE);
			product.setCode(Input.readString());

			Output.print("Masukan nama produk          : ", Style.BLUE);
			product.setName(Input.readString());

			Output.print("Masukan kode kategori produk : ", Style.BLUE);
			ProductCategoryModel productCategory = ProductCategoryService.useCase.getByCode(Input.readString());
			product.setCategory(productCategory);

			Output.print("Masukan harga produk         : ", Style.BLUE);
			product.setPrice(Input.readDouble());

			ProductService.useCase.create(product);

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

	// tugas no 2 : Encapsulation, updateByCode menggunakan private untuk membatasi
	// agar hanya bisa diakses dari class yg sama
	private void updateByCode() {
		Output.clearScreen();
		Output.println("--------------------------------", Style.CYAN);
		Output.println(Icon.EDIT + " Ubah Produk");
		Output.println("--------------------------------", Style.CYAN);
		Output.println();

		try {
			Output.print("Masukan kode produk yang akan diubah : ", Style.BLUE);
			String code = Input.readString();
			ProductModel product = ProductService.useCase.getByCode(code);

			Output.print("Masukan nama produk          : ", Style.BLUE);
			product.setName(Input.readString());

			Output.print("Masukan kode kategori produk : ", Style.BLUE);
			ProductCategoryModel productCategory = ProductCategoryService.useCase.getByCode(Input.readString());
			product.setCategory(productCategory);

			Output.print("Masukan harga produk         : ", Style.BLUE);
			product.setPrice(Input.readDouble());

			ProductService.useCase.updateByCode(code, product);

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

	// tugas no 2 : Encapsulation, deleteByCode menggunakan private untuk membatasi
	// agar hanya bisa diakses dari class yg sama
	private void deleteByCode() {
		Output.clearScreen();
		Output.println("--------------------------------", Style.CYAN);
		Output.println(Icon.DELETE + " Hapus Produk");
		Output.println("--------------------------------", Style.CYAN);
		Output.println();
		try {
			Output.print("Masukan kode produk yang akan dihapus : ", Style.BLUE);
			String code = Input.readString();
			ProductService.useCase.getByCode(code);

			ProductService.useCase.deleteByCode(code);

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
