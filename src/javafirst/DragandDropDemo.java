package javafirst;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragandDropDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://jqueryui.com/slider/");
		WebElement iframe = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(iframe);
		WebElement TargetElement = driver.findElement(By.xpath(".//*[@id='slider']/span"));
		Actions act = new Actions(driver);
		act.dragAndDropBy(TargetElement, 300, 0).perform();
		Thread.sleep(3000);
		act.dragAndDropBy(TargetElement, -100, 0).perform();
		Thread.sleep(3000);
		driver.close();
	}

}
