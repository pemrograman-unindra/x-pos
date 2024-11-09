package utils;

import java.nio.charset.Charset;

// pada windows, agar bisa menampilkan icon maka perlu mengaktifkan dukungan unicode UTF-8 :
// Region > Administratif > Change System Locale > centang opsi "Beta: Use Unicode UTF-8 for worldwide language support" > OK
public enum Icon {
	LOCKED("🔐"),
	UNLOCKED("🔓"),
	MENU("🗂️"),
	PRODUCT("📦"),
	SALES("🛍️"),
	EXIT("📴"),
	LIST("📋"),
	FIND("🔍"),
	CREATE("🆕"),
	EDIT("📝"),
	DELETE("❌");

	private final String value;

	Icon(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
