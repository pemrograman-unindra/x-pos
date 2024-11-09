package products;

import java.io.Console;
import java.util.List;
import java.util.Scanner;
import utils.Icon;
import utils.Output;
import utils.Style;

public class ProductCLIController {
	private static Console console = System.console();
	private ProductService productService = new ProductService();
	private Scanner scanner = new Scanner(System.in);

	public void menu() {
		int choice;
		do {
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
				choice = Integer.valueOf(console.readLine());
			} catch (Exception e) {
				choice = -1;
			}

			Output.println();
			switch (choice) {
				case 1 -> getAll();
				case 2 -> getById();
				case 3 -> create();
				case 4 -> updateById();
				case 5 -> deleteById();
				default -> {
					if (choice != 0) {
						Output.println();
						Output.println("Pilihan tidak valid!", Style.RED);
					}
				}
			}
		} while (choice != 0);
	}

	private void getAll() {
		Output.println("--------------------------------", Style.CYAN);
		Output.println(Icon.LIST + " Daftar Produk");
		Output.println("--------------------------------", Style.CYAN);
		Output.println();
		List<ProductModel> products = productService.getAll();
		for (ProductModel product : products) {
			System.out.println(product);
		}
	}

	private void getById() {
		Output.println("--------------------------------", Style.CYAN);
		Output.println(Icon.FIND + " Rincian Produk");
		Output.println("--------------------------------", Style.CYAN);
		Output.println();

		Output.print("Masukan ID produk : ", Style.BLUE);
		try {
			int id = Integer.valueOf(console.readLine());
			ProductModel product = productService.getById(id);
			Output.println();
			Output.println("ID    : " + product.getId());
			Output.println("Nama  : " + product.getName());
			Output.println("Harga : " + product.getPrice());
		} catch (ProductException e) {
			Output.println();
			Output.println(e.getMessage(), Style.RED);
		} catch (Exception e) {
			Output.println();
			Output.println("ID yang anda masukan tidak valid!", Style.RED);
		}
		Output.println();
	}

	private void create() {
		Output.println("--------------------------------", Style.CYAN);
		Output.println(Icon.CREATE + " Tambah Produk");
		Output.println("--------------------------------", Style.CYAN);
		Output.println();

		ProductModel product = new ProductModel();
		try {
			Output.print("Masukan ID    : ", Style.BLUE);
			product.setId(Integer.valueOf(console.readLine()));

			Output.print("Masukan Nama  : ", Style.BLUE);
			product.setName(console.readLine());

			Output.print("Masukan Harga : ", Style.BLUE);
			product.setPrice(Double.valueOf(console.readLine()));

			productService.create(product);

			Output.println();
			Output.println("Data produk berhasil disimpan !", Style.GREEN);
		} catch (ProductException e) {
			Output.println();
			Output.println(e.getMessage(), Style.RED);
		} catch (Exception e) {
			Output.println();
			Output.println("Error: " + e.getMessage());
		}
		Output.println();
	}

	private void updateById() {
		Output.println("--------------------------------", Style.CYAN);
		Output.println(Icon.EDIT + " Ubah Produk");
		Output.println("--------------------------------", Style.CYAN);
		Output.println();

		try {
			Output.print("Masukan ID produk yang akan diubah : ", Style.BLUE);
			int id = Integer.valueOf(console.readLine());
			ProductModel product = productService.getById(id);

			Output.print("Masukan Nama  : ", Style.BLUE);
			product.setName(console.readLine());

			Output.print("Masukan Harga : ", Style.BLUE);
			product.setPrice(Double.valueOf(console.readLine()));

			productService.updateById(id, product);

			Output.println();
			Output.println("Data produk berhasil disimpan !", Style.GREEN);
		} catch (ProductException e) {
			Output.println();
			Output.println(e.getMessage(), Style.RED);
		} catch (Exception e) {
			Output.println();
			Output.println("Error: " + e.getMessage());
		}
		Output.println();
	}

	private void deleteById() {
		Output.println("--------------------------------", Style.CYAN);
		Output.println(Icon.DELETE + " Hapus Produk");
		Output.println("--------------------------------", Style.CYAN);
		Output.println();
		try {
			Output.print("Masukan ID produk yang akan dihapus : ", Style.BLUE);
			int id = Integer.valueOf(console.readLine());
			ProductModel product = productService.getById(id);

			productService.deleteById(id);

			Output.println();
			Output.println("Data produk berhasil dihapus !", Style.GREEN);
		} catch (ProductException e) {
			Output.println();
			Output.println(e.getMessage(), Style.RED);
		} catch (Exception e) {
			Output.println();
			Output.println("Error: " + e.getMessage());
		}
		Output.println();
	}
}
