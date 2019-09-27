package util;

import java.util.regex.Pattern;

import model.M_11_Friends;

public class FormValidator 
{
	boolean status=false;
	public boolean validateAge(M_11_Friends friend) 
	{
		if(friend.getAge()!=0) 
		{
			 status=true;
		}		
		return status;
	}
	
	public boolean validateEmail(M_11_Friends friend) 
	{
		Pattern VALID_EMAIL_ADDRESS_REGEX = 
		Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		java.util.regex.Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(friend.getemailAddress());
		return matcher.find();
	}
	public boolean validateName(M_11_Friends friend) 
	{
		Pattern VALID_NAME_REGEX = 
		Pattern.compile("[a-zA-Z\\-'\\s]", Pattern.CASE_INSENSITIVE);
		java.util.regex.Matcher matcher = VALID_NAME_REGEX .matcher(friend.getfriendName());
		return matcher.find();
	}
}
