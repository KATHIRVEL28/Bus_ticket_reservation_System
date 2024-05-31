package busTicket;

import java.sql.*;
public class BusDAO {
	public void displayBusInfo() throws SQLException {
		String query = "Select * from bus";
		Connection con = DbConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			System.out.print("Bus No: " + rs.getInt(1)+", ");
			if(rs.getInt(2)==0)
				System.out.print("Non-AC Bus  ");
			else
				System.out.print("  Ac Bus    ");
			System.out.print("and Capacity: " + rs.getInt(3));
			System.out.println();
			}
		
		System.out.println("------------------------------------------");
	}
	
// busdao.getCapacity --> booking.java	
	public int getCapacity(int id) throws SQLException {
		
		String query = "Select capacity from bus where id=" + id;
		Connection con = DbConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
}