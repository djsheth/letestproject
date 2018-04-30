package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class linkrediffp {
	WebDriver driver;
	WebDriverWait wait;
  @Test
  public void fetchlink() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(); 
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	wait=new WebDriverWait(driver,30);
	driver.get("http://www.rediff.com/");
	WebElement seclink = driver.findElement(By.xpath(".//*[@id='homewrapper']/div[14]/p"));
	JavascriptExecutor jsx = (JavascriptExecutor) driver;
	jsx.executeScript("arguments[0].scrollIntoView(true)",seclink );
	Thread.sleep(3000);
	List<WebElement>linklist=seclink.findElements(By.tagName("a"));
	String linkname[] = new String[linklist.size()];
	int i = 0;
	for(WebElement l:linklist) {
		linkname[i]=l.getText();
		i++;
	}
		for(String s:linkname) {
			try {
				driver.findElement(By.linkText(s)).click();
				wait.until(ExpectedConditions.titleContains(s));
				System.out.println(s+"   "+driver.getTitle());
				driver.navigate().back();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	driver.close();
  
  
  }
}
