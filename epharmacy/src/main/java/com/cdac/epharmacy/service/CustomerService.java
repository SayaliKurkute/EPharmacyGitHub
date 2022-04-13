package com.cdac.epharmacy.service;

import com.cdac.epharmacy.dto.ProductCart;
import com.cdac.epharmacy.dto.SubmitOrder;
import com.cdac.epharmacy.dto.UserDetails;
import com.cdac.epharmacy.models.Category;
import com.cdac.epharmacy.models.Order;
import com.cdac.epharmacy.models.Product;

import java.util.List;

public interface CustomerService {
	List<Product> getAllProduct(long categoryId);
	Product getProductById(long productId);
	String addProductToCart(ProductCart c);
	Order getCartByuserId(long userId);
	String deleteItemFromCart(long orderItemId);
	List<Category> getAllCategoryList();
	String submitOrder(SubmitOrder order);
	
	List<Order> getPendingOrders();
	
	List<Order> getDeliveredOrders();
	/*List<Product> getProductListByName(String productName);
	
	//int addOrder(int userId, double totalPrice);
	
	//int addOrdersDetails(int userId, int OrderId);
	//List<Orders> getOrdersList(int userId);
	//List<OrderDetails> getOrdersDetailsList(int orderId);
	
	//String updateCartItems(int userId);
	
	String deliveredOrder(int orderId);
	
	List<Orders> getAllOrderList();
	
	List<Product> getProductsForHomePage();
	
	int addOrderAddress(OrderAddress oa);*/
	Order getOrderDetails(Long orderId);
	String deliverOrder(SubmitOrder order);
	List<Order> getAllOrderDetailsUserId(long userId);
	UserDetails getUserDetails(long orderId);

}
