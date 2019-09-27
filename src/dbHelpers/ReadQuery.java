package dbHelpers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;


import com.sun.istack.internal.logging.Logger;

import model.M_11_Friends;

public class ReadQuery 
{
	Connection conn=null;
	ResultSet results=null;
	
	public ReadQuery() throws ClassNotFoundException 
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
	
	public void doRead() {
		try {
			String query="Select * from friends;";
			PreparedStatement ps =conn.prepareStatement(query);
			this.results= ps.executeQuery();
		}
		catch(SQLException ex){
		
		}
	}
	
	public String getHTMLTable() 
	{
		String table="";
		table+="<table border=1>";
		try {
			while(this.results.next()) 
			{
				M_11_Friends friend = new M_11_Friends();
				friend.setFriendID(this.results.getInt("friendID"));
				friend.setfriendName(this.results.getString("friendName"));
				friend.setemailAddress(this.results.getString("emailAddress"));
				friend.setAge(this.results.getInt("age"));
				friend.setfavouriteColor(this.results.getString("favouriteColor"));
				
				table+="<tr>";
					table+="<td>";
						table+=friend.getFriendId();
					table+="</td>";
					table+="<td>";
						table+=friend.getfriendName();
					table+="</td>";
					table+="<td>";
						table+=friend.getemailAddress();
					table+="</td>";
					table+="<td>";
						table+="<a href='C_11_delete?id="+friend.getFriendId()+"'>Delete</a>";
				table+="</td>";
				table+="</tr>";
			}
				table+="</table>";		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return table;
	}
}
