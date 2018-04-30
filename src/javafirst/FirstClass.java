package javafirst;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstClass {

	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
	WebDriver driver = new EdgeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.linkedin.com/");
	//driver.findElement(By.xpath(".//*[@id='signin_info']/a[1]")).click();
	/*driver.findElement(By.linkText("Create a Rediffmail account")).click();
	driver.findElement(By.xpath("//[@id='tblcrtac']//input")).sendKeys("Dhaval");
	driver.navigate().back();*/
	//driver.findElement(By.xpath(".//*[@id='srchword']")).sendKeys("dhvaskkkdd");
	/*System.out.println(driver.findElement(By.xpath(".//*[@id='srchinputcopy']")).isDisplayed());
	driver.findElement(By.xpath(".//*[@id='queryTop']/div/input[6]")).click();
	Alert alert = driver.switchTo().alert();
	System.out.println(alert.getText());
	alert.accept();
	*/
	driver.findElement(By.xpath(".//*[@id='login-email']")).sendKeys("dfgvfffd");
	//driver.findElement(By.xpath(".//*[@id='login1']")).sendKeys("fgfddd");
	Thread.sleep(3000);
	driver.close();
	
}
	}


