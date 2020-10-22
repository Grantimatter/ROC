package hacker_ranks;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarProblem {

	public static void main(String[] args) {
		System.out.println(findDay(6, 19, 2020));
	}
	
	public static String findDay(int month, int day, int year) {
        Calendar cal = new GregorianCalendar(year, month, day);
        //return cal.get(Calendar.DAY_OF_WEEK);
        
        switch(cal.get(cal.DAY_OF_WEEK)){
            case Calendar.SUNDAY:
                return "Sunday";
            case Calendar.MONDAY:
                return "Monday";
            case Calendar.TUESDAY:
                return "Tuesday";
            case Calendar.WEDNESDAY:
                return "Wednesday";
            case Calendar.THURSDAY:
                return "Thrusday";
            case Calendar.FRIDAY:
                return "Friday";
            case Calendar.SATURDAY:
                return "Saturday";

        }
        return "Cannot find day";
    }

}
