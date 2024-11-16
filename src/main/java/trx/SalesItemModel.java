package trx;

import products.ProductModel;

public class SalesItemModel {

	// tugas no 2 : Encapsulation, attribute dibatasi hanya bisa diakses dari kelas
	// ini
	private ProductModel product;
	private double qty;
	private String note;

	public SalesItemModel() {
	}

	public ProductModel getProduct() {
		return product;
	}

	public double getQty() {
		return qty;
	}

	public String getNote() {
		if (note == null) {
			return "";
		}
		return note;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public void setQty(double qty) {
		if (qty <= 0) {
			throw new TrxException("Jumlah harus lebih besar dari 0!");
		}
		this.qty = qty;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
