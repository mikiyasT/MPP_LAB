package Lab7;

public class Employee  implements Cloneable{
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
	
	Employee(){
		
	}
	
	public Object clone() throws CloneNotSupportedException {
		Employee clone = (Employee)super.clone();
		clone.position = (Position)position.clone();
		
		return clone;
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
	public boolean equals(Object o){
		if(o == null)
			return false;
		if(!(o instanceof Employee))
			return false;
		Employee e = (Employee)o;
		if(this.basicEquals(e))
		{
			if(this.getPosition().basicEqual(e.getPosition()))
				return true;
		}
		return false;
		
	}

	public boolean basicEquals(Employee employee) {
		if(employee == null)
			return false;
		else if(
				firstName.equals(employee.getFirstName()) 
				&&
				middleInitial.equals(employee.getMiddleInitial())
				&&
				lastName.equals(employee.getLastName())
				&&
				birthDate.equals(employee.getBirthDate())
				&&
				SSN.equals(employee.getSSN())
				&&
				(salary == employee.getSalary())
				)
			return true;
		else
			return false;
			
	}
	
	public int hashCode(){
		int result = 7;
		result += firstName.hashCode();
		result += middleInitial.hashCode();
		result += lastName.hashCode();
		result += birthDate.hashCode();
		result += SSN.hashCode();
		result += Double.doubleToLongBits(salary);
		result += position.hashCode();
		result *= 31;
		return result;
	}
}
