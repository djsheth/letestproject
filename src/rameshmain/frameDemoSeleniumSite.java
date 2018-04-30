package rameshmain;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class frameDemoSeleniumSite {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://docs.seleniumhq.org/");
		driver.findElement(By.xpath(".//*[@id='menu_download']/a")).click();
		driver.findElement(By.linkText("Javadoc")).click();
		driver.switchTo().frame("classFrame");
		Thread.sleep(3000);
		for(int i = 4; i<=7; i++) {
			
		driver.findElement(By.xpath("html/body/div[1]/ul/li["+i+"]/a")).click();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());

		}
	driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.close();
		
	}

}
