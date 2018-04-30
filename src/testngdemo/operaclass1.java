package testngdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class operaclass1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.opera.driver", "‪‪‪‪C:\\Users\\sheth\\Downloads\\operadriver.exe");
		
		
		WebDriver driver = new OperaDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/");
		
	}

}
