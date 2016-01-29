package Lab7;

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
		System.out.println("\t -> Departement Name : "+ Name);
		double total_department_salary = 0;
		Iterator it = positions.iterator();
		while(it.hasNext()){
			Position p = (Position)it.next(); 
			total_department_salary += p.getSalary();
		}
		
		System.out.format("\t -> Total Salary paid by %s  departemnt is $%,.2f USD \n\n",Name,total_department_salary );
		return total_department_salary;
	}
	
	public Position getDepartmentHead(){
		Iterator it = positions.iterator();
		while(it.hasNext()){
			Position p = (Position)it.next();
			if(p.isDepartmentHead())
				return p;
		}
		return null;
	}
	
	
	public void printReportingHierarchy() {
		System.out.println("Department " + Name); 
		if(getDepartmentHead()!= null){
			System.out.println("Department Head : " + getDepartmentHead().getEmployee().getFirstName()); 
			getDepartmentHead().printDownLine("");
		}
		
//		Iterator it = positions.iterator();
//		while(it.hasNext()){
//			Position p = (Position)it.next();
//			p.printDownLine("");
//		}
	}
	
}
