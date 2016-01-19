package Lab5_PayRoll;

public class PayCheck {
	double grossPay;
	double fica;
	double state;
	double local;
	double medicare;
	double socialSecurity;
	DateRange payPeriod;
	
	
	
	public PayCheck(double grossPay, double fica, double state,double medicare,double local, double socialSecurity, DateRange payPeriod) {
		super();
		this.grossPay = grossPay;
		this.fica = fica;
		this.state = state;
		this.medicare = medicare;
		this.socialSecurity = socialSecurity;
		this.payPeriod = payPeriod;
	}

	void print(){
		
	}
	
	void getNetPay(){
		
	}
}
