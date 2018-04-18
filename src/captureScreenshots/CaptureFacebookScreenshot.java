package captureScreenshots;

import library.Utility;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CaptureFacebookScreenshot {
	
	WebDriver driver;
	
	@Test
	public void testCaptureScreenshot() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "D:\\Maria\\Selenium\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/login/");
		
		Utility.captureScreenshots(driver,"LoginPage");
		
		driver.findElement(By.id("email")).sendKeys("maria.rosi2008@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("abcd");
		driver.findElement(By.id("loginbutton")).click();
		
		Utility.captureScreenshots(driver,"ResultPage");
		
		driver.quit();
			
	}

}
