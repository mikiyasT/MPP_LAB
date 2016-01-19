package Lab5_PayRoll;

import java.util.GregorianCalendar;

public abstract class Employee {
	String empId;
	
	public void print(){
		
	}
	public PayCheck calcCompensation(String Month,String year){
		// this is grossPay - all taxes
		//FICA 23%, State 5%, Local 1%, Medicare 3%, Socialsec 7.5%
		double grossPay = calcGrossPay(null);
		
		double fica				= 0.23 * grossPay;
		double state			= 0.05 * grossPay;
		double local	 		= 0.01 * grossPay;
		double medicare	 		= 0.03 * grossPay;
		double socialSecurity 	= 0.075 * grossPay;
		DateRange payperiod		= null;
		
		
		
		PayCheck check = new PayCheck(grossPay, fica, state,medicare,local, socialSecurity, payperiod);
		 
		return null;
		
	}
	
	public abstract double calcGrossPay(String DateRange);
	
}
