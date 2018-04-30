package javafirst;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubMouseoverWalmart {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.walmart.com/");
		WebDriverWait wait = new WebDriverWait(driver,30);

		WebElement accountlistlink = driver.findElement(By.xpath(".//*[@id='header-GlobalLefthandNav-toggle-1']"));
		Actions act = new Actions(driver);
		act.moveToElement(accountlistlink).perform();
		WebElement Electroniclink = driver.findElement(By.xpath(".//*[@id='superDeptId-0']"));
		
		wait.until(ExpectedConditions.visibilityOf(Electroniclink));
		act.moveToElement(Electroniclink).perform();
		driver.findElement(By.xpath(".//*[@id='superDept-0']/div[1]/div[2]/a[3]")).click();
		System.out.println(driver.getTitle());
		wait.until(ExpectedConditions.titleContains("DVD & Blu-ray Players - Walmart.com"));

		Thread.sleep(3000);

				driver.close();
		
	}

}
