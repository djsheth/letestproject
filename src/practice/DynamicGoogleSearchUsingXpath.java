package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicGoogleSearchUsingXpath {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
			String textToBeSearched = "selenium webdriver";

			driver.manage().window().maximize();

			driver.get("https://www.google.com");

			// Entering the text in google search box...
			driver.findElement(By.id("lst-ib")).sendKeys("seleni");
			// waiting for the suggestions list
			Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// locating the list
			WebElement list = driver.findElement(By.xpath("//ul[@class='sbsb_b']"));
			List<WebElement>sugname = list.findElements(By.tagName("li"));
			for(int i=0; i<sugname.size(); i++) {
				System.out.println(sugname.get(i).getText());
				if(sugname.get(i).getText().equalsIgnoreCase(textToBeSearched)) {
					sugname.get(i).click();
					break;
				}
			}
			driver.close();

	}

}
