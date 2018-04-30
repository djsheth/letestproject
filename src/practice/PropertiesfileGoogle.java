package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PropertiesfileGoogle {
	WebDriver driver;
	WebDriverWait wait;
	Properties prop;
	
  @Test
  public void googleSearch() throws IOException, InterruptedException {
	  prop = new Properties();
	  FileInputStream fis = new FileInputStream("C:\\Users\\sheth\\eclipse-workspace\\JavaFirstDemo\\src\\practice\\google.properties");
	  prop.load(fis);
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	wait=new WebDriverWait(driver,30);
	driver.get(prop.getProperty("url"));
driver.findElement(By.id(prop.getProperty("search_editbox"))).sendKeys(prop.getProperty("search_value"));
Thread.sleep(3000);
driver.close();
  }
}
