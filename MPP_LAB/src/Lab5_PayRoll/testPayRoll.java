package Lab5_PayRoll;

import java.util.GregorianCalendar;

public class testPayRoll {

	public static void main(String[] args) {
		Employee hrEmp = new HourlyEmployee("h01", 23, 40);
		Employee slrEmp = new SalariedEmployee("s01", 4500);
		Employee comEmp = new ComissionedEmployee("c01",0.07, 650);
		
		Order o1 = new Order("o1",new GregorianCalendar(2016,01,10),2);
		
		GregorianCalendar d = new GregorianCalendar(2010, 5, 3);
		
		
		System.out.println("coded date " + d.toString());

	}

}
