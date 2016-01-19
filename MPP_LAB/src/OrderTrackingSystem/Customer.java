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
		for(int i = 0; i < ordersMade.size();i++)
		{
			System.out.println(" Orders placed " + ordersMade.get(i));
		}
		shoppingCart.clear();
		System.out.println("Orders placed");
		
		
	}
	public void makePayment(){
		// for the orders the customer made, pay for those whose status is ORDERED
		System.out.println("Making Payment");
		Iterator it = ordersMade.iterator();
		while(it.hasNext()){
			Order order = (Order)it.next();
			if(order.getOrderStatus() == Order.order_status.ORDERED)
			{
				double amt = 0;;//= o.getProductList()
				ArrayList<Product> orderdProducts =  order.getProductList();
				for(int i = 0; i < orderdProducts.size();i++)
				{
					System.out.println("Processing payment for "+ orderdProducts.get(i));
					amt += orderdProducts.get(i).getUnitPrice() * orderdProducts.get(i).getOrderedQty();
					addPoints(orderdProducts.get(i).getPoints());
					
					int av_qt = orderdProducts.get(i).getAvailabledQty();
					int or_qt = orderdProducts.get(i).getOrderedQty();
					
					orderdProducts.get(i).setAvailableQty(av_qt - or_qt);
					orderdProducts.get(i).setOrderedQty(0);
					System.out.println("available qty - ordered qty" + av_qt + "-" + or_qt + "" + 	orderdProducts.get(i).getAvailabledQty()); 
				}
				if(getPoints() >= 25)
				{
					new Payment("payId1",amt - amt*0.4,this,order,Payment.payment_type.DEBIT);
					setPoints(getPoints() - 25);
					System.out.println("Payment made : point used");
				}
				else
				{
					new Payment("payId1",amt,this,order,Payment.payment_type.DEBIT);
					System.out.println("Payment made : point added");
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
