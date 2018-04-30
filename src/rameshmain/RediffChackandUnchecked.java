package rameshmain;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RediffChackandUnchecked {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.rediff.com/");
		driver.findElement(By.linkText("Sign in")).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.titleIs("Rediffmail"));
		WebElement checkbox = driver.findElement(By.xpath(".//*[@id='remember']"));
		if(checkbox.isSelected()) {
			checkbox.click();
		}else {
			System.out.println("CheckBox is unchecked");
		}
		Thread.sleep(3000);
		if(!checkbox.isSelected()) {
			checkbox.click();
		}else {
			System.out.println("Check box is checked");
		}
		Thread.sleep(3000);
		driver.close();
		
	}

}
