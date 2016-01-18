package OrderTrackingSystem;

import OrderTrackingSystem.Customer.CreditRating;

public class PersonalCustomer extends Customer{
		
	PersonalCustomer(String Id,String name){
		super(Id,name,CreditRating.POOR);
		
	}

}