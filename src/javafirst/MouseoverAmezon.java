package javafirst;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseoverAmezon {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		
		WebElement accountlistlink = driver.findElement(By.xpath(".//*[@id='nav-link-accountList']/span[2]"));
		Actions act = new Actions(driver);
		act.moveToElement(accountlistlink).perform();
		Thread.sleep(3000);

		driver.findElement(By.xpath(".//*[@id='nav-al-your-account']/a[1]/span")).click();
		new WebDriverWait(driver,30).until(ExpectedConditions.titleContains("Your Account"));
		Thread.sleep(3000);
		driver.close();
		
	}

}
