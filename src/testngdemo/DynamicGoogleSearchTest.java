package testngdemo;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DynamicGoogleSearchTest {

	WebDriver driver;

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
	
	 @Parameters("browserName")
	  @BeforeTest
	  public void beforeTest(String browserName) {
		 if(browserName.equalsIgnoreCase("chrome")) {
				
				System.setProperty("webdriver.chrome.driver","C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				
				}
			else{
				System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
				driver = new EdgeDriver();
			}
		 
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	 @AfterTest
	  public void afterTest() {
		  
		  driver.quit();
	  }


}
