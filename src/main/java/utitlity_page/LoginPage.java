package utitlity_page;

import org.openqa.selenium.support.PageFactory;

import baselibrary.BaseLibrary;

public class LoginPage extends	BaseLibrary
{
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}
	public void getTitle() 
	{
	String	title =	driver.getTitle();
	System.out.println("titile :> "+title);
	}
}
