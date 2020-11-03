package java8timeapi;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Demo1 {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();
        System.out.println(ld);
        ld = ld.plusYears(10);
        System.out.println(ld);
        System.out.println(ld.getYear() + " is" + (ld.isLeapYear() ? "" : " not") + " a leap year.");

        LocalDate dob = LocalDate.parse("06-19-1997", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        System.out.println("dob = " + dob);
        LocalDate curr = LocalDate.now();
        System.out.println("curr = "+curr);

        Period p = Period.between(dob, curr);
        System.out.println("You are " + p.getYears() + " years " + p.getMonths() + ", months, and " + p.getDays() + " days old.");

        System.out.println("DAYS : " + ChronoUnit.DAYS.between(dob, curr));
        System.out.println("MONTHS : " + ChronoUnit.MONTHS.between(dob, curr));
    }
}
