package MPP_HW_1;

import java.util.ArrayList;
import java.util.Iterator;

public class Department {
	private String Name;
	private ArrayList PersonList;
	
	Department(String name){
		Name = name;
		ArrayList a = new ArrayList<Person>();
		PersonList = a;
		
	}
	protected double getTotalSalary()
	{
		
		Iterator it = PersonList.iterator();
		double totalSalary = 0;
		
		while(it.hasNext())
		{
			Person p = (Person) it.next();
			if((p instanceof Faculty) )
			{
				Faculty f = (Faculty)p; 
				totalSalary += f.getSalary();				
			}
			
			if((p instanceof Staff))
			{
				Staff s = (Staff)p; 
				totalSalary += s.getSalary();
				
			}
		}
		return totalSalary;
	}	
	
	public ArrayList getPersonList() {
		return PersonList;
	}

	public void setPersonList(ArrayList personList) {
		PersonList = personList;
	}

	protected void showAllMembers(){
		
		Iterator it = PersonList.iterator();
		while(it.hasNext())
		{
			Person p = (Person) it.next();
			if((p instanceof Faculty) )
			{
				System.out.println("Faculty Name"  + p.getName() + " Age "+ p.getAge()); 		
			}
			
			else if((p instanceof Staff))
			{
				System.out.println("Staff Name "  + p.getName() + " Age "+ p.getAge()); 
				
			}
			else
			{
				System.out.println("Student Name " + p.getName() + " Age "+ p.getAge()); 
			}
		}
		
	}
	protected void unitsPerFaculty(){
		Iterator it = PersonList.iterator();
		
		while(it.hasNext())
		{
			Person p = (Person) it.next();
			if((p instanceof Faculty) )
			{
				Faculty  f = (Faculty)p;
				System.out.println("Faculty Name " + f.getName() + " Total Units " + f.getTotalUnits());		
			}
			
			
		}
	}
	
	protected void addPerson(Person p){
		PersonList.add(p);
	}
	
	
}
