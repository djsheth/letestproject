package testngdemo;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class ParametersTest {
	
	WebDriver driver;
	WebDriverWait wait;
	
  @Parameters({"url"})
  @Test(priority=1)
  public void navigateUrl(String url) {
		
		driver.get(url);
  }
	
	@Parameters({"uname","pwd"})
	@Test(priority=2)
	public void signIn(String uname, String pwd) {
	driver.findElement(By.id("identifierId")).sendKeys(uname);		
	driver.findElement(By.id("identifierId")).sendKeys(Keys.ENTER);
	driver.findElement(By.name("password")).sendKeys(pwd);
	driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
	}
	
	@Test(priority=3)
	  public void logoutTest() {
driver.findElement(By.xpath("//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[5]/div[1]/a/span")).click();
driver.findElement(By.xpath(".//*[@id='gb_71']")).click();
	}
	
	
  @BeforeTest
  public void launchBrowser() {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,30);
		  driver.manage().deleteAllCookies();

  }

  @AfterTest
  public void closeBrowser() {
	  driver.quit();
  }

}
