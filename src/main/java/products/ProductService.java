package products;

import java.util.ArrayList;
import java.util.List;

// tugas no 3 : Polymorphism, ProductService bisa digunakan sebagai ProductBaseInterface, memungkinkan pemanggilan metode yang sama (polymorphism).
// tugas no 4 : Interface, ProductService menerapkan interface ProductBaseInterface
// tugas interface & abstract no 1 : Buatlah sebuah interface yang memiliki satu method abstract 
// Kemudian buatlah dua kelas yang mengimplementasikan interface
public class ProductService implements ProductBaseInterface<ProductModel> {

	public static ProductService useCase = new ProductService();

	// tugas no 2 : Encapsulation, products dibatasi hanya bisa diakses dari kelas
	// ini
	private List<ProductModel> products = new ArrayList<>();

	// tugas no 3 : Override, menerapkan getAll yang didefinisikan pada
	// ProductBaseInterface
	@Override
	public List<ProductModel> getAll() {
		return products;
	}

	// tugas no 3 : Override, menerapkan getByCode yang didefinisikan pada
	// ProductBaseInterface
	@Override
	public ProductModel getByCode(String code) {
		ProductModel product = products.stream()
				.filter(p -> p.getCode().equals(code))
				.findFirst()
				.orElse(null);
		if (product == null) {
			throw new ProductException("Produk dengan kode " + code + " tidak ditemukan!");
		}
		return product;
	}

	// tugas no 3 : Override, menerapkan create yang didefinisikan pada
	// ProductBaseInterface
	@Override
	public void create(ProductModel product) {
		validate("", product);
		products.add(product);
	}

	// tugas no 3 : Overload, menerapkan overload atas create
	public void create(String code, String name, double price) {
		ProductModel product = new ProductModel(code, name, price);
		create(product);
	}

	// tugas no 3 : Override, menerapkan update yang didefinisikan pada
	// ProductBaseInterface
	@Override
	public void updateByCode(String code, ProductModel product) {
		ProductModel existingProduct = getByCode(code);
		validate(code, product);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
	}

	// tugas no 3 : Override, menerapkan method yang didefinisikan pada
	// ProductBaseInterface
	@Override
	public void deleteByCode(String code) {
		ProductModel product = getByCode(code);
		products.remove(product);
	}

	// tugas no 2 : Encapsulation, validate dibatasi hanya bisa diakses dari kelas
	// ini
	private void validate(String code, ProductModel product) {
		String newCode = product.getCode();
		if (newCode.equals("")) {
			throw new ProductException("Kode tidak boleh kosong!");
		}
		if (!code.equals(newCode) && products.stream().anyMatch(p -> p.getCode().equals(newCode))) {
			throw new ProductException("Kode harus unik!");
		}
		if (product.getName() == null || product.getName().isEmpty()) {
			throw new ProductException("Nama tidak boleh kosong!");
		}
		if (product.getPrice() <= 0) {
			throw new ProductException("Harga harus lebih besar dari 0!");
		}
	}
}
