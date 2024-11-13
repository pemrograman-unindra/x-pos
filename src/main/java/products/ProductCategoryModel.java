package products;

// tugas no 1 : Inheritance, ProductCategoryModel mewarisi ProductBaseModel
// tugas no 5 : Abstract, ProductBaseModel menerapkan abstract sebagai kelas dasar bagi ProductModel dan ProductCategoryModel
// tugas interface & abstract no 2 : Buatlah sebuah abstract class dengan satu method abstract satu method konkret 
// Kemudian buatlah dua kelas turunan yang mengimplementasikan method tersebut
public class ProductCategoryModel extends ProductBaseModel {

	private String rack;

	// Constructor untuk inisialisasi objek ProductCategoryModel, memanggil
	// constructor superclass
	public ProductCategoryModel(String code, String name, String rack) {
		super(code, name);
		this.rack = rack;
	}

	// tugas no 3 : Overload
	public ProductCategoryModel() {
		super("", "");
	}

	public String getRack() {
		return rack;
	}

	// tugas no 3 : Override, menerapkan metode abstrak setId dari ProductBaseModel
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

	public void setRack(String rack) {
		if (rack == "") {
			throw new ProductException("Nomor rak tidak boleh kosong!");
		}
		this.rack = rack;
	}
}
