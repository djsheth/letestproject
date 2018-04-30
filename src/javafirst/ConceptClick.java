package javafirst;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConceptClick {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://conceptlogic.com/jcart/");
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		List<WebElement>btlist=driver.findElements(By.xpath(".//*[@id='content']/form/fieldset/input[6]"));
		for(int i = 1; i<btlist.size();i++) {
			WebElement ltlocator = driver.findElement(By.xpath(".//*[@id='content']/form["+i+"]/fieldset/input[6]"));
			wait.until(ExpectedConditions.elementToBeClickable(ltlocator));
			ltlocator.click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("jcart-tooltip")));
			Thread.sleep(20000);
		}
		String txt = driver.findElement(By.xpath(".//*[@id='jcart']/form/fieldset/table/thead/tr/th")).getText();
		String[] str= txt.split(" ");
		System.out.println(str[2]);
		String[] st = str[2].split("\\(");
		System.out.println(st[1]);
		//System.out.println(str[2].charAt(1));
		driver.close();
	}

}
