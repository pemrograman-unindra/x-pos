package utils;

public class Style {
	public static void printf(String text, Color... attribute) {

		// apabila tidak support kode ANSI maka atribut diabaikan
		if (!isSupportANSICode()) {
			System.out.print(text);
			return;
		}

		String format = "0";
		int i = 0;
		for (Color att : attribute) {
			if (++i > 0) {
				format += ";";
			} else {
				format = "";
			}
			format += att.toString();
		}
		System.out.print("\033["+format+"m"+text+"\033[0m");
	}

	private static boolean isSupportANSICode() {

		// Kode ANSI tidak didukung pada terminal default (cmd/powershell) sebelum Windows 10 build 16257
		if (System.getProperty("os.name").toLowerCase().contains("win")) {
			String[] versionParts = System.getProperty("os.version").split("\\.");
			int majorVersion = Integer.parseInt(versionParts[0]);
			if ((majorVersion < 10) || ((majorVersion == 10) && (versionParts.length >= 3) && (Integer.parseInt(versionParts[2]) < 16257))) {
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
}