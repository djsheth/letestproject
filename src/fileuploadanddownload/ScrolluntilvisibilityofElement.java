package fileuploadanddownload;

import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrolluntilvisibilityofElement {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://my.monsterindia.com/create_account.html");
		WebElement browser_btn = driver.findElement(By.id("wordresume"));
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("arguments[0].scrollIntoView(true)", browser_btn);
		Thread.sleep(3000);
		driver.close();
		
		
	}

}
