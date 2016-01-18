package OrderTrackingSystem;

public class CorporateCustomer extends Customer{
	double creditLimit;
	
	CorporateCustomer(String Id,String name, CreditRating rating,double limit){
		super(Id, name,rating);
		creditLimit = limit;
	}
	
	public void setCreditLimit(double limit){
		creditLimit = limit;
	}
	
	public double getCreditLimit(){
		return creditLimit;
	}

}
