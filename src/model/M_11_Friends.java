package model;

public class M_11_Friends {
	private int friendID;
	private String friendName;
	private String emailAddress;
	private int age;
	private String favouriteColor;
	
	public M_11_Friends() 
	{
		this.friendID=0;
		this.friendName="";
		this.emailAddress="";
		this.age=0;
		this.favouriteColor="";
	}
	
	public M_11_Friends(int friendID, String friendName, String emailAddress, int age,String favouriteColor) 
	{
		this.friendID=friendID;
		this.friendName=friendName;
		this.emailAddress=emailAddress;
		this.age=age;
		this.favouriteColor=favouriteColor;
	}
	
	public int getFriendId() 
	{
		return friendID;
	}
	public void setFriendID(int friendID) 
	{
		this.friendID=friendID;
	}
	
	public String getfriendName() 
	{
		return friendName;
	}
	public void setfriendName(String friendName) 
	{
		this.friendName=friendName;
	}
	
	public String getemailAddress() 
	{
		return emailAddress;
	}
	public void setemailAddress(String emailAddress) 
	{
		this.emailAddress=emailAddress;
	}
	
	public int getAge() 
	{
		return age;
	}
	public void setAge(int age) 
	{
		this.age=age;
	}
	
	public String getfavouriteColor() 
	{
		return favouriteColor;
	}
	public void setfavouriteColor(String favouriteColor) 
	{
		this.favouriteColor=favouriteColor;
	}
	
	public String toString() 
	{
		return "Friends{ ID " + friendID + " Name: "+friendName +" Email: " + emailAddress + " Age: " +age + "Favourite Color: "+ favouriteColor;
	}
}
