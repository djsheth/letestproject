package javafirst;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ScroolUsingEventFiringWd {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://conceptlogic.com/jcart/");
		EventFiringWebDriver evnt = new EventFiringWebDriver(driver);
		evnt.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(3000);
		evnt.executeScript("window.scrollBy(0,-400)", "");
		Thread.sleep(3000);
		driver.close();
	}

}
