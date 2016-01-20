package Lab5_PayRoll;

import java.util.GregorianCalendar;

public abstract class Employee {
	String empId;
	
	Employee(String empId){
		this.empId = empId;
	}
	public void print(){
		
	}
	public PayCheck calcCompensation(String Month,String year){
		// this is grossPay - all taxes
		//FICA 23%, State 5%, Local 1%, Medicare 3%, Socialsec 7.5%
		
		//for the given month/year combination find the date range
		GregorianCalendar startDate = new GregorianCalendar(2016,01,10);
		GregorianCalendar endDate =	 new GregorianCalendar(2016,02,10);
		DateRange range = new DateRange(startDate, endDate);
		
		double grossPay = calcGrossPay(range);
		
		double fica				= 0.23 * grossPay;
		double state			= 0.05 * grossPay;
		double local	 		= 0.01 * grossPay;
		double medicare	 		= 0.03 * grossPay;
		double socialSecurity 	= 0.075 * grossPay;
		
		//DateRange payperiod		= null;
		
		
		
		PayCheck check = new PayCheck(grossPay, fica, state,medicare,local, socialSecurity, range);
		 
		return check;
		
	}
	
	public void addOrdersTaken(Order o){
		//does nothing
	}
	
	
	public abstract double calcGrossPay(DateRange range);
	
}
