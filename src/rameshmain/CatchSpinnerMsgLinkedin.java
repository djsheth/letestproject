package rameshmain;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatchSpinnerMsgLinkedin {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String exptitle = "Not Found";
		driver.get("https://www.linkedin.com/");
		driver.findElement(By.xpath(".//*[@id='layout-main']/div/div[1]/div/form/a")).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		WebElement editbox = driver.findElement(By.xpath(".//*[@id='userName-requestPasswordReset']"));
		WebElement submitbutton = driver.findElement(By.xpath(".//*[@id='btnSubmitResetRequest']"));
		
		
		if(editbox.isDisplayed()&&(!submitbutton.isEnabled())) {
			editbox.sendKeys("swdwwadq");
			submitbutton.click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
			
		}
		String globle_error = driver.findElement(By.xpath(".//*[@id='global-error']/div/p/strong")).getText();
		String User_error = driver.findElement(By.xpath(".//*[@id='userName-requestPasswordReset-error']")).getText();
		System.out.println("Globle Message--- "+globle_error);
		System.out.println("User name error--- "+User_error);
		driver.close();
		
	}

}
