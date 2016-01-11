package MPP_HW_1;

public class Staff extends Person{
	private double Salary;
	
	Staff(String name, String phone, int age,double salary) {
		super(name, phone, age);
		Salary = salary;
	}

	

	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		Salary = salary;
	}
	
}
