package testngdemo;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class CheckboxCountTest {
	
	WebDriver driver;
	
	@Parameters("browserName")
  @BeforeTest
  public void beforeTest(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
			}
		else{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		  driver.get("http://browsershots.org/");

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
  

  @AfterTest
  public void afterTest() {
	  
	  driver.quit();
  }

  
  
  
  @Test
  public void checkboxCountTest() {
	  
	  driver.get("http://browsershots.org/");
	  //fetch all checkbox count
	  List<WebElement>checkboxlist = driver.findElements(By.xpath("//input[@type='checkbox']"));
	  Reporter.log("total number of checkboxe count is: "+checkboxlist.size());
	  
	//fetch all checked checkbox count
	  List<WebElement>chekedcheckboxlist = driver.findElements(By.xpath("//input[@type='checkbox' and @checked='checked']"));
	  Reporter.log("total number of checkboxe count is: "+chekedcheckboxlist.size());
	  
	//fetch all checked checkbox count
	  List<WebElement>uncheckedcheckboxlist = driver.findElements(By.xpath("//input[@type='checkbox' and not(@checked='checked')]"));
	  Reporter.log("total number of checkboxe count is: "+uncheckedcheckboxlist.size());
  }
  
}
