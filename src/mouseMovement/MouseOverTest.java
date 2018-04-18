package mouseMovement;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class MouseOverTest {
	
	WebDriver driver;
	
	
  @Test
  public void mouseOverTest() throws Exception {
	  
	  WebElement ele_Addon = driver.findElement(By.id("highlight-addons"));
	  
	  Actions action = new Actions(driver);
	  action.moveToElement(ele_Addon).build().perform();
	  
	  Thread.sleep(2000);
	  
	  driver.findElement(By.linkText("Hot Meals")).click();
	  
  }
  
  
  @BeforeMethod
  public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\\\Maria\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.spicejet.com/");
  }

  @AfterMethod
  public void closeBrowser() {
	 // driver.quit();
  }

}
