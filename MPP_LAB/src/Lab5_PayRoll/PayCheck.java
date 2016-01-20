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
		System.out.println("The period " + payPeriod);
		System.out.println("Fica : " + fica);
		System.out.println(" State : " + state);
		System.out.println(" local : " + local);
		System.out.println(" medicare : " + medicare);
		System.out.println("Gross : " + grossPay);
		
	}
	
	void getNetPay(){
		
	}
}
