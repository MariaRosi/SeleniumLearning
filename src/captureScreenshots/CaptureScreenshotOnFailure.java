package captureScreenshots;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class CaptureScreenshotOnFailure {

	WebDriver driver;
	String schromeDriver = "D:\\Maria\\Selenium\\chromedriver_win32\\chromedriver.exe";
	WebDriverWait wait;
	String sScreenShotfilename = null;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", schromeDriver );
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");

	}
	
	
	@Test
	public void testGoogleCalculator() {
	
		driver.findElement(By.id("lst-ib")).sendKeys("2+2");
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
		
		wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='resultStats']")));
			
		String sResult = driver.findElement(By.xpath("//div[@class='cwtlotc']//span")).getText();
		
		Assert.assertEquals(5, sResult);
		
	}
	
	@AfterMethod
	public void takesFailureScreenshot(ITestResult testResult) throws IOException {
		if(testResult.getStatus() == ITestResult.FAILURE) {
			System.out.println("Status = "+testResult.getStatus());
			sScreenShotfilename = testResult.getName();
			//System.out.println("Name = "+testResult.getName());
			//System.out.println("Parameters = "+testResult.getParameters());
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("./Screenshots/" + sScreenShotfilename + ".png"));
		}
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
