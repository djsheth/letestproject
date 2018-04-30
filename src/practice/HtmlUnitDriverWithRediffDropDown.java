package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class HtmlUnitDriverWithRediffDropDown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new HtmlUnitDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("http://www.rediff.com/");
	driver.findElement(By.linkText("Create a Rediffmail account")).click();
	WebElement monthdropdown = driver.findElement(By.xpath("//select[contains(@name,'DOB_Month')]"));
	Select sel = new Select(monthdropdown);
	sel.selectByIndex(3);
	List<WebElement>dpmonthlist = sel.getOptions();
	String [] dpmonthlistname = new String [dpmonthlist.size()];
	int i = 0;
	for( WebElement e:dpmonthlist){
		dpmonthlistname[i] = e.getText();
		System.out.println(dpmonthlistname[i]);
		i++;
	}
	driver.close();
	
	}

}
