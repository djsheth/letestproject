package testngdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExcelTest {
  @Test
  public void loginGmail() {
	  System.setProperty("webdriver.chrome.driver", "C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.gmail.com/");
		driver.findElement(By.id("identifierId")).sendKeys("shethdj79@gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys(Keys.ENTER);

		driver.findElement(By.name("password")).sendKeys("Niket31507#");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[5]/div[1]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"gb_71\"]")).click();	
  }
  
  public Object[][] passData()
  {
	  Object[][] data = new Object[3][2];
	  
	  
	return data;
	  
  }
}
