package testNGLearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import library.Utility;

public class DataProviderTestFromExcel {

	WebDriver driver;
	String filename = "D:\\Maria\\Selenium\\Workspace\\SeleniumLearning\\File\\TestData.xlsx";
	String sheetname = "login";

	@BeforeMethod
	public void openBrowser() {
		System.out.println("******** openBrowser ********* START");
		System.setProperty("webdriver.chrome.driver", "D:\\Maria\\Selenium\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com");
		System.out.println("******** openBrowser ********* END");
	}

	@Test(dataProvider = "passTestData")
	public void selectDate(String username, String password) throws Exception {
		System.out.println("******** selectDate ********* START");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);

		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("******** selectDate ********* END");
	}

	@DataProvider
	public Object[][] passTestData() {
		System.out.println("******** passTestData ********* START");
		Object data[][] = Utility.getTestDataFromExcel(filename, sheetname);
		System.out.println("******** passTestData ********* END");
		return data;
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
