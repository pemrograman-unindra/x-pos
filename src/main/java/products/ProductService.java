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

	// tugas no 3 : Override, menerapkan getBySKU yang didefinisikan pada ProductInterface
	@Override
	public ProductModel getBySKU(int sku) {
		ProductModel product = products.stream().filter(p -> p.getSKU() == sku).findFirst().orElse(null);
		if (product == null) {
			throw new ProductException("Produk dengan sku " + sku + " tidak ditemukan!");
		}
		return product;
	}

	// tugas no 3 : Override, menerapkan create yang didefinisikan pada ProductInterface
	@Override
	public void create(ProductModel product) {
		validate(0, product);
		products.add(product);
	}

	// tugas no 3 : Overload, menerapkan overload atas create
	public void create(int sku, String name, double price) {
		ProductModel product = new ProductModel(sku, name, price);
		create(product);
	}

	// tugas no 3 : Override, menerapkan update yang didefinisikan pada ProductInterface
	@Override
	public void updateBySKU(int sku, ProductModel product) {
		ProductModel existingProduct = getBySKU(sku);
		validate(sku, product);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
	}

	// tugas no 3 : Override, menerapkan method yang didefinisikan pada ProductInterface
	@Override
	public void deleteBySKU(int sku) {
		ProductModel product = getBySKU(sku);
		products.remove(product);
	}

	// tugas no 2 : Encapsulation, validate dibatasi hanya bisa diakses dari kelas ini
	private void validate(int sku, ProductModel product) {
		int newSKU = product.getSKU();
		if (newSKU <= 0) {
			throw new ProductException("SKU harus lebih besar dari 0!");
		}
		if (sku != newSKU && products.stream().anyMatch(p -> p.getSKU() == newSKU)) {
			throw new ProductException("SKU harus unik!");
		}
		if (product.getName() == null || product.getName().isEmpty()) {
			throw new ProductException("Nama tidak boleh kosong!");
		}
		if (product.getPrice() <= 0) {
			throw new ProductException("Harga harus lebih besar dari 0!");
		}
	}
}
