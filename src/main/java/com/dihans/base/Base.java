package com.dihans.base;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.dihans.utility.PropertiesReader;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	
	public Base() {
		PropertiesReader.loadProperties();
		prop = PropertiesReader.PROP;
	}
	
	
	public static void initialize() {
		
		String browser = prop.getProperty("browser");		
		
		if(browser.equals("chrome") && System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") 
					+File.separator+ "src" 
					+File.separator+ "test"
					+File.separator+ "resources"
					+File.separator+ "chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (browser.equals("chrome") && !System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") 
					+File.separator+ "src" 
					+File.separator+ "test"
					+File.separator+ "resources"
					+File.separator+ "chromedriverForMac84");
			driver = new ChromeDriver();
		}
		
	driver.manage().window().maximize();
		
	}
	
	public static void goToHomePage() {
		driver.get("https://www.dihans.com");
	}
	
	public static void wait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		initialize();
	}
	
	
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	
	
}
