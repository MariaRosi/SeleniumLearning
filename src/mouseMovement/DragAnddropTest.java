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

public class DragAnddropTest {
	
	WebDriver driver;
	
	
  @Test
  public void mouseOverTest() throws Exception {
	  
	  driver.switchTo().frame(0);
	  
	  WebElement ele_Source = driver.findElement(By.id("draggable"));
	  WebElement ele_Target = driver.findElement(By.id("droppable"));
	  
	  Actions action = new Actions(driver);
	  
	  
	  //action.clickAndHold(ele_Source).moveToElement(ele_Target).release().build().perform();  
	  
	  action.dragAndDrop(ele_Source, ele_Target).build().perform();

	  
  }
  
  
  @BeforeMethod
  public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\\\Maria\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://jqueryui.com/droppable/");
  }

  @AfterMethod
  public void closeBrowser() {
	 // driver.quit();
  }

}
