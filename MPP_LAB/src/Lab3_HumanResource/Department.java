package Lab3_HumanResource;

import java.util.ArrayList;
import java.util.Iterator;

public class Department {
	String Name;
	String Location;
	ArrayList positions = new ArrayList<Position>();
	Department(){
		
	}
	Department(String name, String location,ArrayList pos){
		Name = name;
		Location = location;
		if(pos != null)
		positions = pos;
		
	}
	public void print(){
		System.out.println("\t -> Department Name : " + Name + " ,Location " + Location);
		Iterator it = positions.iterator();
		while(it.hasNext()){
			Position p = (Position)it.next(); 
			p.print();
		}
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public ArrayList getPositions() {
		return positions;
	}
	public void setPositions(ArrayList positions) {
		this.positions = positions;
	}
	public void addPosition(Position p){
		positions.add(p);
	}
	public double getSalary() {
		double total_department_salary = 0;
		Iterator it = positions.iterator();
		while(it.hasNext()){
			Position p = (Position)it.next(); 
			total_department_salary += p.getSalary();
		}
		System.out.println("Total Salary paid by " + Name + " departemnt " + total_department_salary + " USD");
		return total_department_salary;
	}
	
	
	public void printReportingHierarchy() {
		Iterator it = positions.iterator();
		while(it.hasNext()){
			Position p = (Position)it.next();
			p.printDownLine("");
		}
	}
	
}
