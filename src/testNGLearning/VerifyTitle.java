package testNGLearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class VerifyTitle {
	
	WebDriver driver;
	
	@Test
	public void checkTitle() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Maria\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://learn-automation.com/");
		
		String sAcualTitle = driver.getTitle();
		
		//String sExpectedTitle = "Selenium WebDriver tutorial - Selenium WebDriver tutorial Step by Step";
		String sExpectedTitle = "Selenium WebDriver tutorial - Selenium WebDriver tutorial";
		
		System.out.println("Verification started");
		//Assert.assertEquals(sAcualTitle, sExpectedTitle);
		Assert.assertTrue(sAcualTitle.contains("Selenium WebDriver tutorial - Selenium WebDriver tutorial"));
		System.out.println("Verification completed");
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
