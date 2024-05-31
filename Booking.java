package busTicket;

import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Booking {
	String passengerName;
	int busNo;
	Date date;
	
	Booking() {
		Scanner es = new Scanner(System.in);
		System.out.print("Enter name of passenger: ");
		passengerName = es.next();
		System.out.print("Enter bus no: ");
		busNo = es.nextInt();
		System.out.print("Enter date (dd-MM-yyyy): ");
		String dateInput = es.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate currentDate = LocalDate.now();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		 try {
	            LocalDate inputDate = LocalDate.parse(dateInput, formatter);
	           if (!(inputDate.isAfter(currentDate))) {
	                System.out.println("The input date is not after the current date. So Try Up-Comming date!!!");	
	       
	            } 
	           else date=dateFormat.parse(dateInput);
	        }catch (ParseException e) {
	            System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
	        }
	}
	public boolean isAvailable()  throws SQLException{
		
		BusDAO busdao = new BusDAO();
		BookingDAO bookingdao = new BookingDAO();
		int capacity = busdao.getCapacity(busNo);

		int booked = bookingdao.getBookedCount(busNo,date);
		
		return booked<capacity;
		
	}
	
}
