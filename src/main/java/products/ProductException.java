package products;

// tugas no 1 : Inheritance, ProductException mewarisi RuntimeException sehingga memiliki sifat dasar exception yang digunakan pada proses error handling
public class ProductException extends RuntimeException {

	// Constructor untuk inisialisasi objek ProductException, memanggil constructor superclass
	public ProductException(String message) {
		super(message);
	}
}
