package rameshmain;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AlertDemoRediffSite {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.rediff.com/");
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.name("proceed")).click();
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		System.out.println("Alert Message is ----> "+msg);
		alert.accept();
		
		driver.close();
	}

}
