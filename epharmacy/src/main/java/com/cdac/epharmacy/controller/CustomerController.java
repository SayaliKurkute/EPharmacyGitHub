package com.cdac.epharmacy.controller;

import com.cdac.epharmacy.dto.ProductCart;
import com.cdac.epharmacy.dto.ResponseDTO;
import com.cdac.epharmacy.dto.SubmitOrder;
import com.cdac.epharmacy.dto.UserDetails;
import com.cdac.epharmacy.models.Category;
import com.cdac.epharmacy.models.Order;
import com.cdac.epharmacy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@CrossOrigin
public class CustomerController {
	
	@Autowired
	private CustomerService custService;

	@GetMapping("/product/list/{categoryId}")
	public ResponseDTO<?> getAllProductList(@PathVariable long categoryId){
		System.out.println("in getAllProductList: "+categoryId);
		try {		
			return new ResponseDTO<>(HttpStatus.OK, "Product List Added", custService.getAllProduct(categoryId));
		}catch (RuntimeException e) {
			System.out.println("err in getAllProductList : "+e);
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Product List Not Added", null);
		}
	}
	
	@GetMapping("/product/{productId}")
	public ResponseDTO<?> getProductById(@PathVariable String productId){
		System.out.println("in getProductById: "+productId);
		try {		
			return new ResponseDTO<>(HttpStatus.OK, "Product Added", custService.getProductById(Long.valueOf(productId)));
		}catch (RuntimeException e) {
			System.out.println("err in getProductById : "+e);
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Product Not Added", null);
		}
	}
	
	@PostMapping("/cart")
	public ResponseDTO<?> addProductToCart(@RequestBody ProductCart productCart){
		System.out.println("in addProductToCart: "+productCart);
		try {
			return new ResponseDTO<>(HttpStatus.OK, "Product Added to cart", custService.addProductToCart(productCart));
		}catch (RuntimeException e) {
			System.out.println("err in addProductToCart : "+e);
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Product Not Added to cart", null);
		}
	}
	
	@PostMapping("/submit")
	public ResponseDTO<?> submitOrder(@RequestBody SubmitOrder order){
		System.out.println("in submitOrder: "+order);
		try {
			return new ResponseDTO<>(HttpStatus.OK, "Order Submitted Successfully", custService.submitOrder(order));
		}catch (RuntimeException e) {
			System.out.println("err in addProductToCart : "+e);
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Product Not Added to cart", null);
		}
	}
	
	@GetMapping("/cart/{userId}")
	public ResponseDTO<?> getCartByuserId(@PathVariable long userId){
		System.out.println("in getCartByuserId: "+userId);
		try {
			Order order = custService.getCartByuserId(userId);
			System.out.println("Cart : "+order);
			return new ResponseDTO<>(HttpStatus.OK, "Cart Added", order);
		}catch (RuntimeException e) {
			System.out.println("err in getCartByuserId : "+e);
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Cart Not Added", null);
		}
	}
	
	@DeleteMapping("/cart/{orderItemId}")
	public ResponseDTO<?> deleteItemFromCart(@PathVariable long orderItemId){
		System.out.println("in deleteItemFromCart: "+orderItemId);
		try {		
			return new ResponseDTO<>(HttpStatus.OK, "Item deleted from Cart", custService.deleteItemFromCart(orderItemId));
		}catch (RuntimeException e) {
			System.out.println("err in deleteItemFromCart : "+e);
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Item not deleted from Cart", null);
		}
	}

	@GetMapping("/categorylist")
	public ResponseDTO<?> getAllCategoryList(){
		System.out.println("in getAllCategoryList");
		try {
			List<Category> list = custService.getAllCategoryList();
			System.out.println("Category list : "+list);
			return new ResponseDTO<>(HttpStatus.OK, "Category List added",list);
		}catch (RuntimeException e) {
			System.out.println("err in getAllCategoryList");
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Category List Not added", null);
		}
	}
	
	@GetMapping("/userDetails/{orderId}")
	public ResponseDTO<?> getUserDetails(@PathVariable long orderId){
		System.out.println("in getUserDetails");
		try {
			UserDetails list = custService.getUserDetails(orderId);
			System.out.println("Category list : "+list);
			return new ResponseDTO<>(HttpStatus.OK, "Category List added",list);
		}catch (RuntimeException e) {
			System.out.println("err in getAllCategoryList");
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Category List Not added", null);
		}
	}

