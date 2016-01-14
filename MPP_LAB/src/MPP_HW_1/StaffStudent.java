package MPP_HW_1;

import java.time.LocalDate;

public class StaffStudent extends Student{
	
	//private double Salary;
	
	static LocalDate startDate;
	Staff staff;
	StaffStudent(String name, String phone, int age,double gpa,double salary) {
		super(name, phone, age, gpa);
		staff = new Staff();
		staff.setSalary(salary);
		//startDate = Local
	}
	
	public double getSalary() {
		return staff.getSalary();
	}

	public void setSalary(double salary) {
		staff.setSalary(salary);		
	}

}
