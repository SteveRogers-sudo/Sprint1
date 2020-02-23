import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MyDate {
	public static void main(String[] args)
	{
	    Scanner input = new Scanner(System.in);
	    SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
	    Guest gstObject = new Guest();
	    try {
	        System.out.println("Enter check-in date (dd/MM/yyyy):");
	        String cindate = input.next();
	        Date date1 = myFormat.parse(cindate);
	        gstObject.setIndate(date1);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	}
}
