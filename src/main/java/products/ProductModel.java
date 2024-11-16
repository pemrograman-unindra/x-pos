package products;

// tugas no 1 : Inheritance, ProductModel mewarisi ProductBaseModel
// tugas no 5 : Abstract, ProductBaseModel menerapkan abstract sebagai kelas dasar bagi ProductModel dan ProductCategoryModel
// tugas interface & abstract no 2 : Buatlah sebuah abstract class dengan satu method abstract satu method konkret 
// Kemudian buatlah dua kelas turunan yang mengimplementasikan method tersebut
public class ProductModel extends ProductBaseModel {

	private double price;
	private ProductCategoryModel category;

	// Constructor untuk inisialisasi objek ProductModel, memanggil constructor
	// superclass
	public ProductModel(String code, String name, double price) {
		super(code, name);
		this.price = price;
	}

	// tugas no 3 : Overload
	public ProductModel() {
		super("", "");
	}

	public double getPrice() {
		return price;
	}

	public ProductCategoryModel getCategory() {
		return category;
	}

	// tugas no 3 : Override, menerapkan metode abstrak setCode dari
	// ProductBaseModel
	@Override
	public void setCode(String code) {
		if (code == "") {
			throw new ProductException("Kode produk tidak boleh kosong!");
		}
		this.code = code;
	}

	// tugas no 3 : Override, menerapkan metode abstrak setName dari
	// ProductBaseModel
	@Override
	public void setName(String name) {
		if (name == "") {
			throw new ProductException("Nama produk tidak boleh kosong!");
		}
		this.name = name;
	}

	public void setPrice(double price) {
		if (price <= 0) {
			throw new ProductException("Harga produk harus lebih besar dari 0!");
		}
		this.price = price;
	}

	public void setCategory(ProductCategoryModel category) {
		if (category == null) {
			throw new ProductException("Kategori produk tidak boleh kosong!");
		}
		this.category = category;
	}
}
