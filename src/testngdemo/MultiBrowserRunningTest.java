package testngdemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowserRunningTest {
	WebDriver driver;
	WebDriverWait wait;
	Properties prop;

	@BeforeClass
	public void setup() throws IOException {
		// create Object for properties class
		try {
			prop = new Properties();
			// read properties file to program
			FileInputStream fis = new FileInputStream("\\Users\\sheth\\eclipse-workspace\\JavaFirstDemo\\src\\testngdemo\\data.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void readPropFromFileTest() {
		driver.get("http://linkedin.com");
		Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "title is not matching");
		Reporter.log("verified the page title");
		driver.findElement(By.id(prop.getProperty("email_editbox"))).sendKeys(prop.getProperty("email_value"));
		Reporter.log("typed the username in email editbox");
		driver.findElement(By.name(prop.getProperty("password_editbox"))).sendKeys(prop.getProperty("password_value"));
		Reporter.log("typed the password in password editbox");
		driver.findElement(By.id(prop.getProperty("signin_btn"))).click();
		Reporter.log("clicked on sigin button");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Home']")));
		Reporter.log("verifying the home page-- Home tab");

		Reporter.log("click on image icon");
		driver.findElement(By.xpath("//img[@class='nav-item__profile-member-photo nav-item__icon']")).click();
		// identify the signin out link
		WebElement signOut_link = driver.findElement(By.xpath("//*[@data-control-name='nav.settings_signout']"));
		Reporter.log("wait for the visibility of signout link in the panel");
		wait.until(ExpectedConditions.visibilityOf(signOut_link));
		signOut_link.click();
		Reporter.log("clicked on the signOut_link ");
		wait.until(ExpectedConditions.titleContains("LinkedIn: Log In or Sign Up"));
		Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "title is not matching");
		Reporter.log("verified the landing page title after logout");

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
