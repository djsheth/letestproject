package rameshmain;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CookiesDemoClass {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.linkedin.com/");
		Set<Cookie>cks = driver.manage().getCookies();
		Iterator<Cookie>ck = cks.iterator();
		while(ck.hasNext()) {
			Cookie c =ck.next();
			System.out.println(c.getDomain());
			System.out.println(c.getName());
			System.out.println(c.getExpiry());
		}
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		Set<Cookie>cks1 = driver.manage().getCookies();
		Iterator<Cookie>ck1 = cks1.iterator();
		while(ck1.hasNext()) {
			Cookie c1 =ck1.next();
			System.out.println(c1.getDomain());
			System.out.println(c1.getName());
			System.out.println(c1.getExpiry());
		}
		driver.close();
	}

}
