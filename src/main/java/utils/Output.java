package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Output {
	public static void print(String text, Style... attribute) {
		String formattedText = fmt(text, attribute);
		System.out.print(formattedText);
	}

	public static void println(String text, Style... attribute) {
		String formattedText = fmt(text, attribute);
		System.out.println(formattedText);
	}

	// tugas no 3 : Overload, menerapkan overload atas create
	public static void println() {
		System.out.println();
	}

	public static String fmt(String text, Style... attribute) {

		// apabila tidak support kode ANSI maka atribut diabaikan
		if (!isSupportANSICode()) {
			return text;
		}

		String format = "0";
		int i = 0;
		for (Style att : attribute) {
			if (++i > 0) {
				format += ";";
			} else {
				format = "";
			}
			format += att.toString();
		}
		return "\033[" + format + "m" + text + "\033[" + Style.RESET + "m";
	}

	// tugas no 2 : Encapsulation, isSupportANSICode menggunakan private untuk
	// membatasi agar hanya bisa diakses dari class yg sama
	private static boolean isSupportANSICode() {

		// Kode ANSI tidak didukung pada terminal default (cmd/powershell) sebelum
		// Windows 10 build 16257
		if (System.getProperty("os.name").toLowerCase().contains("win")) {
			String[] versionParts = System.getProperty("os.version").split("\\.");
			int majorVersion = Integer.parseInt(versionParts[0]);
			if ((majorVersion < 10) || ((majorVersion == 10) && (versionParts.length >= 3)
					&& (Integer.parseInt(versionParts[2]) < 16257))) {
				return false;
			}
			return true;
		}

		String term = System.getenv("TERM");
		if (term == null || "dumb".equals(term)) {
			return false;
		}

		return true;
	}

	public static void clearScreen() {
		try {
			// apabila tidak menggunakan os windows dan support kode ANSI maka clear
			// menggunakan kode ANSI
			if (isSupportANSICode()) {
				System.out.print("\033\143");

				// apabila menggunakan os windows maka lakukan perintah cls di cmd
			} else if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}
		} catch (Exception ex) {
			System.err.println("Tidak bisa clear screen");
		}
	}

	public static String formatNumber(double value) {
		return String.format("%,.0f", value).replace(',', '.');
	}

	// tugas no 3 : Overload, menerapkan overload atas formatNumber
	public static String formatNumber(int value) {
		return formatNumber((double) value);
	}

	public static String formatDateTime(LocalDateTime value) {
		return value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	public static String formatDate(LocalDateTime value) {
		return value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

	public static String formatTime(LocalDateTime value) {
		return value.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}

	// cetak tabel biar rapih
	public static void printTable(TableColumn[] columns, String[][] rows) {

		// table header
		printTableLine(columns);
		String[] header = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			header[i] = columns[i].label;
		}
		printTableRow(columns, header);
		printTableLine(columns);

		// table body
		for (String[] row : rows) {
			printTableRow(columns, row);
		}
		printTableLine(columns);
	}

	// cetak tabel footer biar rapih
	public static void printTableFooter(TableColumn[] columns, String[][] rows) {
		for (String[] row : rows) {
			printTableRow(columns, row);
		}
		printTableLine(columns);
	}

	// tugas no 2 : Encapsulation, printTableLine menggunakan private untuk
	// membatasi agar hanya bisa diakses dari class yg sama
	private static void printTableLine(TableColumn[] columns) {
		for (TableColumn column : columns) {
			print("+-");
			for (int i = 0; i < column.maxLength; i++) {
				print("-");
			}
			print("-");
		}
		println("+");
	}

	// tugas no 2 : Encapsulation, printTableRow menggunakan private untuk membatasi
	// agar hanya bisa diakses dari class yg sama
	private static void printTableRow(TableColumn[] columns, String[] row) {
		int i = 0;
		for (TableColumn column : columns) {
			print("|");
			printTableCell(column.maxLength, row[i]);
			i++;
		}
		println("|");
	}

	// tugas no 2 : Encapsulation, printTableCell menggunakan private untuk
	// membatasi agar hanya bisa diakses dari class yg sama
	private static void printTableCell(int length, String text) {
		int textLength = text.length();
		int maxLength = (length - textLength + 1);

		// untuk angka maka rata kanan
		if (textLength > 0 && ((text.charAt(0) >= '0' && text.charAt(0) <= '9') || text.charAt(0) == '-')) {
			for (int i = 0; i < maxLength; i++) {
				print(" ");
			}
			print(text);
			print(" ");

			// untuk selain angka maka rata kiri
		} else {
			print(" ");
			print(text);
			for (int i = 0; i < maxLength; i++) {
				print(" ");
			}
		}
	}
}
