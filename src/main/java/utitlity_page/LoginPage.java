package utitlity_page;

import baselibrary.BaseLibrary;

public class LoginPage extends	BaseLibrary
{
	
	public void getTitle() 
	{
	String	title =	driver.getTitle();
	System.out.println("titile :> "+title);
	}
}
