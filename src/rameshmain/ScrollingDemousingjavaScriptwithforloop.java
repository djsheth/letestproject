package rameshmain;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollingDemousingjavaScriptwithforloop {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		//WebDriver driver = new EdgeDriver();
		
		System.setProperty("webdriver.chrome.driver","C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']")).sendKeys("Mobiles");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='s-result-count']")));
		
		//Scroll Down
		for(int i=1; i<5; i++) {
driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
		}
		
		Thread.sleep(3000);
		//Scroll Up
				for(int i=1; i<5; i++) {
		driver.findElement(By.tagName("body")).sendKeys(Keys.UP);
				}
				driver.close();
		
	}

}
