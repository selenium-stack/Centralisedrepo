package org.testing.pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




  public class Signin {
   
	 ChromeDriver driver;
	 Properties pr;
	public Signin(ChromeDriver driver, Properties pr) {
		this.driver=driver;
		this.pr=pr;
		
	}
	
  public void  login(String username,String pass) throws InterruptedException {
	
	  driver.findElement(By.xpath(pr.getProperty("Signin"))).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.xpath(pr.getProperty("Login"))).sendKeys(username);
	  driver.findElement(By.xpath(pr.getProperty("ClickNext"))).click();
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Enter your password']")));
	  driver.findElement(By.xpath(pr.getProperty("Pass"))).sendKeys(pass);
	  driver.findElement(By.xpath(pr.getProperty("ClickNext"))).click();
	  Thread.sleep(50000);
  }


}
