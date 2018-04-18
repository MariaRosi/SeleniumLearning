package mouseMovement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollIntoView {

	static WebDriver driver;
	static String schromeDriver = "D:\\Maria\\Selenium\\chromedriver_win32\\chromedriver.exe";
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", schromeDriver);

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
		
		WebElement element = driver.findElement(By.xpath("//div[@id='mCSB_3_container']//p[contains(text(),'Excepteur sint')]"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		System.out.println(element.getText());

	}

}
