package popupHandel;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserPopupHandle {

	WebDriver driver;

	@Test
	public void browserPopupTest() throws Exception {
		driver.findElement(By.linkText("Good PopUp #2")).click();

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> itr = windows.iterator();

		String sParentWindow = (String) itr.next();
		String sChildWindow = (String) itr.next();

		driver.switchTo().window(sChildWindow);

		Thread.sleep(2000);

		System.out.println("The title of the child window = " + driver.getTitle());
		
		driver.close();

		driver.switchTo().window(sParentWindow);

		Thread.sleep(2000);

		System.out.println("The title of the parent window = " + driver.getTitle());

	}

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\\\Maria\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://www.popuptest.com/goodpopups.html");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
