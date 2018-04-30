package practice;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Naukripopup {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");
		String pid = driver.getWindowHandle();
		Set<String>handles=driver.getWindowHandles();
		for(String e:handles) {
			if(!pid.equalsIgnoreCase(e)) {
				driver.switchTo().window(e);
				System.out.println(driver.getTitle());
				driver.close();
				Thread.sleep(3000);
				driver.switchTo().window(pid);
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
	}

}
