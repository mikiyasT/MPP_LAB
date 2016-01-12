package MPP_HW_1;

import java.util.ArrayList;

public class Student extends Person{
	
	private double GPA;
	private ArrayList takingCourses;
	
	Student(String name, String phone, int age,double gpa) {
		super(name, phone, age);
		GPA = gpa;
		ArrayList tc = new ArrayList<Course>();
		takingCourses = tc;
	}
	protected int getTotalUnits(){
		return 0;
	}

	public ArrayList getTakingCourses() {
		return takingCourses;
	}

	public void setTakingCourses(ArrayList takingCourses) {
		this.takingCourses = takingCourses;
	}	
	
	public void addCourse(Course c){
		takingCourses.add(c);
	}
	

}
