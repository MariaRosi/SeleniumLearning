package popupHandel;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FileUploadPopup {
	
	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\\\Maria\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://html.com/input-type-file/");
	}

	@Test
	public void handleAlertPopup() throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.id("fileupload")).sendKeys("C:\\Users\\Imtiaz\\Test.txt");
				
	}
	
	@AfterMethod
	public void closeBrowser() {
		//driver.quit();
	}
}
