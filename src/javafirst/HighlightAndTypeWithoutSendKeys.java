package javafirst;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HighlightAndTypeWithoutSendKeys {
	public static WebDriver driver;
	public static void highLightElement(WebDriver driver, WebElement Element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background: yellow, border: solid 5px red')",Element);
		Thread.sleep(5000);
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", Element);
		
	}

	public static void setAttribute(WebElement Element, String attributeName, String value) {
		WrapsDriver wrappedElement = (WrapsDriver) Element;
		JavascriptExecutor js = (JavascriptExecutor) wrappedElement.getWrappedDriver();
		js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])",Element,attributeName,value);
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		WebElement Searc_editbox = driver.findElement(By.id("gs_htif0"));
		WebElement About_link = driver.findElement(By.linkText("About"));
		highLightElement(driver,About_link);
		setAttribute(Searc_editbox,"value","Selenium");
		Thread.sleep(3000);
		driver.close();
		
	}

}
