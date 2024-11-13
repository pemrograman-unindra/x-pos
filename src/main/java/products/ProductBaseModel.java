package products;

// tugas no 5 : Abstract, ProductBaseModel menerapkan abstract sebagai kelas dasar bagi ProductModel dan ProductCategoryModel
// tugas interface & abstract no 2 : Buatlah sebuah abstract class dengan satu method abstract satu method konkret 
// Kemudian buatlah dua kelas turunan yang mengimplementasikan method tersebut
public abstract class ProductBaseModel {

	// tugas no 2 : Encapsulation, attribute menggunakan protected untuk membatasi
	// agar hanya bisa diakses dari subclass dan package yg sama
	protected String code;
	protected String name;

	// Constructor
	public ProductBaseModel(String code, String name) {
		this.code = code;
		this.name = name;
	}

	// Getter
	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	// Setter
	// tugas no 5 : Abstract, metode abstrak yang harus diimplementasikan pada kelas
	// turunannya
	public abstract void setCode(String code);

	public abstract void setName(String name);
}
