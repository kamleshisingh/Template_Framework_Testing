package baselibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

}
