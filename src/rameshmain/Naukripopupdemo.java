package rameshmain;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Naukripopupdemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");
		String pid = driver.getWindowHandle();
		System.out.println(pid);
		Set<String>handles = driver.getWindowHandles();
		for(String h:handles) {
			System.out.println(h);
			if(!pid.equals(h)) {
				driver.switchTo().window(h);
				driver.close();
			}
		}
		driver.switchTo().window(pid);
		Thread.sleep(3000);
		driver.quit();
	}

}
