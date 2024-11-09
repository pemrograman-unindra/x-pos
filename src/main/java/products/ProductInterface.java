package products;

import java.util.List;

// tugas no 4 : Interface, ProductInterface sebagai kontrak untuk penerapan interface
public interface ProductInterface {
	List<ProductModel> getAll();
	ProductModel getBySKU(int id);
	void create(ProductModel produk);
	void updateBySKU(int id, ProductModel produk);
	void deleteBySKU(int id);
}
