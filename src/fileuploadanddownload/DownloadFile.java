package fileuploadanddownload;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadFile {

	public static void main(String[] args) throws InterruptedException {


		ChromeOptions options = new ChromeOptions();
		Map<String,Object> prefs = new HashMap<String,Object>();
		prefs.put("profile.default_content_settings.popups", true);
		prefs.put("download.default_directory", "C:\\seleniumdriver");
		options.setExperimentalOption("prefs", prefs);
		System.setProperty("webdriver.chrome.driver","C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		//WebDriver driver = new ChromeDriver();

		driver.get("http://the-internet.herokuapp.com/download");
		driver.findElement(By.linkText("some-file.txt")).click();
		Thread.sleep(3000);
		driver.quit();
	}

}
