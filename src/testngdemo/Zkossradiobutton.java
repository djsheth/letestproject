package testngdemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class Zkossradiobutton {
	WebDriver driver = null;
	WebDriverWait wait = null;
	
  @Test(description="Select Radio Button",priority=3)
  public void clickRadioButton() {
	  
	  driver.findElement(By.xpath("//*[text()='Performance']/preceding::input[1]")).click();
	  
	  driver.findElement(By.xpath("//*[text()='Forum']/preceding::input[1]")).click();

	  driver.findElement(By.xpath("//*[text()='Developer Guide']/preceding::input[1]")).click();

  }
  
  @Test(description="fetch all button link",priority=1)
  public void verifyButtonLink() {
		wait = new WebDriverWait(driver,30);

	  driver.findElement(By.xpath("//*[starts-with(text(),'Button')]")).click();
	  WebElement below_button = driver.findElement(By.className("resourcelb"));
	  wait.until(ExpectedConditions.visibilityOf(below_button));
	  List<WebElement>buttons = driver.findElements(By.className("z-button"));
	  Reporter.log("All button link name");

	  for(WebElement b:buttons) {
		  Reporter.log(b.getText());
		  }
  }

  @Test(description="Select all check box",priority=2)
  public void selectAllCheckbox() throws InterruptedException {
		wait = new WebDriverWait(driver,30);
		  driver.findElement(By.xpath("//*[starts-with(text(),'Checkbox')]")).click();
	  wait.until(ExpectedConditions.titleContains("ZK Live Demo - Checkbox"));
	  Assert.assertEquals(driver.getTitle(), "ZK Live Demo - Checkbox");
	  List<WebElement>checkbox = driver.findElements(By.className("z-checkbox"));
	  Reporter.log("All Check box name");

	  for(WebElement c:checkbox) {
		  Reporter.log(c.getText());
		  c.click();
		  }
  }
  
  @BeforeMethod
  public void navigatetoSite() {
		wait = new WebDriverWait(driver,30);
	  driver.get("https://www.zkoss.org/zkdemo/input/radio_button");
	  wait.until(ExpectedConditions.titleContains("ZK Live Demo - Radio Button"));
	  Reporter.log("Verify home page Title");
	  Assert.assertEquals(driver.getTitle(), "ZK Live Demo - Radio Button");
  }

  @AfterMethod
  public void deleteCookies() {
	 
	  driver.manage().deleteAllCookies();
  }

  @BeforeClass
  public void launchBrowser() {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
  }

  @AfterClass
  public void closeBrowser() {
	  driver.quit();
  }

}
