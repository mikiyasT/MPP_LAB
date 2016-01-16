package MPP_HW_1;

import java.util.ArrayList;
import java.util.Iterator;


public class Faculty extends Person{
	
	private double Salary;
	ArrayList teachingCourses;
	Faculty(String name, String phone, int age,double salary) {
		super(name, phone, age);
		Salary = salary;
		ArrayList tc = new ArrayList<Course>();
		teachingCourses = tc;
		
	}
	//private ArrayList teachingCourses;
	
	protected int getTotalUnits(){
		Iterator it = teachingCourses.iterator();
		int totalUnits = 0;
		while(it.hasNext()){
			Course c = (Course)it.next();
			totalUnits += c.getUnits();
		}
		return totalUnits;
	}

	public ArrayList getTeachingCourses() {
		return teachingCourses;
	}

	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}	
	
	public void addCourse(Course c){
		teachingCourses.add(c);
	}	
	
}
