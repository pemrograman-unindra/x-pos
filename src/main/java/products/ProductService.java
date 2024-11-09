package products;

import java.util.ArrayList;
import java.util.List;

// tugas no 3 : Polymorphism, ProductService bisa digunakan sebagai ProductInterface, memungkinkan pemanggilan metode yang sama (polymorphism).
// tugas no 4 : Interface, ProductService menerapkan interface ProductInterface
public class ProductService implements ProductInterface {

	// tugas no 2 : Encapsulation, products dibatasi hanya bisa diakses dari kelas ini
	private List<ProductModel> products = new ArrayList<>();

	// tugas no 3 : Override, menerapkan getAll yang didefinisikan pada ProductInterface
	@Override
	public List<ProductModel> getAll() {
		return products;
	}

	// tugas no 3 : Override, menerapkan getById yang didefinisikan pada ProductInterface
	@Override
	public ProductModel getById(int id) {
		ProductModel product = products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
		if (product == null) {
			throw new ProductException("Produk dengan id " + id + "tidak ditemukan!");
		}
		return product;
	}

	// tugas no 3 : Override, menerapkan create yang didefinisikan pada ProductInterface
	@Override
	public void create(ProductModel product) {
		validate(product);
		products.add(product);
	}

	// tugas no 3 : Overload, menerapkan overload atas create
	public void create(int id, String name, double price) {
		ProductModel product = new ProductModel(id, name, price);
		create(product);
	}

	// tugas no 3 : Override, menerapkan update yang didefinisikan pada ProductInterface
	@Override
	public void updateById(int id, ProductModel product) {
		ProductModel existingProduct = getById(id);
		validate(product);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
	}

	// tugas no 3 : Override, menerapkan method yang didefinisikan pada ProductInterface
	@Override
	public void deleteById(int id) {
		ProductModel product = getById(id);
		products.remove(product);
	}

	// tugas no 2 : Encapsulation, validate dibatasi hanya bisa diakses dari kelas ini
	private void validate(ProductModel product) {
		if (products.stream().anyMatch(p -> p.getId() == product.getId())) {
			throw new ProductException("ID produk harus unik!");
		}
		if (product.getName() == null || product.getName().isEmpty()) {
			throw new ProductException("Nama produk tidak boleh kosong!");
		}
		if (product.getPrice() <= 0) {
			throw new ProductException("Harga produk harus lebih besar dari 0!");
		}
	}
}
