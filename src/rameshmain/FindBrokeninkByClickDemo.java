package rameshmain;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindBrokeninkByClickDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/");
		//driver.get("https://www.linkedin.com/");
		//WebDriverWait wait = new WebDriverWait(driver,30);
		String expTitle = "Not Found";
		List<WebElement>linksList=driver.findElements(By.tagName("a"));
		String[] linkNames = new String[linksList.size()];
		int i = 0;
		for(WebElement l:linksList) {
			linkNames[i] = l.getText();
			i++;
		}
			for(String t:linkNames) {
				driver.findElement(By.linkText(t)).click();
				Thread.sleep(2000);
				if (driver.getTitle().contains(expTitle)) {
					System.out.println(t+" --Link is Broken  --"+driver.getTitle());
				}else {
					System.out.println(t+" --Link is Working  --"+driver.getTitle());

				}
				driver.navigate().back();
			}
			driver.close();
		}
		
	}


