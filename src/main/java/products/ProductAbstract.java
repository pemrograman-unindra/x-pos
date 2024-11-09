package products;

// tugas no 2 : Encapsulation, ProductAbstract menggunakan protected untuk membatasi agar hanya bisa diakses dari package yang sama
// tugas no 5 : Abstract, ProductAbstract menerapkan abstract sebagai kelas dasar bagi ProductModel
public abstract class ProductAbstract {

	// tugas no 2 : Encapsulation, semua attribute dibatasi hanya bisa diakses dari kelas ini, diakses menggunakan getter & setter
	protected int id;
	protected String name;
	protected double price;

	// Constructor
	public ProductAbstract(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	// Getter
	public int getId() { return id; }
	public String getName() { return name; }
	public double getPrice() { return price; }

	// Setter
	// tugas no 5 : Abstract, metode abstrak yang harus diimplementasikan pada kelas turunannya
	public abstract void setId(int id);
	public abstract void setName(String name);
	public abstract void setPrice(double price);
}
