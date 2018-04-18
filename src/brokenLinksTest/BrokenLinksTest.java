package brokenLinksTest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksTest {

	static WebDriver driver;
	static String schromeDriver = "D:\\Maria\\Selenium\\chromedriver_win32\\chromedriver.exe";

	public static void main(String[] args) {
		String sEachUrl = null;
		System.setProperty("webdriver.chrome.driver", schromeDriver);

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");

		List<WebElement> list_Links = driver.findElements(By.tagName("a"));

		for (WebElement each_Link : list_Links) {

			try {
				sEachUrl = each_Link.getAttribute("href");
				
				//System.out.println(sEachUrl);
				
				verifyBrokenLinks(sEachUrl);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private static void verifyBrokenLinks(String each_href) throws Exception {

		URL eachURL = new URL(each_href);
		HttpURLConnection httpUrlConnection = (HttpURLConnection)eachURL.openConnection();
		httpUrlConnection.setConnectTimeout(5000);
		httpUrlConnection.connect();
		
		if(httpUrlConnection.getResponseCode() == 200) {
			System.out.println(each_href +" ==> "+ httpUrlConnection.getResponseMessage());
		} else if (httpUrlConnection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
			System.out.println(each_href +" ==> "+ httpUrlConnection.getResponseMessage() +" ==> " + HttpURLConnection.HTTP_NOT_FOUND);
		} else {
			System.out.println(each_href +" ==> "+ httpUrlConnection.getResponseMessage() +" ==> " + HttpURLConnection.HTTP_NOT_FOUND);
		}
	}

}
