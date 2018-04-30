package testngdemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class GroupTestDemo {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	  public void search(String s) {
		  
		  driver.findElement(By.id("lst-ib")).sendKeys(s);
		  driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
		  wait.until(ExpectedConditions.titleContains(s));
		  Assert.assertEquals(driver.getTitle(), s+" - Google Search");

	  }
	   @Test(groups= {"smoke"},priority=1)
  public void verifyHomePageTitle() {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,30);
		  driver.manage().deleteAllCookies();
		  driver.get("https://www.google.com/");

	  Reporter.log("Verify Google Home Page Title");
	  Assert.assertEquals(driver.getTitle(), "Google","Title is not match");
  }
  
  @Test(groups= {"smoke","sanity"},priority=2,alwaysRun=true)
  public void verifySearchEditBox() {
	  
	  Reporter.log("Verify pagetitle after enter searching word");
	  this.search("Selenium");
  }
  
  @Test(groups= {"smoke"},priority=3,enabled=false)
  public void clickonSigninLink() {
	  
	  Reporter.log("Click on Sign in Link");
  }
  
  @Test(groups= {"smoke"},priority=4)
  public void closeBrowser() {
	  
	  Reporter.log("Close Browser");
	  driver.quit();
  }
  
  

  

}
