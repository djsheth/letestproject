package rameshmain;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkedinValidateSectionLinkByClick {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String exptitle = "Not Found";
		driver.get("https://www.linkedin.com/");
		WebElement linksection = driver.findElement(By.xpath(".//*[@id='layout-main']/div/div[3]/div[2]/div[1]/ul"));
		List<WebElement>links = linksection.findElements(By.tagName("a"));
		String[] linkname = new String[links.size()];
		int i = 0;
		for(WebElement e:links) {
			linkname[i] = e.getText();
			i++;
		}
		for(int p = 0; p<links.size(); p++) {
			try {
				driver.findElement(By.linkText(linkname[p])).click();
					Thread.sleep(3000);
					if(driver.getTitle().contains(exptitle)) {
						System.out.println(linkname[p]+" -->Link is Broken---> "+driver.getTitle());
					}else {
						System.out.println(linkname[p]+" -->Link is working Perfect--->"+driver.getTitle());
					}
			} catch (Exception e1) {
				System.out.println("Exception");
				e1.printStackTrace();
			}
		
			driver.navigate().back();
			
		}
		/*for(String s:linkname) {
			try {
				driver.findElement(By.linkText(s)).click();
					Thread.sleep(3000);
					if(driver.getTitle().contains(exptitle)) {
						System.out.println(s+" -->Link is Broken---> "+driver.getTitle());
					}else {
						System.out.println(s+" -->Link is working Perfect--->"+driver.getTitle());
					}
			} catch (Exception e1) {
				System.out.println("Exception");
				e1.printStackTrace();
			}
		
			driver.navigate().back();
		}
*/		driver.close();
}

}
