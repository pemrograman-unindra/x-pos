package trx;

import java.util.List;

// tugas no 4 : Interface, TrxBaseInterface sebagai kontrak untuk penerapan interface
// tugas interface & abstract no 1 : Buatlah sebuah interface yang memiliki satu method abstract 
// Kemudian buatlah dua kelas yang mengimplementasikan interface
public interface TrxBaseInterface<Model> {
	List<Model> getAll();

	Model getByNumber(int number);

	void create(Model model);

	void updateByNumber(int number, Model model);

	void deleteByNumber(int number);
}