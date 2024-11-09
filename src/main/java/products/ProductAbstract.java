package products;

// tugas no 5 : Abstract, ProductAbstract menerapkan abstract sebagai kelas dasar bagi ProductModel
public abstract class ProductAbstract {

	// tugas no 2 : Encapsulation, attribute menggunakan protected untuk membatasi agar hanya bisa diakses dari subclass dan package yg sama
	protected int sku;
	protected String name;
	protected double price;

	// Constructor
	public ProductAbstract(int sku, String name, double price) {
		this.sku = sku;
		this.name = name;
		this.price = price;
	}

	// Getter
	public int getSKU() { return sku; }
	public String getName() { return name; }
	public double getPrice() { return price; }

	// Setter
	// tugas no 5 : Abstract, metode abstrak yang harus diimplementasikan pada kelas turunannya
	public abstract void setSKU(int sku);
	public abstract void setName(String name);
	public abstract void setPrice(double price);
}
