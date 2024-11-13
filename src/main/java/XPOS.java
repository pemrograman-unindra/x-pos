import products.ProductCLIController;
import products.ProductCategoryCLIController;
import users.User;
import utils.Icon;
import utils.Input;
import utils.Output;
import utils.Style;

public class XPOS {
	private static User user = new User("admin", "1234");
	private static ProductCLIController productCLI = new ProductCLIController();
	private static ProductCategoryCLIController productCategoryCLI = new ProductCategoryCLIController();

	public static void main(String[] args) {
		Output.clearScreen();
		Output.println("                                ", Style.BG_CYAN);
		Output.println("     X-POS - Point Of Sales     ", Style.BG_CYAN, Style.BLINK_SLOW);
		Output.println("                                ", Style.BG_CYAN);
		Output.println();
		login();
	}

	public static void login() {
		Output.println("Silakan login. " + Icon.LOCKED);
		Output.println();

		Output.print("Username : ", Style.BLUE);
		String username = Input.readString();

		Output.print("Password : ", Style.BLUE);
		String password = Input.readPassword();

		try {
			user.login(username, password);
			Output.println("Login berhasil! " + Icon.UNLOCKED, Style.GREEN);
			Output.println();
			Input.hold();
			menu();
		} catch (Exception e) {
			Output.println(e.getMessage(), Style.RED);
			Output.println();
			login();
		}
	}

	public static void menu() {
		int choice;
		do {
			Output.clearScreen();
			Output.println("--------------------------------", Style.CYAN);
			Output.println(Icon.MENU + " Menu");
			Output.println("--------------------------------", Style.CYAN);
			Output.println();
			Output.println("1. Produk " + Icon.PRODUCT);
			Output.println("2. Kategori Produk " + Icon.PRODUCT_CATEGORY);
			Output.println("3. Penjualan " + Icon.SALES);
			Output.println();
			Output.println("0. Keluar " + Icon.EXIT);
			Output.println();
			Output.print("Silakan pilih menu (0-2) : ", Style.BLUE);
			try {
				choice = Input.readInteger();
			} catch (Exception e) {
				choice = -1;
			}

			Output.println();
			switch (choice) {
				case 0 -> Output.println("Selamat tinggal! " + Icon.EXIT);
				case 1 -> productCLI.menu();
				case 2 -> productCategoryCLI.menu();
				case 3 -> productCLI.menu();
				default -> Output.println("Pilihan tidak valid!", Style.RED);
			}
		} while (choice != 0);
	}
}
