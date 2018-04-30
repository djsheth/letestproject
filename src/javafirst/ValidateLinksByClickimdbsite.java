package javafirst;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidateLinksByClickimdbsite {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.get("http://www.imdb.com/list/ls000632473/");
		for(int i= 1; i<=36; i++) {
		WebElement firstlink = driver.findElement(By.xpath(".//*[@id='main']/div/div[3]/div[3]/div["+i+"]/div[2]/h3/a"));
		String flink = firstlink.getText();
		String furl = firstlink.getAttribute("href");
		firstlink.click();
		wait.until(ExpectedConditions.titleContains(flink));
		//Thread.sleep(3000);
		String ftitle = driver.getTitle();
		//System.out.println("Link Name = "+flink+" URL = "+furl+" Page Title = "+ftitle);
		if(driver.getTitle().contains(flink)) {
			System.out.println(flink+" ---->is Working as expected "+"---->Page Title is ---> "+ftitle);
		}else {
			System.out.println(flink+" ---->is NOT Working as expected "+"---->Page Title is ---> "+ftitle);
		}
		driver.navigate().back();
		}
		driver.close();
			}	
	}



