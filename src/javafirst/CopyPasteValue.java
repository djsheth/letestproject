package javafirst;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CopyPasteValue {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		//WebDriver driver = new EdgeDriver();
		
		System.setProperty("webdriver.chrome.driver","C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver","C:\\seleniumdriver\\geckodriver-v0.19.1-win64 (1)\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.rediff.com/");
		driver.findElement(By.linkText("Create a Rediffmail account")).click();
		WebElement User_editbox = driver.findElement(By.xpath(".//*[@id='tblcrtac']/tbody/tr[3]/td[3]/input"));
		WebElement Email_editbox = driver.findElement(By.xpath(".//*[@id='tblcrtac']/tbody/tr[7]/td[3]/input[1]"));
		User_editbox.clear();
		User_editbox.sendKeys("Selenium");
		User_editbox.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.CONTROL,"c");
		Email_editbox.sendKeys(Keys.chord(Keys.CONTROL,"v"));
		Thread.sleep(3000);
		driver.close();
	}

}
