package busTicket;

import java.util.Scanner;
import java.util.Date;
import java.sql.*;
public class BookingDAO {
public void addBooking(Booking booking) throws SQLException{
		
		int book_id=bookingId();
		String query = "Insert into booking values(?,?,?,?)";
		Connection con = DbConnection.getConnection();
		java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, book_id+1);
		pst.setString(2, booking.passengerName);
		pst.setInt(3, booking.busNo);
		pst.setDate(4, sqldate);
		pst.executeUpdate();
	}
	
	public int getBookedCount(int busNo,Date date) throws SQLException{
		String query = "select count(passenger_name) from booking where bus_no=? and travel_date=?";
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		pst.setInt(1, busNo);
		pst.setDate(2, sqldate);
		ResultSet rs = pst.executeQuery();
		rs.next();
		return rs.getInt(1);
	}
	

	public static int bookingId() throws SQLException {
		// TODO Auto-generated method stub
		String query="select max(book_id) from booking";
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

	public void showDetails() throws SQLException {
		// TODO Auto-generated method stub
		String query = "Select * from booking";
		Connection con = DbConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		if(!rs.next()) System.out.println("No bookings");
		else
		{
			do{		
				System.out.println("Ticket_id : " + rs.getInt(1));
				System.out.println("Passenger_name : " + rs.getString(2));
				System.out.println("Bus_No. : " + rs.getInt(3));
				System.out.println("Travelling_Date : " + rs.getDate(4));
			}while(rs.next());
		}
		
		System.out.println("------------------------------------------");
	}

	public static void removeBooking() throws SQLException {
		// TODO Auto-generated method stub
		Scanner es=new Scanner(System.in);
		System.out.print("Enter Your Ticket Id : ");
		int ID=es.nextInt();
		String query = "delete from booking where book_id=?";
		Connection con = DbConnection.getConnection();
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, ID);
        int row = st.executeUpdate();
		if(row>0) System.out.println("Cancellation successful");
		else System.out.println("Rocord Not Found");		 
		
	}
}