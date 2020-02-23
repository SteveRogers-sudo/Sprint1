import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

public class Appointment {

	//@SuppressWarnings("unused")
	public static void makeAppointment() {
		Scanner sc = new Scanner(System.in);
		int centerCode = 0;
		int c1testCode = 0;
		int c2testCode = 0;
		
		Random rand = new Random();
		
		Date appointmentDate = new Date();
		System.out.println("WELCOME TO PBP HEALTHCARE");
	//	List<String> Appointmentlist = new ArrayList<>();
		
		HashMap<Integer, List<String>> Appointment= new HashMap<Integer, List<String>>();
		List<String> Appointmentlist = new ArrayList<>();

		List<String> c1testlist = new ArrayList<>();
		c1testlist.add("Test (t1)");
		c1testlist.add("Test (t2)");
		List<String> c2testlist = new ArrayList<>();
		c2testlist.add("Test (t3)");
		c2testlist.add("Test (t4)");

		List<String> centerlist = new ArrayList<>();
		centerlist.add("Center 1 (c1)");
		centerlist.add("Center 2 (c2)");
		centerlist.add("Center 3 (c3)");

		while (true) {
			//ADD VIEW ALL APPOINTMENTS
			System.out.println("LET'S GET YOU AN APPOINTMENT");
			System.out.println("select center code");
			System.out.println(centerlist);

			centerCode = getCenter(sc);
			switch (centerCode) {
			////////////////////////////////////////////
			case 1:
				Appointmentlist.add(0, "center1");
				boolean inCorrect = true;
				do {
					System.out.println(c1testlist);
					c1testCode = getTest(sc);
					if (c1testCode > 2) {
						System.out.println("Invalid Choice!!! Please Select from 1 & 2");
					} else {
						if(c1testCode==1){
							Appointmentlist.add(1, "Test1 (t1)");
						}
						else{
							Appointmentlist.add(1, "Test2 (t2)");
						}
						inCorrect = false;
						SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
						Guest gstObject = new Guest();
						try {
							System.out.println("Enter appointment date (dd/MM/yyyy):");
							String cindate = sc.next();
							Date date1 = myFormat.parse(cindate);
							gstObject.setIndate(date1);
							Appointmentlist.add(2,cindate);
						} catch (ParseException e) {
						}
						
						//Random ID generation
						int AppointmentID = rand.nextInt(100000);
						Appointment.put(AppointmentID, Appointmentlist);
						
						System.out.println("your respose is as follows: "+Appointment);
						System.out.println(" ThankYou \n Your Response Has Been Recorded \n Please visit Again");
						
						//For Printing all Appointments
						for (Entry<Integer, List<String>> entry : Appointment.entrySet()) {
				            Integer k = entry.getKey();
				            List<String> v = entry.getValue();
				            System.out.println("Appointment ID: " + k + ", Details: " + v);
				        }

						System.exit(0);
					}

				} while (inCorrect);
				break;
				/////////////////////////////////////////////////
			case 2:
				Appointmentlist.add(0,"center2");
				boolean inCorrect1 = true;
				do {
					System.out.println(c2testlist);
					System.out.println("select test code");

					c2testCode = getCenter2Test(sc);
					if (c2testCode > 2) {
						System.out.println("Invalid Choice!!! Please Select from 1 & 2");
					} else {
						if(c1testCode==2){
							Appointmentlist.add(1, "Test (t3)");
						}
						else{
							Appointmentlist.add(1, "Test (t4)");
						}
						inCorrect = false;
						SimpleDateFormat myFormat1 = new SimpleDateFormat("dd/MM/yyyy");
						Guest gstObject1 = new Guest();
						try {
							System.out.println("Enter appointment date (dd/MM/yyyy):");
							String cindate = sc.next();
							Date date1 = myFormat1.parse(cindate);
							gstObject1.setIndate(date1);
							Appointmentlist.add(2,cindate);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						int AppointmentID = rand.nextInt(100000);
						
						Appointment.put(AppointmentID, Appointmentlist);
						System.out.println("your respose is as follows: "+Appointmentlist);
						System.out.println(" ThankYou \n Your Response Has Been Recorded \n Please visit Again");
						 
						System.exit(0);
					}

				} while (inCorrect1);
				break;
			/////////////////////////////////////////////////
			case 3:
				Appointmentlist.add(0,"center3");
				boolean inCorrect2 = true;
				do {
					System.out.println(c2testlist);
					System.out.println("select test code");

					c2testCode = getCenter2Test(sc);
					if (c2testCode > 2) {
						System.out.println("Invalid Choice!!! Please Select from 1 & 2");
					} else {
						if(c1testCode==2){
							Appointmentlist.add(1, "Test (t3)");
						}
						else{
							Appointmentlist.add(1, "Test (t4)");
						}
						inCorrect = false;
						SimpleDateFormat myFormat1 = new SimpleDateFormat("dd/MM/yyyy");
						Guest gstObject1 = new Guest();
						try {
							System.out.println("Enter appointment date (dd/MM/yyyy):");
							String cindate = sc.next();
							Date date1 = myFormat1.parse(cindate);
							gstObject1.setIndate(date1);
							Appointmentlist.add(2,cindate);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						System.out.println("your respose is as follows: "+Appointmentlist);
						System.out.println(" ThankYou \n Your Response Has Been Recorded \n Please visit Again");
						 
						System.exit(0);
					}

				} while (inCorrect2);
				break;
			default:
				System.out.println("Please enter 1 & 2 only");
				break;

			}
		}
	}

	private static int getCenter(Scanner sc) {
		int centerCode = 0;
		System.out.println("1. Center 1");
		System.out.println("2. Center 2");
		System.out.println("Enter you choice");
		try {
			centerCode = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Please enter numbers only");
			sc.nextLine();// consume the keyboard value
		}
		return centerCode;
	}

	private static int getTest(Scanner sc) {
		int c1testCode = 0;
		System.out.println("1. Test 1");
		System.out.println("2. Test 2");
		System.out.println("select test code");

		try {
			c1testCode = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Please enter numbers only");
			sc.nextLine();// consume the keyboard value
		}
		return c1testCode;
	}

	private static int getCenter2Test(Scanner sc) {
		int c2testCode = 0;
		System.out.println("1. Test 3");
		System.out.println("2. Test 4");
		System.out.println("select test code");

		try {
			c2testCode = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Please enter numbers only");
			sc.nextLine();// consume the keyboard value
		}
		return c2testCode;
	}

	public static void main(String[] args) {
		makeAppointment();

	}

}
