
import java.util.GregorianCalendar;

public class C9E5GregorianCalendar {

    public static void main(String[] args) {

		GregorianCalendar calendar = new GregorianCalendar();
		
        // current date
		System.out.println("Year: " + calendar.get(GregorianCalendar.YEAR));
		System.out.println("Month: " + (calendar.get(GregorianCalendar.MONTH)+1));
		System.out.println("Date: " + calendar.get(GregorianCalendar.DAY_OF_MONTH));
		
        // Set the value to 1234567898765L
        calendar.setTimeInMillis(1234567898765L);

        // display the year, month, and day
		System.out.println("Year: " + calendar.get(GregorianCalendar.YEAR));
		System.out.println("Month: " + (calendar.get(GregorianCalendar.MONTH)+1));
		System.out.println("Date: " + calendar.get(GregorianCalendar.DAY_OF_MONTH));
    }
}
