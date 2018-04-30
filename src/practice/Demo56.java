package practice;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo56 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.get("http://www.rediff.com/");
	driver.findElement(By.linkText("Sign in")).click();
	driver.findElement(By.id("login1")).click();;
	//driver.findElement(By.id("login1")).sendKeys("sfsf");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("document.getElementById('login1').value='jkhjh'");
	}

}
