package rameshmain;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollingDemousingjavaScriptforElement {

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
		WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("s-result-count")));
		
		JavascriptExecutor	jsk = (JavascriptExecutor)driver;
		//Scroll Down
		WebElement backtotop = driver.findElement(By.xpath(".//*[@id='navBackToTop']/div/span"));
		
		jsk.executeScript("arguments[0].scrollIntoView(true)",backtotop);
		Thread.sleep(3000);
				driver.close();
		
	}

}
