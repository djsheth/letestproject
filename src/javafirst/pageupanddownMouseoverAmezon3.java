package javafirst;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pageupanddownMouseoverAmezon3 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']")).sendKeys("Mobiles");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		act.sendKeys(Keys.PAGE_DOWN).perform();
		act.pause(3000L).perform();
		act.sendKeys(Keys.PAGE_UP).perform();
		Thread.sleep(3000);
		driver.close();
		
			}

}
