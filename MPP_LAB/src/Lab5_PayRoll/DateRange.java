package Lab5_PayRoll;

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
	
	public String toString(){
		return startDate.toString() + " to "+ endDate.toString();
	}
	
	public static GregorianCalendar getFirstDayOfMonth(GregorianCalendar date){
		return null;
	}
	
	public static GregorianCalendar getLastDayOfMonth(GregorianCalendar date){
		return null;
	}
}
