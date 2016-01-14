package Lab3_HumanResource;

import java.util.ArrayList;
import java.util.Iterator;

public class Position {
	String Title;
	String Description;
	Employee employee;
	Position  superior;
	ArrayList <Position> inferiors;
	
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
		superior = new Position();
		inferiors = new ArrayList<Position>();
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
	public void setSuperior(Position p){
		superior = p;
	}
	public Position getSuperior(){
		return superior;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public void addInferior(Position p){
		inferiors.add(p);
		p.setSuperior(this);
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
	public String toString(){
		if(employee != null)
			return "-> " + Title + " Assineged to: "+ employee.toString();
		else
			return "-> " + Title + " Assineged to  : None ";
	}
	
	public void printDownLine(String indentStr){
		indentStr = indentStr + "\t";
		System.out.println(indentStr + this+ " Manages ");
		Iterator it = inferiors.iterator();
		while(it.hasNext()){
			Position p = (Position)it.next();
			p.printDownLine(indentStr);
		}
		

	}
	
	
}
