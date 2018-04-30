package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NaukriMouseOver {
	WebDriver driver;
	WebDriverWait wait;
	
  @Test
  public void MouseOver() throws InterruptedException {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	wait=new WebDriverWait(driver,30);
	driver.get("https://www.naukri.com/");
	WebElement serviceLink=driver.findElement(By.linkText("Services"));
	Actions axl = new Actions(driver);
	axl.moveToElement(serviceLink).build().perform();
	Thread.sleep(3000);
	driver.findElement(By.xpath("html/body/div[3]/div/ul/li[4]/div/ul[1]/li[2]/a")).click();
	Thread.sleep(3000);
	driver.close();
	
	
	

  }
}
