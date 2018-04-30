package javafirst;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class cookietest {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://conceptlogic.com/jcart/");
		Set<Cookie>CookieSet=driver.manage().getCookies();
		for(Cookie c:CookieSet) {
			System.out.println("Cookie name: "+c.getName()+"---------value:"+c.getValue());
			System.out.println("Cookie expiray date"+c.getExpiry());
			System.out.println("Cookie domain:"+c.getDomain()+" path is"+c.getPath());
		}
		Cookie ck=new Cookie("sampleck","83242hg2h3g2j3h");
		System.out.println("newly created cookie name"+ck.getName()+"Value--->"+ck.getValue());
		driver.manage().deleteCookieNamed("sampleck");
		System.out.println("newly created cookie name"+ck.getName()+"Value--->"+ck.getValue());
		driver.manage().deleteAllCookies();
		System.out.println(driver.manage().getCookies());
		driver.close();
	}

}
