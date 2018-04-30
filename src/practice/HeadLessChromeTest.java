package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessChromeTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("window-size-1400,800");
		option.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(option);
			String textToBeSearched = "seleniumhq";
			driver.get("https://www.google.com");
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			driver.close();

	}

}
