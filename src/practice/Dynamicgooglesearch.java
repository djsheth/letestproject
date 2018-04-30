package practice;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamicgooglesearch {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Users//sheth//Downloads//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	String textToBeSearched = "seleniumhq";

			driver.manage().window().maximize();

			driver.get("https://www.google.com");

			// Entering the text in google search box...
			driver.findElement(By.id("lst-ib")).sendKeys("seleni");
			// waiting for the suggestions list
			Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// locating the list
			WebElement list = driver.findElement(By.xpath("//ul[@class='sbsb_b']"));
			// Getting all the suggestions listed in list
			List<WebElement> suggestions = list.findElements(By.tagName("li"));
			String[]sname=new String[suggestions.size()];
			for(WebElement e:suggestions) {
				System.out.println(e.getText());
				
			}
			System.out.println(suggestions.size());

			Iterator<WebElement> ite = suggestions.iterator();

			while (ite.hasNext()) {
				WebElement suggestion = ite.next();
				if (suggestion.getText().toLowerCase().trim().equals(textToBeSearched)) {
					suggestion.click();
					break;
				}
			}
			driver.close();
		}
	}


