package trx;

import java.util.ArrayList;
import java.util.List;

// tugas no 3 : Polymorphism, SalesService bisa digunakan sebagai TrxBaseInterface, memungkinkan pemanggilan metode yang sama (polymorphism).
// tugas no 4 : Interface, SalesService menerapkan interface TrxBaseInterface
// tugas interface & abstract no 1 : Buatlah sebuah interface yang memiliki satu method abstract 
// Kemudian buatlah dua kelas yang mengimplementasikan interface
public class SalesService implements TrxBaseInterface<SalesModel> {

	public static SalesService useCase = new SalesService();

	// tugas no 2 : Encapsulation, sales dibatasi hanya bisa diakses dari kelas ini
	private List<SalesModel> sales = new ArrayList<>();

	// tugas no 3 : Override, menerapkan getAll yang didefinisikan pada
	// TrxBaseInterface
	@Override
	public List<SalesModel> getAll() {
		return sales;
	}

	// tugas no 3 : Override, menerapkan getByCode yang didefinisikan pada
	// TrxBaseInterface
	@Override
	public SalesModel getByNumber(int number) {
		SalesModel sale = sales.stream()
				.filter(p -> p.getNumber() == number)
				.findFirst()
				.orElse(null);
		if (sale == null) {
			throw new TrxException("Transaksi dengan nomor referensi " + number + " tidak ditemukan!");
		}
		return sale;
	}

	// tugas no 3 : Override, menerapkan create yang didefinisikan pada
	// TrxBaseInterface
	@Override
	public void create(SalesModel sale) {
		validate(0, sale);
		sales.add(sale);
	}

	// tugas no 3 : Override, menerapkan update yang didefinisikan pada
	// TrxBaseInterface
	@Override
	public void updateByNumber(int number, SalesModel sale) {
		SalesModel existingSale = getByNumber(number);
		validate(number, sale);
		existingSale.setItems(sale.getItems());
	}

	// tugas no 3 : Override, menerapkan method yang didefinisikan pada
	// TrxBaseInterface
	@Override
	public void deleteByNumber(int number) {
		SalesModel sale = getByNumber(number);
		sales.remove(sale);
	}

	// tugas no 2 : Encapsulation, validate dibatasi hanya bisa diakses dari kelas
	// ini
	private void validate(int number, SalesModel sale) {
		int newCode = sale.getNumber();
		if (newCode == 0) {
			throw new TrxException("Nomor referensi tidak boleh kosong!");
		}
		if (number != newCode && sales.stream().anyMatch(p -> p.getNumber() == newCode)) {
			throw new TrxException("Nomor referensi harus unik!");
		}
	}
}
