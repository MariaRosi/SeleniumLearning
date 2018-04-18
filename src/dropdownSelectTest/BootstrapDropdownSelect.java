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

import junit.framework.Assert;

public class BootstrapDropdownSelect {
	WebDriver driver;

	@BeforeMethod
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver", "D:\\Maria\\Selenium\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://seleniumpractise.blogspot.co.uk/2016/08/bootstrap-dropdown-example-for-selenium.html");
	}

	@Test
	public void monthSelect() throws Exception {
		
		String sTutorialsDDValue =  "";

		driver.findElement(By.id("menu1")).click();
		
		Thread.sleep(2000);


		List<WebElement> list_Tutorials_Dropdown = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li/a"));

		for (WebElement element : list_Tutorials_Dropdown) {
			
			sTutorialsDDValue = element.getAttribute("innerHTML");

			System.out.println("After selected month = " + sTutorialsDDValue);
			
			if(sTutorialsDDValue.equals("JavaScript")) {
				
				element.click();
				
			}

		}

	}

	@AfterMethod
	public void closeBrowser() {
		//driver.quit();
	}

}
