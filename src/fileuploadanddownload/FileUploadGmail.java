package fileuploadanddownload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadGmail {

	public static void main(String[] args) throws AWTException {
		//System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
				//WebDriver driver = new EdgeDriver();
				
				System.setProperty("webdriver.chrome.driver","C:\\seleniumdriver\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Robot robot = new Robot();
				driver.get("https://www.gmail.com/");
				driver.findElement(By.id("identifierId")).sendKeys("shethdj79@gmail.com");
				driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
				driver.findElement(By.name("password")).sendKeys("Dhaval22279#");
				driver.findElement(By.name("password")).sendKeys(Keys.ENTER);

				driver.findElement(By.xpath(".//*[@id=':gg']/div/div")).click();
				//rameshn3@gmail.com
				
				driver.findElement(By.name("to")).sendKeys("rameshn3@gmail.com");
				driver.findElement(By.name("subjectbox")).sendKeys("this mail is send by automated script with attached file");

				driver.findElement(By.xpath("//*[@id=\":mm\"]")).click();
				robot.setAutoDelay(2000);
				StringSelection stselection = new StringSelection("C:\\Users\\sheth\\OneDrive\\Desktop\\Fileupload.odt");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stselection, null);
				robot.setAutoDelay(3000);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_V);
				robot.setAutoDelay(3000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//*[@id=\":m1\"]")).sendKeys("Dear Ramesh,");
				driver.findElement(By.xpath("//*[@id=\":m1\"]")).sendKeys(Keys.ENTER);
driver.findElement(By.xpath("//*[@id=\":m1\"]")).sendKeys("please find here with enclosed document which contains automated script for your given assignment of sending mail through automated script"); 
						

				driver.findElement(By.xpath("//*[@id=\":kp\"]")).click();
				driver.findElement(By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[5]/div[1]/a/span")).click();
				driver.findElement(By.xpath(".//*[@id='gb_71']")).click();
				Alert alert = driver.switchTo().alert();
				alert.accept();
				driver.close();

				
				
				
				
				
	}

}
