package testngdemo;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class ReadingDataFromPropFile {

	WebDriver driver;
	WebDriverWait wait;
	Properties prop;

	@Test(priority = 1)
	public void navigateUrl() {

		driver.get(prop.getProperty("url"));
	}

	@Test(priority = 2)
	public void signIn() throws InterruptedException {
		driver.findElement(By.id(prop.getProperty("email_editbox"))).sendKeys(prop.getProperty("email_value"));
		driver.findElement(By.id(prop.getProperty("email_editbox"))).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.name(prop.getProperty("password_editbox"))).sendKeys(prop.getProperty("pass_value"));
		driver.findElement(By.name(prop.getProperty("password_editbox"))).sendKeys(Keys.ENTER);
	}

	@Test(priority = 3)
	public void logoutTest() throws InterruptedException {
		driver.findElement(By.xpath(prop.getProperty("d_btn"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("signout_btn"))).click();
	}

	@BeforeClass
	public void setUp() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("\\Users\\sheth\\eclipse-workspace\\JavaFirstDemo\\src\\testngdemo\\data.properties");
		prop.load(fis);

		System.setProperty("webdriver.chrome.driver", "C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
		driver.manage().deleteAllCookies();

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
