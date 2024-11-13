package products;

import java.util.ArrayList;
import java.util.List;

// tugas no 3 : Polymorphism, ProductService bisa digunakan sebagai ProductBaseInterface, memungkinkan pemanggilan metode yang sama (polymorphism).
// tugas no 4 : Interface, ProductService menerapkan interface ProductBaseInterface
// tugas interface & abstract no 1 : Buatlah sebuah interface yang memiliki satu method abstract 
// Kemudian buatlah dua kelas yang mengimplementasikan interface
public class ProductCategoryService implements ProductBaseInterface<ProductCategoryModel> {

	public static ProductCategoryService useCase = new ProductCategoryService();

	// tugas no 2 : Encapsulation, products dibatasi hanya bisa diakses dari kelas
	// ini
	private List<ProductCategoryModel> productCategories = new ArrayList<>();

	// tugas no 3 : Override, menerapkan getAll yang didefinisikan pada
	// ProductBaseInterface
	@Override
	public List<ProductCategoryModel> getAll() {
		return productCategories;
	}

	// tugas no 3 : Override, menerapkan getByCode yang didefinisikan pada
	// ProductBaseInterface
	@Override
	public ProductCategoryModel getByCode(String code) {
		ProductCategoryModel productCategory = productCategories.stream()
				.filter(p -> p.getCode().equals(code))
				.findFirst()
				.orElse(null);
		if (productCategory == null) {
			throw new ProductException("Kategori produk dengan kode " + code + " tidak ditemukan!");
		}
		return productCategory;
	}

	// tugas no 3 : Override, menerapkan create yang didefinisikan pada
	// ProductBaseInterface
	@Override
	public void create(ProductCategoryModel productCategory) {
		validate("", productCategory);
		productCategories.add(productCategory);
	}

	// tugas no 3 : Overload, menerapkan overload atas create
	public void create(String code, String name, String rack) {
		ProductCategoryModel product = new ProductCategoryModel(code, name, rack);
		create(product);
	}

	// tugas no 3 : Override, menerapkan update yang didefinisikan pada
	// ProductBaseInterface
	@Override
	public void updateByCode(String code, ProductCategoryModel productCategory) {
		ProductCategoryModel existingProduct = getByCode(code);
		validate(code, productCategory);
		existingProduct.setName(productCategory.getName());
	}

	// tugas no 3 : Override, menerapkan method yang didefinisikan pada
	// ProductBaseInterface
	@Override
	public void deleteByCode(String code) {
		ProductCategoryModel product = getByCode(code);
		productCategories.remove(product);
	}

	// tugas no 2 : Encapsulation, validate dibatasi hanya bisa diakses dari kelas
	// ini
	private void validate(String code, ProductCategoryModel product) {
		String newCode = product.getCode();
		if (newCode.equals("")) {
			throw new ProductException("Kode tidak boleh kosong!");
		}
		if (!code.equals(newCode) && productCategories.stream().anyMatch(p -> p.getCode().equals(newCode))) {
			throw new ProductException("Kode harus unik!");
		}
		if (product.getName() == null || product.getName().isEmpty()) {
			throw new ProductException("Nama tidak boleh kosong!");
		}
	}
}
