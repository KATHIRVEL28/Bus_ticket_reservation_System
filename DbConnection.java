package busTicket;

import java.sql.*;
public class DbConnection {
	public static Connection getConnection() throws SQLException{
		return  DriverManager.getConnection("jdbc:mysql://localhost:3306/BusReservation","root","Kathir@28");
	}

}