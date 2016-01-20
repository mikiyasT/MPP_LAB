package Lab5_PayRoll;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ComissionedEmployee extends Employee {
	
	double commission;
	double baseSalary;
	ArrayList<Order> orders_taken = new ArrayList<Order>();
	
	public ComissionedEmployee(String empId,double commission,double baseSalary) {
		super(empId);
		this.commission = commission;
		this.baseSalary = baseSalary;
	}
	
	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public ArrayList<Order> getOrders_taken() {
		return orders_taken;
	}

	public void setOrders_taken(ArrayList<Order> orders_taken) {
		this.orders_taken = orders_taken;
	}
	
	public void addOrdersTaken(Order o){
		orders_taken.add(o);
	}

	@Override
	public double calcGrossPay(DateRange range) {
		int total_amt = 0;
		for(int i = 0; i < orders_taken.size();i++){
			
			
			GregorianCalendar sd = range.getStartDate();//start date
			GregorianCalendar ed = range.getEndDate();//end date
			GregorianCalendar od = orders_taken.get(i).getOrderDate(); //order date
			
			if(sd.before(od) && ed.after(od)){
				System.out.println("Calculating for : " + range);
				total_amt +=orders_taken.get(i).getOrderAmount();
			}
			
			
		}
		
		return total_amt * commission + baseSalary;
		
	}

}
