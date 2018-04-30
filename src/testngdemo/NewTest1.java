package testngdemo;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest1 {
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeTest
		public void beforeGoogle(String browser) throws InterruptedException {
		System.out.println("before Test NewTest1");
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
		System.out.println("before class NewTest1");
		driver.get("https://www.google.com/");

	}
	@AfterClass
	public void AfterClass() {
		System.out.println("After class NewTest1");
		driver.close();
	}
	
	//@Parameters("browser")
	@Test
	public void googleSearchTest() {

		String textToBeSearched = "seleniumhq";

		driver.manage().window().maximize();

		driver.get("https://www.google.com");

		// Entering the text in google search box...
		driver.findElement(By.id("lst-ib")).sendKeys("seleni");
		// waiting for the suggestions list
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// locating the list
		WebElement list = driver.findElement(By.xpath("//ul[@class='sbsb_b']"));
		// Getting all the suggestions listed in list
		List<WebElement> suggestions = list.findElements(By.tagName("li"));

		System.out.println(suggestions.size());

		Iterator<WebElement> ite = suggestions.iterator();

		while (ite.hasNext()) {

			WebElement suggestion = ite.next();
			if (suggestion.getText().toLowerCase().trim().equals(textToBeSearched)) {
				suggestion.click();
				break;
			}
		}
	}

	//public void googleFirst() throws InterruptedException {
		//driver.findElement(By.id("lst-ib")).sendKeys("Selenium");
			//		Thread.sleep(3000);
	 // }
}
