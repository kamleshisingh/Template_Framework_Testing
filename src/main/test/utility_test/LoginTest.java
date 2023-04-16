package utility_test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baselibrary.BaseLibrary;
import utitlity_page.LoginPage;

public class LoginTest extends BaseLibrary
{
	LoginPage ob;
	@BeforeTest
	public void launchUrl_flipkart() 
	{
		launchUrl("https://www.flipkart.com/");
		ob = new LoginPage();
	}
	@Test(priority = 1)
	public void getTitle1_flipkart() 
	{
		ob.getTitle();
	}
}
