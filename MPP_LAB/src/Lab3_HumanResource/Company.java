package Lab3_HumanResource;

import java.util.ArrayList;
import java.util.Iterator;

public class Company {
	String Name;
	ArrayList departments = new ArrayList<Department>();
	
	Company(){
		
	}
	
	Company(String name,ArrayList depts){
		Name = name;
		if(depts != null)
		{
			departments = depts;
		}
		
		
	}
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public ArrayList getDepartments() {
		return departments;
	}

	public void setDepartments(ArrayList departments) {
		this.departments = departments;
	}
	public void addDepartment(Department d){
		departments.add(d);
	}

	public void print(){
		System.out.println("-> COMPANY : " + Name );
		Iterator it = departments.iterator();
		while(it.hasNext()){
			Department d = (Department)it.next(); 
			d.print();
		}
		
	}
	public double getSalary(){
		double total_company_salary = 0;
		Iterator it = departments.iterator();
		while(it.hasNext()){
			Department d = (Department)it.next(); 
			total_company_salary += d.getSalary();
		}
		System.out.println("Total Salary paid by " + Name + " Company " + total_company_salary + " USD");
		return total_company_salary;
	}
}
