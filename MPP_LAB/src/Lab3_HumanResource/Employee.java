package Lab3_HumanResource;

public class Employee {
	String firstName;
	String middleInitial;
	String lastName;
	String birthDate;
	String SSN;
	double salary;
	Position position;
	
	Employee(String fName, String middleInit, String lName, String bDate,String ssn,double sal, Position pos){
		firstName = fName;
		middleInitial = middleInit;
		lastName = lName;
		birthDate = bDate;
		SSN = ssn;
		salary = sal;
		
		//position = pos;
		if(position != null){
		position = new Position();
		position = pos;
		position.setEmployee(this);
		}
		else{
			position = pos;
		}
			
	}
    @Override
	public boolean equals(Object e){
    	if(! (e instanceof Employee))
    		return false;
    	Employee e1 = (Employee)e;
    	
    	if(		e1.getFirstName().equals(firstName) && 
    			e1.getLastName().equals(lastName) && 
    			e1.getMiddleInitial().equals(middleInitial) &&
    			e1.getSSN().equals(SSN) &&
    			e1.getBirthDate().equals(birthDate) &&
    			(e1.getSalary() == salary) &&  
    			//if both positions are null or both are the same
    			e1.getPosition().myEquals(position)
    			)
    		return true;
    	else
    		return false;
    }
	
	Employee(){
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public double getSalary() {
		
		System.out.format("\t\t\t -> Salary paid for Employee  %s is $%,.2f USD \n",firstName,salary);
		
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public void print(){
		System.out.println(" \t\t\t -> Employee Name : " + firstName + " "+ lastName + " ,Birth date " + birthDate);
	}
	public String toString(){
		return "Employee " + " " +" " + firstName + " "+ lastName + " ,Birth date " + birthDate;
	}
	public boolean myEquals(Employee employee) {
		if(employee == null)
			return false;
		if(		employee.getFirstName().equals(firstName) && 
				employee.getLastName().equals(lastName) && 
				employee.getMiddleInitial().equals(middleInitial) &&
				employee.getSSN().equals(SSN) &&
				employee.getBirthDate().equals(birthDate) &&
    			(employee.getSalary() == salary) 
    			//if both positions are null or both are the same 
    			)
			return true;
		else
			return false;
	}
}
