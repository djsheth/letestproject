package rameshmain;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ScrollingDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.imdb.com/chart/top");
		//driver.navigate().to("http://www.conceptlogic.com/jcart/");
		EventFiringWebDriver evnt =  new EventFiringWebDriver(driver);
		//Scroll Down
		evnt.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
		//Scroll Up
		evnt.executeScript("window.scrollBy(0,-700)", "");
		Thread.sleep(3000);
		driver.close();
		
	}

}
