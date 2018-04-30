package rameshmain;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleCaptchaInRediff {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.id("Register")));
		WebElement city_dropdown = driver.findElement(By.xpath(".//*[@id='div_city']/table/tbody/tr[1]/td[3]/select"));
		Select sel = new Select(city_dropdown);
		sel.selectByIndex(4);
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Captcha Value :");
		Thread.sleep(12000);
		String str = scan.next();
		driver.findElement(By.xpath(".//*[@id='tblcrtac']/tbody/tr[32]/td[3]/input")).sendKeys(str);
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='Register']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.close();
	}

}
