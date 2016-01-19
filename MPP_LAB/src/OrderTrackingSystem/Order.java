package OrderTrackingSystem;

import java.util.ArrayList;

public class Order {
	
	private String orderId;
	private String customerId;  //Customer customer;
	
	static enum order_status {ORDERED,DELIVERED,COMPLETE}
	private order_status status;
	ArrayList<Product> productList = new ArrayList<Product>();
	
	static int totalNumberOfOrders;
	
	Order(String OId,String CId,ArrayList<Product> pList){
		orderId = OId;
		customerId = CId;
		if(pList != null){
			for(int i =0; i < pList.size(); i++){
				productList.add(pList.get(i));
			}
			
		}
		status = order_status.ORDERED;
	}
	
	public void addProductToOrder(Product p){
		productList.add(p);
	}
	
	public ArrayList<Product> getProductList(){
		return productList;
	}
//	public int ordered_Quantity(){
//		return Ordered_qty;
//	}
	public void setOrderStatus(order_status s){
		status = s;
	}
	
	public void completeOrder(Payment payment,String confirmation){
		
		if(confirmation != null && payment.getPaymentConfirmationCode().equals(confirmation))
		for(int i = 0 ; i < productList.size(); i++)
		{
			Product prt = productList.get(i);
			int ordered_qty = prt.getOrderedQty();
			int available_qty = prt.getAvailabledQty();
			prt.setAvailableQty(available_qty - ordered_qty);
			prt.setOrderedQty(0);			
		}
		setOrderStatus(order_status.COMPLETE);
	}
	
	public order_status getOrderStatus(){
		return status;
	}
	public String toString(){
		String orderString = "";
		orderString =  orderId + " " + customerId + " " + status + " product " ; 
				for(int i = 0; i < productList.size();i++)
				{
					
					orderString += productList.get(i).toString();
				}
				return orderString;
				
	}
	

}
