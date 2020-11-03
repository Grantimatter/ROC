import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadValidateDate {
    public static void main(String[] args) {
        String s="12.25.2020"; // dd.MM.yyyy
        Date d = new Date();
        System.out.println(d);

        /*
        * yyyy = year in 4 digits
        * MM - month in 2 digits, MMM - Shortname of the month, MMMM - Full month name
        * dd - date
        * hh - 12 hour
        * HH - 24 hour
        * mm - minutes
        * ss - seconds
        * a - am/pm
        * z/Z - zone
        * EEE - short name of the day,
         */

        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
        // Will it take invalid input and make sense of it
        sdf.setLenient(false);
        Date nd = null;
        try{
            nd=sdf.parse(s);
            System.out.println("Date parsed is : "+nd);
        } catch (ParseException e) {
            System.out.println(e);
        }

    }
}
