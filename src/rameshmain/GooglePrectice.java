package rameshmain;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePrectice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,30);	
		driver.get("https://www.google.com/");
		
		//WebElement serch_editbox = driver.findElement(By.xpath(".//*[@id='gs_htif0']"));
		//JavascriptExecutor jsx = (JavascriptExecutor) driver;
		//jsx.executeScript("arguments[0].value='Selenium';",serch_editbox);
driver.findElement(By.id("lst-ib")).sendKeys("Selenium");
Thread.sleep(3000);
driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
wait.until(ExpectedConditions.titleContains("Selenium - Google Search"));	
driver.close();
	}

	}


