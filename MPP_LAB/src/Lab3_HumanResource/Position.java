package Lab3_HumanResource;

import java.util.Iterator;

public class Position {
	String Title;
	String Description;
	Employee employee;// = new Employee();
	
	Position(){
		
	}
	
	Position(String title, String description, Employee emp){
		Title = title;
		Description = description;
				
		if(emp != null){
			employee = new Employee();
			employee = emp;
			employee.setPosition(this);
		}
		else{
			employee = emp;
		}
	}
	public void print(){
		System.out.println(" \t\t -> Position Title " + Title + " ,Description " + Description);
		if(employee != null)
			employee.print();
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public double getSalary() {
		double position_salary = 0;
		
		if(getEmployee() != null ){
			position_salary = getEmployee().getSalary();
			
		}
		System.out.println(" Total Salary paid for " + Title + " Position " + position_salary);
		return position_salary;
		
	}
	
	
}
