package MPP_HW_1;

import java.time.LocalDate;

public class StaffStudent extends Student{
	
	private double Salary;
	static LocalDate startDate;
	
	StaffStudent(String name, String phone, int age,double gpa,double salary) {
		super(name, phone, age,gpa);
		Salary = salary;
	}
	
	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		Salary = salary;
	}
	
	

}
