package utils;

public enum Icon {
	LIST("🗂️"),
	DETAIL("📋"),
	ADD("➕"),
	EDIT("📝"),
	DELETE("❌");

	private final String value;

	Icon(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		// jika tidak support utf-8 maka return ""
		return String.valueOf(value);
	}
}