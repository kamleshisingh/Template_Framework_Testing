package baselibrary;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import propertyutility.PropertyUtility;

public class BaseLibrary implements PropertyUtility
{
	public static WebDriver driver;
	String configPropLoc ="D:\\eclips\\Template_Framework_Testing\\src\\main\\test\\testdata\\config.properties";
	public void launchUrl(String url) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\eclips\\Template_Framework_Testing\\src\\main\\test\\drivers\\chromedriver.exe");
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
	@Override
	public String getPropData(String key) {
		String value = "";
		try 
		{
		Properties prop= new Properties();	//this will help us to get data from property file
		prop.load(new FileInputStream(configPropLoc));
		value = prop.getProperty(key);
		} catch (Exception e) {
		
		}
		return value;
	}
}
