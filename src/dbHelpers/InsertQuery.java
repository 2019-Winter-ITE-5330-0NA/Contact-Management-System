package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.M_11_Friends;

public class InsertQuery {
	Connection conn=null;
	ResultSet results=null;
	
	public InsertQuery() throws ClassNotFoundException 
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
	
	public void doInsert(M_11_Friends friend) {
		try {
			String query=" insert into `as5-kim`.friends(friendName,emailAddress,age,favouriteColor)" + 
					"values(?,?,?,?);";
			PreparedStatement ps =conn.prepareStatement(query);
			ps.setString(1, friend.getfriendName());
			ps.setString(2, friend.getemailAddress());
			ps.setInt(3, friend.getAge());
			ps.setString(4, friend.getfavouriteColor());
			ps.executeUpdate();
		}
		catch(SQLException ex){
		
		}
	}

}
