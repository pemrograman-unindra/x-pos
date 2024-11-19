package products;

import java.util.List;

import utils.Icon;
import utils.Input;
import utils.Output;
import utils.Style;
import utils.TableColumn;

public class ProductCategoryCLIController {

	public void menu() {
		int choice;
		do {
			Output.clearScreen();
			Output.println("--------------------------------", Style.CYAN);
			Output.println(Icon.PRODUCT_CATEGORY + " Kategori Produk");
			Output.println("--------------------------------", Style.CYAN);
			Output.println();
			Output.println("1. Tampilkan semua kategori produk " + Icon.LIST);
			Output.println("2. Tampilkan rincian kategori produk " + Icon.FIND);
			Output.println("3. Tambah data kategori produk " + Icon.CREATE);
			Output.println("4. Ubah data kategori produk " + Icon.EDIT);
			Output.println("5. Hapus data kategori produk " + Icon.DELETE);
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
						Input.hold();
					}
				}
			}
		} while (choice != 0);
	}

	public static void getAll() {
		List<ProductCategoryModel> products = ProductCategoryService.useCase.getAll();

		int productCount = products.size();
		if (productCount > 0) {
			TableColumn[] columns = new TableColumn[] {
					new TableColumn("Kode"),
					new TableColumn("Nama"),
					new TableColumn("Nomor Rak")
			};

			int i = 0;
			String[][] rows = new String[productCount][3];
			for (ProductCategoryModel product : products) {
				rows[i][0] = product.getCode();
				rows[i][1] = product.getName();
				rows[i][2] = product.getRack();
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
			Output.println("Data kategori produk masih kosong!");
		}
		Output.println();
	}

	// tugas no 2 : Encapsulation, getAll menggunakan private untuk membatasi agar
	// hanya bisa diakses dari class yg sama
	// tugas no 3 : Overload, menerapkan overload atas getAll
	private void getAll(boolean isMenu) {
		Output.clearScreen();
		Output.println("--------------------------------", Style.CYAN);
		Output.println(Icon.LIST + " Daftar Kategori Produk");
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
		Output.println(Icon.FIND + " Rincian Kategori Produk");
		Output.println("--------------------------------", Style.CYAN);
		Output.println();

		Output.print("Kode kategori produk : ", Style.BLUE);
		try {
			String code = Input.readString();
			ProductCategoryModel productCategory = ProductCategoryService.useCase.getByCode(code);
			Output.println();
			Output.println("Kode      : " + productCategory.getCode());
			Output.println("Nama      : " + productCategory.getName());
			Output.println("Nomor Rak : " + productCategory.getRack());
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

		ProductCategoryModel productCategory = new ProductCategoryModel();
		try {
			Output.print("Kode      : ", Style.BLUE);
			productCategory.setCode(Input.readString());

			Output.print("Nama      : ", Style.BLUE);
			productCategory.setName(Input.readString());

			Output.print("Nomor Rak : ", Style.BLUE);
			productCategory.setRack(Input.readString());

			ProductCategoryService.useCase.create(productCategory);

			Output.println();
			Output.println("Data kategori produk berhasil disimpan !", Style.GREEN);
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
			Output.print("Kode kategori produk yang akan diubah : ", Style.BLUE);
			String code = Input.readString();
			ProductCategoryModel productCategory = ProductCategoryService.useCase.getByCode(code);

			Output.print("Nama      : ", Style.BLUE);
			productCategory.setName(Input.readString());

			Output.print("Nomor Rak : ", Style.BLUE);
			productCategory.setRack(Input.readString());

			ProductCategoryService.useCase.updateByCode(code, productCategory);

			Output.println();
			Output.println("Data kategori produk berhasil disimpan !", Style.GREEN);
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
		Output.println(Icon.DELETE + " Hapus Kategori Produk");
		Output.println("--------------------------------", Style.CYAN);
		Output.println();
		try {
			Output.print("Kode kategori produk yang akan dihapus : ", Style.BLUE);
			String code = Input.readString();
			ProductCategoryService.useCase.deleteByCode(code);

			Output.println();
			Output.println("Data kategori produk berhasil dihapus !", Style.GREEN);
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
