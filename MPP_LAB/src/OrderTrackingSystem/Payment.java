package OrderTrackingSystem;

public class Payment {
	
	String paymentId;
	static double total_payment;
	double amount;
	Customer customer;
	Order order;
	static enum payment_type {CREDIT,DEBIT}
	private payment_type payWith;
	String paymentConfirmationCode = null;
	Payment(String pay_id, double amt,Customer c, Order o,payment_type pt){
		//after taking money from, and adding to the total payments to the system
		//if customer is personal, payment should be made with debit, and credit/debit for corporate customers.
		if(c instanceof PersonalCustomer && pt == payment_type.DEBIT)
		{
			amount = amt;
			total_payment += amount;
			paymentConfirmationCode = "paymentDone" + "pay_id"; 
			o.completeOrder(this,paymentConfirmationCode);
		}
		else if(c instanceof CorporateCustomer){
			amount = amt;
			total_payment += amount;
			paymentConfirmationCode += "pay_id"; 
			o.completeOrder(this,paymentConfirmationCode);
		}
		else
		{
			System.out.println("Payment failed : Invalid payment method");
		}
			
	}
	
	public String getPaymentConfirmationCode(){
		return paymentConfirmationCode;
	}

}
