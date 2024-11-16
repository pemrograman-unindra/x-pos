package trx;

// tugas no 1 : Inheritance, TrxException mewarisi RuntimeException sehingga memiliki sifat dasar exception yang digunakan pada proses error handling
public class TrxException extends RuntimeException {

	// Constructor untuk inisialisasi objek TrxException, memanggil constructor
	// superclass
	public TrxException(String message) {
		super(message);
	}
}
