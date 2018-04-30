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

public class NewTest2 {
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeTest
		public void beforeGoogle(String browser) throws InterruptedException {
		System.out.println("before Test NewTest2");
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
		System.out.println("before class NewTest2");
		driver.get("https://www.linkedin.com/");

	}
	
	@AfterClass
	public void AfterClass() {
		System.out.println("After class NewTest2");
		driver.close();
	}
	
	@Test
	public void linked() throws InterruptedException {
		  
		driver.findElement(By.id("login-email")).sendKeys("shethdj79@gmail.com");			
		Thread.sleep(3000);
	  }
}
