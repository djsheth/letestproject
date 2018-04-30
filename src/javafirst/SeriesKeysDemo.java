package javafirst;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SeriesKeysDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.linkedin.com/");
		WebElement Email_Editbox = driver.findElement(By.id("login-email"));
		Actions act = new Actions(driver);
		String selectAll = Keys.chord(Keys.CONTROL,"a");
		Action seriesaction = act.click(Email_Editbox)
								.keyDown(Email_Editbox,Keys.SHIFT)
								.sendKeys(Email_Editbox,"selenium")
								.keyUp(Email_Editbox,Keys.SHIFT)
								.sendKeys(selectAll)
								.contextClick(Email_Editbox)
								//.doubleClick(Email_Editbox)
								.build();
		
		seriesaction.perform();


		Thread.sleep(3000);
		driver.close();
	}		

}
