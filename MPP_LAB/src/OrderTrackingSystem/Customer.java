package OrderTrackingSystem;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {
	
	
	String customerId;
	String Name;
	double Points;
	static enum CreditRating {EXCELENT,GOOD,POOR}
	CreditRating Rating;
	ArrayList<Order> ordersMade = new ArrayList<Order>();
	ArrayList<Product> shoppingCart = new ArrayList<Product>();
	
	Customer(String Id,String name, CreditRating rating){
		customerId = Id;
		Name = name;
		Rating = rating;
		
	}
	
	public void addToShoppingCart(Product p,int qt){
		p.setOrderedQty(qt);
		shoppingCart.add(p);
	}
	
	public void placeOrder(){
		
		String oid ="oid";
		Order o = new Order(oid,customerId,shoppingCart);
		ordersMade.add(o);
		shoppingCart.clear();
		
		
	}
	public void makePayment(){
		// for the orders the customer made, pay for those whose status is ORDERED
		Iterator it = ordersMade.iterator();
		while(it.hasNext()){
			Order order = (Order)it.next();
			if(order.getOrderStatus() == Order.order_status.ORDERED)
			{
				double amt = 0;;//= o.getProductList()
				ArrayList<Product> orderdProducts =  order.getProductList();
				for(int i = 0; i < orderdProducts.size();i++){
					amt += orderdProducts.get(i).getUnitPrice() * orderdProducts.get(i).getOrderedQty();
					addPoints(orderdProducts.get(i).getPoints());
				}
				if(getPoints() >= 25)
				{
					new Payment("payId1",amt - amt*0.4,this,order,Payment.payment_type.DEBIT);
					setPoints(getPoints() - 25);
					
				}
				else
				{
					new Payment("payId1",amt,this,order,Payment.payment_type.DEBIT);
				}
				
			}
				
		}
		
		
	}
	public void addPoints(double pt){
		Points += pt;
	}
	public double getPoints(){
		return Points;
	}
	public void setPoints(double pt){
		Points = pt;
	}


	public void myCart() {
		System.out.println("Your shopping cart items");
		for(int i = 0; i < shoppingCart.size();i++){
			System.out.println(" [ Id-> " + shoppingCart.get(i).getProductId() + ",Qty->"+ shoppingCart.get(i).getOrderedQty() + "]");
		}
		
	}

}
