package javafirst;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Rediffpagetitle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.linkedin.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.findElement(By.xpath(".//*[@id='layout-main']/div/div[3]/div[2]/div[1]/ul/li[2]/a")).getAttribute("href"));
		driver.findElement(By.xpath(".//*[@id='layout-main']/div/div[3]/div[2]/div[1]/ul/li[2]/a")).click();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		driver.close();

	}

}
