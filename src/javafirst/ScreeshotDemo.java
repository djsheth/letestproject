package javafirst;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class ScreeshotDemo {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobiles");
		driver.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div/input")).sendKeys(Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("s-result-count")));
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		
		jsx.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(3000);
		jsx.executeScript("window.scrollBy(0,-700)", "");
		Thread.sleep(3000);
		File srceenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srceenshotFile,new File(System.getProperty("user.dir")+"\\src"+"myscreenshot"+".png"));
		driver.close();

	}

}
