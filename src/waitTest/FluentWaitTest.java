package waitTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitTest {

	public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "D:\\Maria\\Selenium\\chromedriver_win32\\chromedriver.exe" );

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://seleniumpractise.blogspot.co.uk/2016/08/how-to-use-explicit-wait-in-selenium.html");
		
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
		public WebElement apply(WebDriver driver) {
			
			WebElement ele = driver.findElement(By.id("demo"));
			String sValue = driver.findElement(By.id("demo")).getAttribute("innerHTML");
			
			if(sValue.equalsIgnoreCase("WebDriver")) {
				System.out.println("The element found = "+sValue);
				return ele;
			} else {
				System.out.println("The element found = "+sValue);
				return null;
			}
			 
		     }
		});
		
		System.out.println("The elemnetis displayed ? "+element.isDisplayed());

	}

}
