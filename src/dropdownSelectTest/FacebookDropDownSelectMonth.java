package dropdownSelectTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FacebookDropDownSelectMonth {

	WebDriver driver;

	@BeforeMethod
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver", "D:\\Maria\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/r.php?locale=en_GB");
	}
	
	@Test
	public void monthSelect() throws Exception {
		WebElement ele_Month = driver.findElement(By.id("month"));
		Select select_Month = new Select(ele_Month);
		
		//This will select May
		select_Month.selectByIndex(5);
		
		Thread.sleep(2000);
		
		//This will select January
		select_Month.selectByValue("1");
		
		Thread.sleep(2000);
		
		//This will select Oct
		select_Month.selectByVisibleText("Oct");
		
		Thread.sleep(2000);
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
