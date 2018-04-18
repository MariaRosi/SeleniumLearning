package cookeiConcept;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieConcept {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		//get cookies
		System.out.println(driver.manage().getCookieNamed("cookieName").getValue());
		
		Set<Cookie> cookies = driver.manage().getCookies();
		
		for(Cookie eachCookie : cookies) {
			
			System.out.println(eachCookie.getName());
			System.out.println(eachCookie.getValue());
		}
		
		//add cookies
		Cookie cookie = new Cookie("name","value");
		driver.manage().addCookie(cookie);
		
		//delete cookies
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookie(cookie);
		driver.manage().deleteCookieNamed("cookieName");

	}

}
