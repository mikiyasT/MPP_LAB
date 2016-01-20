package Lab5_PayRoll;

public class SalariedEmployee extends Employee{
	
	double salary;
	public SalariedEmployee(String empId,double salary) {
		super(empId);
		this.salary = salary;
	}
	
	@Override
	public double calcGrossPay(DateRange range) {
		return salary;
		
	}

	


}
