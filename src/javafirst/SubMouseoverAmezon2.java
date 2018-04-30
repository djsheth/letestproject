package javafirst;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubMouseoverAmezon2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		WebDriverWait wait = new WebDriverWait(driver,30);

		WebElement accountlistlink = driver.findElement(By.xpath(".//*[@id='nav-link-shopall']/span[2]"));
		Actions act = new Actions(driver);
		act.moveToElement(accountlistlink).perform();
		WebElement Electroniclink = driver.findElement(By.xpath(".//*[@id='nav-flyout-shopAll']/div[2]/span[10]/span"));
		
		wait.until(ExpectedConditions.visibilityOf(Electroniclink));
		act.moveToElement(Electroniclink).perform();
		driver.findElement(By.xpath(".//*[@id='nav-flyout-shopAll']/div[3]/div[10]/div[1]/div/a[7]/span")).click();
		System.out.println(driver.getTitle());
		WebElement Wireless = driver.findElement(By.xpath(".//*[@id='hybridBrowse']/h1"));
		wait.until(ExpectedConditions.visibilityOf(Wireless));

		Thread.sleep(3000);

				driver.close();
		
	}

}
