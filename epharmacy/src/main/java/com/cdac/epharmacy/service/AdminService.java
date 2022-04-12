package com.cdac.epharmacy.service;

import java.util.List;

import com.cdac.epharmacy.models.Category;
import com.cdac.epharmacy.models.Product;

public interface AdminService {

	Category addCategoryToInventory(Category category);

	Product addProductToInventory(Long categoryId, Product product);
	
	Product updateProductToInventory(Long productId, Product product);

	public Long deleteProductToInventory(Long productId);

	List<Product> getAllProducts();
	
	/*List<?> getAllProductsBySupplier(int supplierId);

	String getProductCategoryName(int supplierId);	
	
	Product getProductById(int productId);
	
	String updateProduct(int productId, Product product);
	
	Product addProduct(String CategoryName, Product product);
	
	SuppliedProduct addProductBySupplier(String CategoryName, SuppliedProduct product);
	
	String deleteProduct(int productId);
	
	List<SuppliedProduct> getSuppliedProducts(int supplierId);
	
	String deleteFromSuppliedProducts(int productId);*/

}
