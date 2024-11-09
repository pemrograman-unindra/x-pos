import java.io.Console;
import products.ProductCLIController;
import users.User;
import utils.Icon;
import utils.Output;
import utils.Style;

public class XPOS {
	private static Console console = System.console();
	private static User user = new User("admin", "1234");
	private static ProductCLIController productCLI = new ProductCLIController();

	public static void main(String[] args) {
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
		String username = console.readLine();

		Output.print("Password : ", Style.BLUE);
		char[] passwordArray = console.readPassword();
		String password = new String(passwordArray);

		try {
			user.login(username, password);
			Output.println("Login berhasil! " + Icon.UNLOCKED);
			Output.println();
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
			Output.println("--------------------------------", Style.CYAN);
			Output.println(Icon.MENU + " Menu");
			Output.println("--------------------------------", Style.CYAN);
			Output.println();
			Output.println("1. Produk " + Icon.PRODUCT);
			Output.println("2. Penjualan " + Icon.SALES);
			Output.println();
			Output.println("0. Keluar " + Icon.EXIT);
			Output.println();
			Output.print("Silakan pilih menu (0-2) : ", Style.BLUE);
			try {
				choice = Integer.parseInt(console.readLine());
			} catch (Exception e) {
				choice = -1;
			}

			Output.println();
			switch (choice) {
				case 0 -> Output.println("Selamat tinggal! " + Icon.EXIT);
				case 1 -> productCLI.menu();
				case 2 -> productCLI.menu();
				default -> Output.println("Pilihan tidak valid!", Style.RED);
			}
		} while (choice != 0);
	}
}
