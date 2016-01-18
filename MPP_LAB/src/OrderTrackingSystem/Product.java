package OrderTrackingSystem;

interface IProduct {
	
	double getPoints();
	//void searchProducts();
	String getProductId();
	String toString();

}
public abstract class Product implements IProduct{
	String productId;
	double unitPrice;
	String description;
	int Available_quantity;
	int ordered_quantity;
	Product(String Id,double price,String desc,int qty){
		productId = Id;
		unitPrice = price;
		description = desc;
		Available_quantity = qty;
		
	}
	public void searchProducts(){
		
	}
	double getUnitPrice(){
		return unitPrice;
	}
	public int getOrderedQty() {
		// TODO Auto-generated method stub
		return ordered_quantity;
	}
	public void setOrderedQty(int qt) {
		// TODO Auto-generated method stub
		ordered_quantity = qt;
	}
	public int getAvailabledQty() {
		
		return Available_quantity;
	}
	public void setAvailableQty(int qt) {
		Available_quantity = qt;
	}
	public String getProductId(){
		return productId;
	}
	
	public String toString(){
		return " [ Id-> " + productId + ",Price-> " + unitPrice + ",Description->" + description + ",Qty->"+ Available_quantity + "]"; 
	}
}
class HealthCareProduct extends Product{
	
	
	HealthCareProduct(String Id,double price,String desc,int qty){
		super(Id, price, desc, qty);		
	}

	public double getPoints() {
		// TODO Auto-generated method stub
		return 0.4;
	}
}

class AudioVideoProduct extends Product{
	
	
	AudioVideoProduct(String Id,double price,String desc,int qty){
		super(Id, price, desc, qty);		
	}

	public double getPoints() {
		// TODO Auto-generated method stub
		return 0.3;
	}
}

class FoodProduct extends Product{
	
	
	FoodProduct(String Id,double price,String desc,int qty){
		super(Id, price, desc, qty);		
	}

	public double getPoints() {
		// TODO Auto-generated method stub
		return 0.25;
	}
}
class OtherProduct extends Product{
	
	
	OtherProduct(String Id,double price,String desc,int qty){
		super(desc, price, desc, qty);		
	}

	public double getPoints() {
		// TODO Auto-generated method stub
		return 0.1;
	}
}
