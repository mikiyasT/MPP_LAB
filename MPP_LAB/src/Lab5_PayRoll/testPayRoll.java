package Lab5_PayRoll;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class testPayRoll {

	public static void main(String[] args) {
		Employee hrEmp = new HourlyEmployee("h01", 23, 40);
		Employee slrEmp = new SalariedEmployee("s01", 4500);
		Employee comEmp = new ComissionedEmployee("c01",0.07, 650);
		Order o1 = new Order("o1",new GregorianCalendar(2016,01,23),2);
		comEmp.addOrdersTaken(o1);
		
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(hrEmp);
		employeeList.add(slrEmp);
		employeeList.add(comEmp);
		
		for(Employee e:employeeList)
			e.calcCompensation("12", "1989").print();
		
		
//		GregorianCalendar d = new GregorianCalendar(2010, 5, 3);
//		System.out.println(d.get(GregorianCalendar.YEAR) + "/"
//				+ d.get(GregorianCalendar.MONTH) + "/"
//				+ d.get(GregorianCalendar.DAY_OF_MONTH));
		
		
		

	}

}
