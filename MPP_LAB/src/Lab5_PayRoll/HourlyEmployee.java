package Lab5_PayRoll;

public class HourlyEmployee extends Employee {
	double hourlyWage;
	int hoursPerWeek;
	@Override
	public double calcGrossPay(String DateRange) {
		return hourlyWage * hoursPerWeek;
		
	}
}
