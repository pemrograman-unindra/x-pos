package products;

// tugas no 1 : Inheritance, ProductModel mewarisi ProductAbstract
public class ProductModel extends ProductAbstract {

	// Constructor untuk inisialisasi objek ProductModel, memanggil constructor superclass
	public ProductModel(int id, String name, double price) {
		super(id, name, price);
	}

	// tugas no 3 : Overload
	public ProductModel() {
		super(0, "", 0);
	}

	// tugas no 3 : Override, menerapkan metode abstrak setId dari ProductAbstract
	@Override
	public void setId(int id) {
		if (id <= 0) {
			throw new ProductException("ID produk harus lebih besar dari 0!");
		}
		this.id = id;
	}

	// tugas no 3 : Override, menerapkan metode abstrak setName dari ProductAbstract
	@Override
	public void setName(String name) {
		if (name == "") {
			throw new ProductException("Nama produk tidak boleh kosong!");
		}
		this.name = name;
	}

	// tugas no 3 : Override, menerapkan metode abstrak setPrice dari ProductAbstract
	@Override
	public void setPrice(double price) {
		if (price <= 0) {
			throw new ProductException("Harga produk harus lebih besar dari 0!");
		}
		this.price = price;
	}
}
