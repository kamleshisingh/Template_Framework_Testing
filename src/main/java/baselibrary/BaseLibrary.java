package baselibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class BaseLibrary 
{
	public static WebDriver driver;
	public void launchUrl(String url) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\eclips\\Template_Framework_Testing\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	@AfterTest
	public void closeBrowser() 
	{
		driver.quit();		// this will shut down the browser
//		driver.close();		// this is for close the current tab in the browser
	}
}
