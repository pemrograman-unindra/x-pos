package utils;

// pada windows, agar bisa menampilkan icon maka perlu mengaktifkan dukungan unicode UTF-8 :
// Region > Administratif > Change System Locale > centang opsi "Beta: Use Unicode UTF-8 for worldwide language support" > OK
public enum Icon {
	LOCKED("🔐"),
	UNLOCKED("🔓"),
	MENU("🗂️"),
	PRODUCT("📦"),
	PRODUCT_CATEGORY("📥"),
	SALES("🛍️"),
	EXIT("📴"),
	LIST("📋"),
	FIND("🔍"),
	CREATE("🆕"),
	EDIT("📝"),
	DELETE("❌");

	// tugas no 2 : Encapsulation, value menggunakan private untuk membatasi agar
	// hanya bisa diakses dari class yg sama
	private final String value;

	Icon(String value) {
		this.value = value;
	}

	// tugas no 3 : Override, mengganti nilai yang dikembalikan dari toString bawaan
	// enum
	@Override
	public String toString() {
		return value;
	}
}
