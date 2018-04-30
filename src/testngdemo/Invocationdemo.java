package testngdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Invocationdemo {
	WebDriver driver = null;
  @Test(invocationCount=3)//This method is execute 3 times
  public void googleclick() {
	  System.setProperty("webdriver.chrome.driver","C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.findElement(By.linkText("Sign in")).click();
		driver.navigate().back();
  }
  
  @Test(dependsOnMethods= {"googleclick"})
  public void closeBrowser() {
	  driver.quit();
	    }
}
