package Lab5_PayRoll;

public class HourlyEmployee extends Employee {
	double hourlyWage;
	int hoursPerWeek;
	
	
	public HourlyEmployee(String empId,double hourlyWage, int hoursPerWeek) {
		super(empId);
		this.hourlyWage = hourlyWage;
		this.hoursPerWeek = hoursPerWeek;
	}


	@Override
	public double calcGrossPay(DateRange range) {
		return hourlyWage * hoursPerWeek;
	}
	
	
}
