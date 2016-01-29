package FirstLabWithLambda;

public class Person {
	
	
	protected String Name;
	protected String Phone;
	protected int Age;
	
	Person(){
		
	}
	Person(String name, String phone , int age){
		Name = name;
		Phone = phone;
		Age = age;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	
	public double getSalary(){
		return 0;
	}
	
	public String toString(){
		return "First Name " + getName() + " Age : " + getAge() + " Salary : " + Double.toString(getSalary());
	}
	

}
