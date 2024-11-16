package trx;

import java.util.ArrayList;
import java.util.List;

// tugas no 1 : Inheritance, SalesModel mewarisi TrxBaseModel
// tugas no 5 : Abstract, TrxBaseModel menerapkan abstract sebagai kelas dasar bagi SalesModel dan ProductCategoryModel
// tugas interface & abstract no 2 : Buatlah sebuah abstract class dengan satu method abstract satu method konkret 
// Kemudian buatlah dua kelas turunan yang mengimplementasikan method tersebut
public class SalesModel extends TrxBaseModel<SalesItemModel> {

	// tugas no 2 : Encapsulation, amount dibatasi hanya bisa diakses dari kelas
	// ini
	private double amount = 0;
	private List<SalesItemModel> items = new ArrayList<>();

	public SalesModel() {
		super();
	}

	public double getAmount() {
		return amount;
	}

	// tugas no 3 : Override, menerapkan metode abstrak addItem dari
	// TrxBaseModel
	@Override
	public void addItem(SalesItemModel item) {
		items.add(item);
		amount += item.getQty() * item.getProduct().getPrice();
	}

	// tugas no 3 : Override, menerapkan metode abstrak addItem dari
	// TrxBaseModel
	public List<SalesItemModel> getItems() {
		return items;
	}

	public void setItems(List<SalesItemModel> items) {
		amount = 0;
		this.items = items;
		for (SalesItemModel item : items) {
			amount += item.getQty() * item.getProduct().getPrice();
		}
	}
}
