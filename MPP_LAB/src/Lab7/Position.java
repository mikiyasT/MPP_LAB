package Lab7;

import java.util.ArrayList;
import java.util.Iterator;

public class Position {
	String Title;
	String Description;
	Employee employee;
	Position  superior;
	ArrayList <Position> inferiors;
	
	boolean departementHead;
	
	
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
		
		departementHead = false;
	}
	
	public Object clone() throws CloneNotSupportedException {
		Position clone = (Position)super.clone();
		//clone.position = (Position)position.clone();
		
		return clone;
	}
	public void print(){
		System.out.println(" \t\t -> Position Title " + Title + " ,Description " + Description);
		if(employee != null)
			employee.print();
		else
			System.out.println(" \t\t\t -> No Employee asigned here");
	}
	public void makeDepartementHead(){
		departementHead = true;
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
		System.out.println("\t\t -> Position : "+ Title);
		if(getEmployee() != null ){
			position_salary = getEmployee().getSalary();
			
		}
		
		System.out.format("\t\t -> Total Salary paid by %s  Position  is $%,.2f USD \n\n",Title,position_salary );
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

	public boolean isDepartmentHead() {
		// TODO Auto-generated method stub
		return departementHead;
	}
	
	public boolean equals(Object o){
		if(o == null)
			return false;
		if(!(o instanceof Position))
			return false;
		Position p = (Position)o;
		if(this.basicEqual(p)){
			for(Position p1 : inferiors)
			{
				if(!p1.basicEqual(p))
					return false;
			}
			
		}
		return true;
	}

	public boolean basicEqual(Position p) {
		if( p == null)
			return false;
		else if(Title.equals(p.getTitle()) && Description.equals(p.getDescription())/* && employee.basicEquals(p.getEmployee())*/)
			return true;
		else
			return false;
	}
	
	public int hasCode(){
		int result = 7;
		result += Title.hashCode();
		result += Title.hashCode();
		result *= 31;
		return result;
	}
	
	
}
