package Lab5_PayRoll;

import java.util.ArrayList;

public class ComissionedEmployee extends Employee {
	
	double commission;
	double baseSalary;
	ArrayList<Order> orders_taken = new ArrayList<Order>();
	
	public ComissionedEmployee(String empId,double commission,double baseSalary) {
		super(empId);
		this.commission = commission;
		this.baseSalary = baseSalary;
	}
	
	@Override
	public double calcGrossPay(String DateRange) {
		int total_amt = 0;
		for(int i = 0; i < orders_taken.size();i++){
			total_amt +=orders_taken.get(i).getOrderAmount();
		}
		
		return total_amt * commission + baseSalary;
		
	}

}
