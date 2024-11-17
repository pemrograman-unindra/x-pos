package utils;

public class TableColumn {
	public String label;
	public int maxLength;

	public TableColumn(String label) {
		this.label = label;
		this.maxLength = label.length();
	}

	public TableColumn(int maxLength) {
		this.maxLength = maxLength;
	}
}
