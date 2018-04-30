package rameshmain;

import java.io.File;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class ScreenShotDemo {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']")).sendKeys("Mobiles");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='s-result-count']")));
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//copy the screenshot file to project location
		FileUtils.copyFile(screenshotFile,new File(System.getProperty("user.dir")+"\\src"+"myscreenshot1"+".png"));
		Thread.sleep(3000);
		driver.close();
	}

}
