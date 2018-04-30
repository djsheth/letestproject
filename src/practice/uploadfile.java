package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class uploadfile {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://html.com/input-type-file/");
	WebElement browser_button = driver.findElement(By.xpath(".//*[@id='fileupload']"));
	JavascriptExecutor jsx = (JavascriptExecutor) driver;
	jsx.executeScript("arguments[0].scrollIntoView(true)", browser_button);
	driver.findElement(By.xpath(".//*[@id='fileupload']")).sendKeys("C:\\Users\\sheth\\OneDrive\\Desktop\\Selenium\\Book1.xlsx");
	Thread.sleep(5000);
	driver.close();

	}

}
