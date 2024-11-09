package products;

import java.util.List;

// tugas no 4 : Interface, ProductInterface sebagai kontrak untuk penerapan interface
public interface ProductInterface {
	List<ProductModel> getAll();
	ProductModel getById(int id);
	void create(ProductModel produk);
	void updateById(int id, ProductModel produk);
	void deleteById(int id);
}
