package utils;

import java.io.Console;

public class Input {

	// tugas no 2 : Encapsulation, console menggunakan private untuk membatasi agar
	// hanya bisa diakses dari class yg sama
	private static Console console = System.console();

	public static void hold() {
		Output.print("Tekan enter untuk melanjutkan.", Style.BLINK_RAPID);
		console.readLine();
	}

	public static String readString() {
		return console.readLine();
	}

	public static String readPassword() {
		char[] passwordArray = console.readPassword();
		return new String(passwordArray);
	}

	public static int readInteger() {
		String val = console.readLine();
		try {
			return Integer.valueOf(val);
		} catch (Exception e) {
			throw new RuntimeException(val + " bukan angka yang valid!");
		}
	}

	public static double readDouble() {
		String val = console.readLine();
		try {
			return Double.valueOf(val);
		} catch (Exception e) {
			throw new RuntimeException(val + " bukan angka yang valid!");
		}
	}

	public static boolean readBoolean() {
		String val = console.readLine();
		if (val.equalsIgnoreCase("y") || val.equalsIgnoreCase("true") || val.equalsIgnoreCase("t")
				|| val.equalsIgnoreCase("1")) {
			return true;
		}
		return false;
	}
}
