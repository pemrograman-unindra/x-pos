package products;

import java.util.List;

// tugas no 4 : Interface, ProductBaseInterface sebagai kontrak untuk penerapan interface
// tugas interface & abstract no 1 : Buatlah sebuah interface yang memiliki satu method abstract 
// Kemudian buatlah dua kelas yang mengimplementasikan interface
public interface ProductBaseInterface<Model> {
	List<Model> getAll();

	Model getByCode(String code);

	void create(Model model);

	void updateByCode(String code, Model model);

	void deleteByCode(String code);
}