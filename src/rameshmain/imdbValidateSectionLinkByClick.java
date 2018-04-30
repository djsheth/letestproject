package rameshmain;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class imdbValidateSectionLinkByClick {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.imdb.com/chart/top");
		WebDriverWait wait = new WebDriverWait(driver,30);
		for(int p = 1; p<=25; p++) {
			
				WebElement link = driver.findElement(By.xpath(".//*[@id='main']/div/span/div/div/div[3]/table/tbody/tr["+p+"]/td[2]/a"));
				String s = link.getText();
				String t = link.getAttribute("href");
				link.click();	
				Thread.sleep(5000);
				System.out.println(driver.getTitle());
				if(driver.getTitle().contains(s)) {
					System.out.println("Link is ok");
				}else {
					System.out.println("Link is not ok");
				}
				//wait.until(ExpectedConditions.titleContains(s));
					System.out.println(s+"----"+t);
			
				driver.navigate().back();
			
		}
		
		
		driver.close();
		
		
				}

}


