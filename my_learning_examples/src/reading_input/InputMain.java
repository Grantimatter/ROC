package reading_input;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class InputMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Name");
		String name=scanner.nextLine();
		System.out.println("Enter Age");
		int age = scanner.nextInt();
		System.out.println("Hello "+age+" year old "+name);
		//Calendar.DAY_OF_WEEK(128);
		Calendar cal = new GregorianCalendar(2020, 6, 19);
		switch(cal.DAY_OF_WEEK) {
		case Calendar.FRIDAY:
			break;
		}
	}

}
