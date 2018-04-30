package rameshmain;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ScrollingDemousingjavaScript {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']")).sendKeys("Mobiles");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		JavascriptExecutor	jsk = (JavascriptExecutor)driver;
		//Scroll Down

		jsk.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(3000);
		//Scroll Up
		jsk.executeScript("window.scrollBy(0,-500)", "");
		Thread.sleep(3000);
				driver.close();
		
	}

}
