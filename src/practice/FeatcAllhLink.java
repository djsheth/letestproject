package practice;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FeatcAllhLink {
		public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.rediff.com/");
		/*List<WebElement>links = driver.findElements(By.tagName("img"));
		int count = links.size();
		System.out.println(count);
				for(WebElement e:links) {
					validatelink(e.getAttribute("src"));
		}*/
				File sc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(sc, new File(System.getProperty("user.dir")+"\\src"+"scshot"+".png"));
				Thread.sleep(3000);
		driver.close();
	}
	public static void validatelink(String url) throws IOException {
		URL ul = new URL(url);
		HttpURLConnection hc = (HttpURLConnection) ul.openConnection();
		hc.connect();
		int s = hc.getResponseCode();
		String t = hc.getResponseMessage();
		System.out.println(url+" --->"+s+" --->"+t);
		hc.disconnect();
	}

}