	@GetMapping("/pendingorders")
	public ResponseDTO<?> getPendingOrders(){
		System.out.println("in getPendingOrders");
		try {
			List<Order> list = custService.getPendingOrders();
			System.out.println("Order list : "+list);
			return new ResponseDTO<>(HttpStatus.OK, "Orders List added",list);
		}catch (RuntimeException e) {
			System.out.println("err in getAllCategoryList");
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Category List Not added", null);
		}
	}
	
	@GetMapping("/deliverorders")
	public ResponseDTO<?> getDeliveredOrders(){
		System.out.println("in getDeliveredOrders");
		try {
			List<Order> list = custService.getDeliveredOrders();
			System.out.println("Order list : "+list);
			return new ResponseDTO<>(HttpStatus.OK, "Orders List added",list);
		}catch (RuntimeException e) {
			System.out.println("err in getAllCategoryList");
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Category List Not added", null);
		}
	}
	
	@GetMapping("/order/{orderId}")
	public ResponseDTO<?> getOrderDetails(@PathVariable long orderId){
		System.out.println("in getOrderDetails");
		try {
			Order order = custService.getOrderDetails(orderId);
			System.out.println("Order list : "+order);
			return new ResponseDTO<>(HttpStatus.OK, "Orders List added",order);
		}catch (RuntimeException e) {
			System.out.println("err in getAllCategoryList");
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Category List Not added", null);
		}
	}
	
	@PostMapping("/deliver")
	public ResponseDTO<?> deliverOrder(@RequestBody SubmitOrder order){
		System.out.println("in deliverOrder: "+order);
		try {
			return new ResponseDTO<>(HttpStatus.OK, "Order delivered Successfully", custService.deliverOrder(order));
		}catch (RuntimeException e) {
			System.out.println("err in addProductToCart : "+e);
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Product Not Added to cart", null);
		}
	}
	
	@GetMapping("/order/history/{userId}")
	public ResponseDTO<?> getAllOrderDetailsUserId(@PathVariable long userId){
		System.out.println("in getOrderDetails");
		try {
			List<Order> order = custService.getAllOrderDetailsUserId(userId);
			System.out.println("Order list : "+order);
			return new ResponseDTO<>(HttpStatus.OK, "Orders List added",order);
		}catch (RuntimeException e) {
			System.out.println("err in getAllCategoryList");
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Category List Not added", null);
		}
	}
	
