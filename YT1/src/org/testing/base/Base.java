package org.testing.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
    
	public ChromeDriver driver;
	public Properties pr;
	
	@BeforeMethod 
	public void launch() throws IOException {
	
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_exe/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    File f = new File("../YTFramework/Locators.properties");
	    FileInputStream fi = new FileInputStream(f);
	    pr = new Properties();
	    pr.load(fi);
	    
	}

	
	@AfterMethod
	public void close() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(pr.getProperty("Signouticon"))).click();
		driver.findElement(By.xpath(pr.getProperty("Signout"))).click();
		driver.close();
	}
}
