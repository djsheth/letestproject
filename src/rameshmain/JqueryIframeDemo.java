package rameshmain;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JqueryIframeDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://jqueryui.com/");
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.titleContains("jQuery"));
		driver.findElement(By.linkText("Autocomplete")).click();
		WebElement iframe = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.id("tags")).sendKeys("Selenium");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Accordion")).click();
		Thread.sleep(3000);
		driver.close();
	}

}
