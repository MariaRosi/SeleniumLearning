package dropdownSelectTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FacebookDropDownSelectAllMonths {

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
		
		List<WebElement> list_Month = select_Month.getOptions();
		
		int iMonth_Count = list_Month.size();
		
		System.out.println("The total month count is = "+iMonth_Count);
		
		for (WebElement ele:list_Month) {
			System.out.println("The month is = "+ele.getText());
			
		}
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
