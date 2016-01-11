package MPP_HW_1;

import java.util.ArrayList;

public class Faculty extends Person{
	
	private double Salary;
	Faculty(String name, String phone, int age,double salary) {
		super(name, phone, age);
		Salary = salary;
		
	}
	
	
	
	//private ArrayList teachingCourses;
	
	protected int getTotalUnits(){
		return 0;
	}
//	public ArrayList getTeachingCourses() {
//		return teachingCourses;
//	}
//	public void setTeachingCourses(ArrayList teachingCourses) {
//		this.teachingCourses = teachingCourses;
//	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}	
	
	
}
