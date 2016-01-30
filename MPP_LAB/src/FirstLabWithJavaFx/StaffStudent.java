package FirstLabWithJavaFx;

import java.time.LocalDate;

public class StaffStudent extends Student{
	
	//private double Salary;
	
	LocalDate startDate;
	Staff staff;
	StaffStudent(String name, String phone, int age,double gpa,double salary) {
		super(name, phone, age, gpa);
		staff = new Staff();
		staff.setSalary(salary);
		startDate = null;
	}
	
	public double getSalary() {
		return staff.getSalary();
	}

	public void setSalary(double salary) {
		staff.setSalary(salary);		
	}
	
	public void addCourse(Course c){
		if(startDate == null)
		startDate = LocalDate.now();
		super.addCourse(c);
	}

}
