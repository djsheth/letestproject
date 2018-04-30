package javafirst;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class FindBrokenLinksByClick {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String expTitle = "Not Found";
		driver.get("http://newtours.demoaut.com/");
		List<WebElement>linklist=driver.findElements(By.tagName("a"));
		String[]linknames = new String[linklist.size()];
		int i = 0;
		for(WebElement l:linklist) {
			linknames[i] = l.getText();
			i++;
		}
		for(String t:linknames) {
			driver.findElement(By.linkText(t)).click();
			if(driver.getTitle().contains(expTitle)) {
				System.out.println(t+" Link is Broken --"+driver.getTitle());
			}else {
				System.out.println(t+" Link is Working --"+driver.getTitle());
			}
			driver.navigate().back();
		}
		driver.close();
	}

}
