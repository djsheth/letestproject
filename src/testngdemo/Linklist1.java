package testngdemo;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class Linklist1 {
	WebDriverWait wait;
	WebDriver driver;
	
  @Test
  public void f() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,30);
		driver.get("https://www.linkedin.com/");
		//driver.get("http://newtours.demoaut.com/");
		List<WebElement>linklist=driver.findElements(By.tagName("a"));
		String arr[] = new String[linklist.size()];
		System.out.println(linklist.size());
		int i=0;
		for(WebElement l:linklist) {
			if(l!=null) {
			arr[i]=l.getText();
			System.out.println(arr[i]);
			i++;
			}
		}
		for(String s:arr) {
			if(s!=null) {
			try {
				driver.findElement(By.linkText(s)).click();
				Thread.sleep(3000);
				//wait.until(ExpectedConditions.titleContains(s));
				System.out.println(s+"   "+driver.getTitle());
				driver.navigate().back();
			} catch (Exception e) {
				e.printStackTrace();
			}
			}else {
				System.out.println(s+"   is null link");
			}
		}
		driver.close();
		 }
}
