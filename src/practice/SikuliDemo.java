package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliDemo {

	public static void main(String[] args) throws FindFailed {
		System.setProperty("webdriver.chrome.driver","C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
			String textToBeSearched = "seleniumhq";

			driver.manage().window().maximize();
			
			System.out.println("Hello");

			driver.get("https://www.google.com/");
			
			/*Screen s = new Screen();
			Pattern pauseImg = new Pattern("Capture4.png");
			s.wait(pauseImg, 2000);
			s.click();
*/	}

}
