package testngdemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class YahooSearchDataDriven {
	
	WebDriver driver = null;
	WebDriverWait wait = null;
	
  @Test(dataProvider = "yahoosearchdata")
  public void yahooSearch(String s) throws InterruptedException {
	  driver.findElement(By.xpath(".//*[@id='uh-search-box']")).sendKeys(s);
	  driver.findElement(By.xpath(".//*[@id='uh-search-box']")).sendKeys(Keys.ENTER);
	  Thread.sleep(3000);
	  wait.until(ExpectedConditions.titleContains(s));
	  Assert.assertEquals(driver.getTitle(), s+" - Yahoo Search Results","page title is match");
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver.navigate().to("https://www.yahoo.com/");
	  
  }

  @AfterMethod
  public void deleteCookies() {
	  driver.manage().deleteAllCookies();
  }


  @DataProvider (name="yahoosearchdata")
  public Object[][] searchData() {
	  Object [][] data = new Object[3][1];
	  data[0][0] = "Selenium";
	  data[1][0] = "UFT";
	  data[2][0] = "Java";

    return data;
  }
  @BeforeClass
  public void launchBrowser() {
	  System.setProperty("webdriver.chrome.driver","C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,30);
		  driver.manage().deleteAllCookies();

  }

  @AfterClass
  public void closeBrowser() {
	  driver.quit();
  }
  	
  @BeforeTest
  public void beforeTest() {
	  Reporter.log("I am in Before Test");
  }

  @AfterTest
  public void afterTest() {
	  Reporter.log("I am in After Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  Reporter.log("I am in Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  Reporter.log("I am in After Suite");
  }

}
