package busTicket;

import java.util.Scanner;
public class BusDemo {
	public static void main(String[] args)  {
		BusDAO busdao = new BusDAO();
		try {
			busdao.displayBusInfo();
			int usIp = 1;
			Scanner es = new Scanner(System.in);			
			while(usIp==1||usIp==2||usIp==3) {
				System.out.println(" Enter \n 1. to Book \n 2. to view Booked Details \n 3. to Cancel Your Booking \n 4. to exit");
				usIp = es.nextInt();
				if(usIp == 1) {
					Booking booking = new Booking();
					if(booking.isAvailable()) {
						BookingDAO bookingdao = new BookingDAO();
						bookingdao.addBooking(booking);
						System.out.print("Your booking is confirmed, ");
						System.out.println("and Your Ticket id is "+ BookingDAO.bookingId());
						System.out.println("------------------------------------------");
					}
					else
					{
						System.out.println("Sorry. Bus is full. Try another bus or date.");
					    System.out.println("------------------------------------------");
					}
				}
				if(usIp == 2) {
					BookingDAO bookingdao = new BookingDAO();
					bookingdao.showDetails();
				}
				if(usIp == 3) {
					BookingDAO.removeBooking();
					System.out.println("------------------------------------------");
				}
				if(usIp == 4) 
				{
					System.out.println("You have successfully exited.");  
					System.out.println("------------------------------------------");
				}
			}
			es.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
