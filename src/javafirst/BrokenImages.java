package javafirst;
import static javafirst.FindBrokenLinksBasedStatusCode.validateLink;
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

public class BrokenImages {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://rediff.com/");
		List<WebElement>imageslist=driver.findElements(By.tagName("img"));
		for(WebElement e:imageslist) {
			validateLink(e.getAttribute("src"));
		}
		driver.close();
		
	}
	

}
