package testngdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest3 {
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeTest
		public void beforeGoogle(String browser) throws InterruptedException {
		System.out.println("before Test NewTest3");
			if(browser.equalsIgnoreCase("chrome")) {
			  
			  System.setProperty("webdriver.chrome.driver","C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			}else{
				System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
				driver = new EdgeDriver();
				
			}
				driver.manage().window().maximize();

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class NewTest3");
		driver.get("http://www.rediff.com/");
	}
	
	
	@AfterClass
	public void AfterClass() {
		System.out.println("After class NewTest3");
		driver.close();
	}
	
	@Test
	public void rediff() throws InterruptedException {
		  driver.findElement(By.linkText("Sign in")).click();
					Thread.sleep(3000);
	  }
}