	/*@GetMapping("product/search/{productName}")
	public ResponseDTO<?> getProductListByName(@PathVariable String productName){
		System.out.println("in getProductListByName: "+productName);
		try {		
			return new ResponseDTO<>(HttpStatus.OK, "Product List Added", custService.getProductListByName(productName));
		}catch (RuntimeException e) {
			System.out.println("err in getProductListByName : "+e);
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Product List Not Added", null);
		}
	}
	
	@GetMapping("/orders/{userId}/{totalPrice}")
	public ResponseDTO<?> addOrder(@PathVariable int userId, @PathVariable double totalPrice){
		System.out.println("in addOrder: "+userId);
		try {		
			return new ResponseDTO<>(HttpStatus.OK, "Order Added", custService.addOrder(userId, totalPrice));
		}catch (RuntimeException e) {
			System.out.println("err in addOrder : "+e);
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Order Not Added", null);
		}
	}
	
	@GetMapping("/orderdetails/{userId}/{orderId}")
	public ResponseDTO<?> addorderDetails(@PathVariable int userId, @PathVariable int orderId){
		System.out.println("in addorderDetails: "+userId);
		try {		
			return new ResponseDTO<>(HttpStatus.OK, "order Details Added", custService.addOrdersDetails(userId, orderId));
		}catch (RuntimeException e) {
			System.out.println("err in addorderDetails : "+e);
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Order Details Not Added", null);
		}
	}
	
	
	@PostMapping("/payment")
	public ResponseDTO<?> addpayment(@RequestBody PaymentDTO paymentDTO){
		System.out.println("in addpayment: "+paymentDTO);
		try {				
			return new ResponseDTO<>(HttpStatus.OK, "Payment Done", custService.addPayment(paymentDTO));
		}catch (RuntimeException e) {
			System.out.println("err in addpayment : "+e);
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Payment Not Done", null);
		}
	}
	
	@GetMapping("/orders/{userId}")
	public ResponseDTO<?> getOrdersList(@PathVariable int userId){
		System.out.println("in getOrdersList: "+userId);
		try {		
			return new ResponseDTO<>(HttpStatus.OK, "Order List Added", custService.getOrdersList(userId));
		}catch (RuntimeException e) {
			System.out.println("err in getOrdersList : "+e);
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Order List Not Added", null);
		}
	}

	
	@GetMapping("/orderdetailslist/{orderId}")
	public ResponseDTO<?> getOrdersDetailsList(@PathVariable int orderId){
		System.out.println("in getOrdersDetailsList: "+orderId);
		try {		
			return new ResponseDTO<>(HttpStatus.OK, "Order Details List Added", custService.getOrdersDetailsList(orderId));
		}catch (RuntimeException e) {
			System.out.println("err in getOrdersDetailsList : "+e);
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Order Details List Not Added", null);
		}
	}
	
	@GetMapping("/cartupdate/{userId}")
	public ResponseDTO<?> updateCartItems(@PathVariable int userId){
		System.out.println("in updateCartItems: "+userId);
		try {		
			return new ResponseDTO<>(HttpStatus.OK, "Cart Updated", custService.updateCartItems(userId));
		}catch (RuntimeException e) {
			System.out.println("err in updateCartItems : "+e);
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Cart Not Updated", null);
		}
	}
	
	@GetMapping("/deliveredorder/{orderId}")
	public ResponseDTO<?> deliveredOrder(@PathVariable int orderId){
		System.out.println("in shipOrder: "+orderId);
		try {		
			return new ResponseDTO<>(HttpStatus.OK, "order Delivered", custService.deliveredOrder(orderId));
		}catch (RuntimeException e) {
			System.out.println("err in shipOrder : "+e);
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "order Not Delivered", null);
		}
	}
	
	@GetMapping("/orderslist")
	public ResponseDTO<?> getAllOrderList(){
		System.out.println("in getAllOrderList");
		try {		
			 List<Orders> list = custService.getAllOrderList();
			 System.out.println("list : "+list);
			return new ResponseDTO<>(HttpStatus.OK, "order List added",list);
		}catch (RuntimeException e) {
			System.out.println("err in getAllOrderList");
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "order List Not added", null);
		}
	}

	
	@GetMapping("/homeproductlist")
	public ResponseDTO<?> getProductsForHomePage(){
		System.out.println("in getProductsForHomePage");
		try {		
			 List<Product> list = custService.getProductsForHomePage();
			 System.out.println("Product list : "+list);
			return new ResponseDTO<>(HttpStatus.OK, "Product List added",list);
		}catch (RuntimeException e) {
			System.out.println("err in getProductsForHomePage");
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Category List Not added", null);
		}
	}
	
	@PostMapping("/orderaddress")
	public ResponseDTO<?> addOrderAddress(@RequestBody OrderAddress orderAddress){
		System.out.println("in addOrderAddress"+orderAddress);
		try {		
			return new ResponseDTO<>(HttpStatus.OK, "Address Id added",custService.addOrderAddress(orderAddress));
		}catch (RuntimeException e) {
			System.out.println("err in addOrderAddress");
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, "Address Id Not added", null);
		}
	}
	
	@GetMapping("/orderaddress1/{addressId}/{orderId}")
	public ResponseDTO<?> addOrderIdtoOrderAddress(@PathVariable int addressId, @PathVariable int orderId){
		System.out.println("in addOrderIdtoOrderAddress"+addressId+" orderId : "+orderId);
		try {		
			return new ResponseDTO<>(HttpStatus.OK, " added",custService.addOrderIdtoOrderAddress(addressId, orderId));
		}catch (RuntimeException e) {
			System.out.println("err in addOrderIdtoOrderAddress");
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, " Not added", null);
		}
	}
	
	@GetMapping("/orderaddress/{orderId}")
	public ResponseDTO<?> getOrderAddress(@PathVariable int orderId){
		System.out.println("in getOrderAddress : "+orderId);
		try {		
			return new ResponseDTO<>(HttpStatus.OK, " added",custService.getOrderAddress(orderId));
		}catch (RuntimeException e) {
			System.out.println("err in getOrderAddress");
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, " Not added", null);
		}
	}*/
}
