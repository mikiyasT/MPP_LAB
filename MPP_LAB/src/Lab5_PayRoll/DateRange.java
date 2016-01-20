package Lab5_PayRoll;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateRange {

	GregorianCalendar startDate;
	GregorianCalendar endDate;
	
	DateRange(GregorianCalendar startDate,GregorianCalendar endDate){
		this.startDate = startDate;
		this.endDate   = endDate;
	}
	
	public boolean isInRange(GregorianCalendar date){
		return false;
 		
	}
	
	public GregorianCalendar getStartDate() {
		return startDate;
	}

	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}

	public GregorianCalendar getEndDate() {
		return endDate;
	}

	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
	}

	public String toString(){
		
		return startDate.get(GregorianCalendar.YEAR) + "/"
				+ startDate.get(GregorianCalendar.MONTH) + "/"
				+ startDate.get(GregorianCalendar.DAY_OF_MONTH) + "- " + 
		endDate.get(GregorianCalendar.YEAR) + "/"
				+ endDate.get(GregorianCalendar.MONTH) + "/"
				+ endDate.get(GregorianCalendar.DAY_OF_MONTH);
		
	}
	
	public static GregorianCalendar getFirstDayOfMonth(Calendar c){
		return null;
	}
	
	public static GregorianCalendar getLastDayOfMonth(GregorianCalendar date){
		return null;
	}
}
