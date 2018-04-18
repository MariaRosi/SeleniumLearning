package mouseMovement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollTest {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeTest
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Maria\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
	
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

	}

	
	@Test
	public void TestScroll() {
		
		driver.get("http://www.flipkart.com");
		
		//print the title
		System.out.println("The title of the page = "+driver.getTitle());
		
		
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		
		driver.findElement(By.xpath("//input[@class='LM6RPg']")).sendKeys("budha");
		
		driver.findElement(By.xpath("//button[@class='vh79eN']")).submit();
		
		System.out.println("The title of the page = "+driver.getTitle());
		
		wait = new WebDriverWait(driver,5);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='KG9X1F']"))));
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		
		js.executeScript("scrollBy(0,1000)");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='_1JKxvj _31rYcN']//span//span")));
	
		String sPage = driver.findElement(By.xpath("//div[@class='_1JKxvj _31rYcN']//span//span")).getText();
	
		Assert.assertTrue(sPage.contains("Page 1"));
	
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
