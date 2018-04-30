package rameshmain;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class FindBrokenLinkByClickrediffsite {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get("http://newtours.demoaut.com/");
		//driver.get("https://www.linkedin.com/");
		driver.get("http://www.rediff.com/");
		String exptitle = "Not Found";
		List<WebElement>linklist= driver.findElements(By.tagName("a"));
		String [] linkname = new String [linklist.size()];
		int i = 0;
		for(WebElement l:linklist) {
			linkname[i] = l.getText();
			i++;
		}
		for(String s:linkname) {
			try {
				driver.findElement(By.linkText(s)).click();
				Thread.sleep(2000);
				if(driver.getTitle().contains(exptitle)) {
					System.out.println(s+" is Broken Link and Page Title is "+driver.getTitle());
				}else {
					System.out.println(s+" is Working Link and Page Title is "+driver.getTitle());
				}
			} catch (Exception e) {
				System.out.println("This link is not working");
				e.printStackTrace();
			}
			driver.navigate().back();
		}
		driver.close();
		
		
	}

}
