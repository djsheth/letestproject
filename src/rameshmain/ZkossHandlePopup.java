package rameshmain;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZkossHandlePopup {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.zkoss.org/zkdemo/input/date_and_time_picker");
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.titleContains("ZK Live Demo - Date and Time Picker"));
		WebElement iframe = driver.findElement(By.id("twitter-widget-0"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath(".//*[@id='l']")).click();
		Thread.sleep(3000);
		Set<String>handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String pid = it.next();
		System.out.println(pid);
		String chid = it.next();
		System.out.println(chid);
		driver.switchTo().window(chid);
		driver.findElement(By.id("username_or_email")).sendKeys("Dhaval");
		Thread.sleep(3000);
		driver.findElement(By.id("remember")).click();
		driver.close();
		driver.switchTo().window(pid);
		System.out.println(driver.getTitle());
		driver.findElement(By.partialLinkText("Getting Started")).click();
		//driver.findElement(By.xpath(".//*[@id='bFEPp-btn']/i")).click();
		Thread.sleep(3000);
		//driver.close();
		//Thread.sleep(3000);
		driver.quit();
	}

}
