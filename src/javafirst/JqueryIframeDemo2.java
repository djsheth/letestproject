package javafirst;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JqueryIframeDemo2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://jqueryui.com/droppable/");
		WebElement iframeElement = driver.findElement(By.className("demo-frame"));
		Thread.sleep(3000);
		driver.switchTo().frame(iframeElement);
		Actions act = new Actions(driver);
		WebElement secElement = driver.findElement(By.id("draggable"));
		
		WebElement tgtElememnt = driver.findElement(By.id("droppable"));
		//act.dragAndDrop(secElement, tgtElememnt);
		Thread.sleep(3000);
		act.clickAndHold(secElement).perform();
		act.moveToElement(tgtElememnt).perform();
		Thread.sleep(3000);
		act.release().perform();
		Thread.sleep(3000);
		driver.close();
	}

}
