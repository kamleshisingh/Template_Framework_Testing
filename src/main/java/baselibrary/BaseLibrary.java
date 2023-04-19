package baselibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import excelutitlities.ExcelUtilities;
import propertyutility.PropertyUtility;

public class BaseLibrary implements ExcelUtilities, PropertyUtility
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
	@Override
	public String excelSheetData(String path, int sheetNo, int rowNo, int cellNo)
	{
		String value ="";
		try {
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(path));
			XSSFSheet sheet = wb.getSheetAt(sheetNo);
			value = sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return value;
	}
}
