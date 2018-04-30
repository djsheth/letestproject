package practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class findBrokenlinkonWebPageUsingHttp {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/");
		List<WebElement>linkslist = driver.findElements(By.tagName("img"));
		List<WebElement>actlinkslist = new ArrayList<WebElement>();
		System.out.println(linkslist.size());
		for(int i = 0; i<linkslist.size(); i++) {
			if(linkslist.get(i).getAttribute("src")!=null) {
				actlinkslist.add(linkslist.get(i));
			}
		}
		
		System.out.println(actlinkslist.size());
		for(int j = 0; j<actlinkslist.size(); j++) {
			//System.out.println(actlinkslist.get(j).getAttribute("href"));
			URL ul = new URL(actlinkslist.get(j).getAttribute("src"));
			HttpURLConnection conn = (HttpURLConnection) ul.openConnection();
			conn.connect();
			System.out.println(actlinkslist.get(j).getAttribute("src")+"--->"+conn.getResponseCode()+"--->"+conn.getResponseMessage());
			conn.disconnect();
		}

	}

}
