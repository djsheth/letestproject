package javafirst;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class FindBrokenLinksBasedStatusCode {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/");
		List<WebElement>linklist=driver.findElements(By.tagName("a"));
		for(WebElement e:linklist) {
			validateLink(e.getAttribute("href"));
		}
		driver.close();
		
	}
	public static void validateLink(String url) throws IOException {
		URL ul = new URL(url);
		HttpURLConnection hc = (HttpURLConnection) ul.openConnection();
		hc.connect();
		int rescode=hc.getResponseCode();
		String msg = hc.getResponseMessage();
		System.out.println(url+" -->"+rescode+"--->"+msg);
		hc.disconnect();
		
	}

}

