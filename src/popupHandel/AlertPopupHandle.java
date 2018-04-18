package popupHandel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class AlertPopupHandle {
	
	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\\\Maria\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
	}

	@Test
	public void handleAlertPopup() throws Exception {
		driver.findElement(By.id("Register")).click();
		
		Thread.sleep(3000);
		
		Alert alert_CreateAccountButton = driver.switchTo().alert();
		
		String sAlert_Msg = alert_CreateAccountButton.getText();
		
		System.out.println("The alert message contains = "+sAlert_Msg);
		
		Assert.assertTrue(sAlert_Msg.contains("Your full name cannot be blank."));
		
		alert_CreateAccountButton.accept();
				
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
