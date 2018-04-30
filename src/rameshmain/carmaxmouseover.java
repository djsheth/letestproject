package rameshmain;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class carmaxmouseover {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String url = "https://www.naukri.com/";
		driver.get(url);
		WebElement joblink = driver.findElement(By.xpath("html/body/div[2]/div/ul/li[3]/a/div"));
		Actions act = new Actions(driver);
		act.moveToElement(joblink).build().perform();
		String pid = driver.getWindowHandle();
		System.out.println(pid);
		for(int i=1; i<=5; i++) {
			act.moveToElement(joblink).build().perform();
			driver.findElement(By.xpath("html/body/div[2]/div/ul/li[3]/div/ul/li["+i+"]/a")).click();
			Thread.sleep(5000);
			Set<String>handles=driver.getWindowHandles();
			int count = handles.size();
			System.out.println(count+"  "+handles);
			for(String c:handles) {
			if(!pid.equalsIgnoreCase(c)) {
				driver.switchTo().window(c);

			driver.close();
			driver.switchTo().window(pid);
			}
			}
		}
		
		driver.quit();
		
		
	}

}
