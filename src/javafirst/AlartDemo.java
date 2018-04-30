package javafirst;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AlartDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://only-testing-blog.blogspot.in/2014/01/textbox.html");
		driver.findElement(By.xpath(".//*[@id='post-body-4292417847084983089']/div[1]/input")).click();
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='post-body-4292417847084983089']/div[1]/button[2]")).click();
		Alert prmpt = driver.switchTo().alert();
		prmpt.sendKeys("Selenium");
		prmpt.accept();
		Thread.sleep(3000);

		driver.findElement(By.xpath(".//*[@id='post-body-4292417847084983089']/div[1]/button[2]")).click();
		Alert prmpt1 = driver.switchTo().alert();
		prmpt1.dismiss();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='post-body-4292417847084983089']/div[1]/button[1]")).click();
		Alert ale = driver.switchTo().alert();
		System.out.println(ale.getText());
		ale.accept();
	driver.close();
	}

}
