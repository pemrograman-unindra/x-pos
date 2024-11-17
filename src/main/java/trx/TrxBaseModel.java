package trx;

import java.time.LocalDateTime;
import java.util.List;

import utils.Output;

// tugas no 5 : Abstract, TrxBaseModel menerapkan abstract sebagai kelas dasar bagi ProductModel dan ProductCategoryModel
// tugas interface & abstract no 2 : Buatlah sebuah abstract class dengan satu method abstract satu method konkret 
// Kemudian buatlah dua kelas turunan yang mengimplementasikan method tersebut
public abstract class TrxBaseModel<ItemModel> {

	// tugas no 2 : Encapsulation, attribute menggunakan protected untuk membatasi
	// agar hanya bisa diakses dari subclass dan package yg sama
	private static int lastNumber = 1;
	private int number;
	private LocalDateTime dateTime;

	// Constructor
	public TrxBaseModel() {
		this.number = lastNumber++;
		this.dateTime = LocalDateTime.now();
	}

	// Getter
	public int getNumber() {
		return number;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public String getDate() {
		return Output.formatDate(dateTime);
	}

	public String getTime() {
		return Output.formatTime(dateTime);
	}

	// Setter
	// tugas no 5 : Abstract, metode abstrak yang harus diimplementasikan pada kelas
	// turunannya
	public abstract void addItem(ItemModel item);

	// tugas no 5 : Abstract, metode abstrak yang harus diimplementasikan pada kelas
	// turunannya
	public abstract List<ItemModel> getItems();
}
