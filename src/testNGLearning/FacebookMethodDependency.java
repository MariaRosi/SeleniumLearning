package testNGLearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class FacebookMethodDependency {

	WebDriver driver;
	
	@Test
	public void openFacebook() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Maria\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/login/");
	}

	@Test(dependsOnMethods={"openFacebook"})
	public void loginFacebook() {
		
		driver.findElement(By.id("email")).sendKeys("maria123");
		driver.findElement(By.id("pass")).sendKeys("pass123");
		driver.findElement(By.id("loginbutton")).click();
	}
	
	@AfterTest
	public void closeFacebook() {
		driver.close();
	}
	
}
