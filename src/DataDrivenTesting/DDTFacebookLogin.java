package DataDrivenTesting;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTFacebookLogin {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Maria\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");

	}

	@Test(dataProvider="FBLoginData")
	public void doLogin(String sUserName, String sPassword) {
		driver.findElement(By.id("email")).sendKeys(sUserName);
		driver.findElement(By.id("pass")).sendKeys(sPassword);
		driver.findElement(By.id("loginbutton")).click();
		
		System.out.println(driver.getTitle());
		
		Assert.assertTrue(driver.getTitle().contains("Facebook"), "Login is unsuccessfull for user "+sUserName+" - invalid login credential");
		
		System.out.println("Login successfull for user "+sUserName);

	}
	

    @DataProvider(name = "FBLoginData")
	public Object[][] passData() {

		Object[][] data = new Object[4][2];

		data[0][0] = "user1@gmail.com";
		data[0][1] = "pwd111";
		
		data[1][0] = "maria.rosi2008@gmail.com";
		data[1][1] = "Pune@2250";
		
		data[2][0] = "user3@gmail.com";
		data[2][1] = "pwd333";
		
		data[3][0] = "user4@gmail.com";
		data[3][1] = "pwd444";
		
		return data;

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
