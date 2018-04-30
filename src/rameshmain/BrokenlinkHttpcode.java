package rameshmain;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrokenlinkHttpcode {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get("http://newtours.demoaut.com/");
		driver.get("https://www.linkedin.com/");
		List<WebElement>linklist=driver.findElements(By.tagName("a"));
		for(WebElement e:linklist) {
			System.out.println(e.getText());
			verifyBrokenLinkByHttpCode(e.getAttribute("href"));
		}
		driver.close();
		
		
	}
	public static void verifyBrokenLinkByHttpCode(String url) throws IOException {
		
			
		try {
			
			URL ul = new URL(url);
			HttpURLConnection hc = (HttpURLConnection) ul.openConnection();
			hc.connect();
			int rescode = hc.getResponseCode();
			String msg = hc.getResponseMessage();
			
			System.out.println(url+"-->"+rescode+"-->"+msg);
			hc.disconnect();
		} catch (SocketTimeoutException e) {
System.out.println(url+"--->This link is not work");
e.printStackTrace();
		}
		
	}

}
