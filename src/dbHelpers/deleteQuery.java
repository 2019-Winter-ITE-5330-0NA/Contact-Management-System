package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.M_11_Friends;

import java.sql.Connection;

public class deleteQuery 
{
	Connection conn=null;
	public deleteQuery() throws ClassNotFoundException
	{
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/as5-kim";
	String username= "root";
	String passwd= "1234";
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url,username,passwd);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}
	
	public void doDelete(int id) {
		try {
			String query=" DELETE FROM `as5-kim`.friends WHERE FriendID=?;";
			PreparedStatement ps =conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		}
		catch(SQLException ex){
		
		}
	}
}
