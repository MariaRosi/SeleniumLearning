package readPropertiesFile;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReadPropertyFile {
	WebDriver driver;

	FileInputStream fis = null;
	Properties prop = null;

	String sBrowser = "";
	String sUrl = "";
	String sFirstname = "";
	String sSurname = "";
	String sEmail = "";
	String sPassword = "";
	String sBirthday_day = "";
	String sBirthday_month = "";
	String sBirthday_year = "";
	String sSex = "";

	String sFirstname_name = "";
	String sSurname_name = "";
	String sEmail_name = "";
	String sEmail_confirm_name = "";
	String sPassword_name = "";
	String sBirthday_day_name = "";
	String sBirthday_month_name = "";
	String sBirthday_year_name = "";
	String sSex_xpath = "";
	String sCreate_acount_button_name = "";

	String sSex_radio = "";

	@Test
	public void readPropertyFile() throws Exception {
		driver.findElement(By.name(sFirstname_name)).sendKeys(sFirstname);
		driver.findElement(By.name(sSurname_name)).sendKeys(sSurname);
		driver.findElement(By.name(sEmail_name)).sendKeys(sEmail);

		Thread.sleep(2000);

		driver.findElement(By.name(sEmail_confirm_name)).sendKeys(sEmail);
		driver.findElement(By.name(sPassword_name)).sendKeys(sPassword);

		Select sel_day = new Select(driver.findElement(By.name(sBirthday_day_name)));
		sel_day.selectByVisibleText(sBirthday_day);

		Select sel_month = new Select(driver.findElement(By.name(sBirthday_month_name)));
		sel_month.selectByVisibleText(sBirthday_month);

		Select sel_year = new Select(driver.findElement(By.name(sBirthday_year_name)));
		sel_year.selectByVisibleText(sBirthday_year);

		
		List<WebElement> radio_sex = driver.findElements(By.xpath(sSex_xpath));

		for (WebElement ele : radio_sex) {
			sSex_radio = ele.getText();
			System.out.println(sSex_radio);

			if (sSex_radio.equals(sSex)) {
				ele.click();
				break;
			}
		}
		
		driver.findElement(By.name(sCreate_acount_button_name)).click();
	}
	
	

	@BeforeMethod
	public void openBrowser() {
		// read the config.properties file
		try {
			FileInputStream fis = new FileInputStream(
					"D:\\Maria\\Selenium\\Workspace\\SeleniumLearning\\config\\config.properties");
			Properties prop = new Properties();
			prop.load(fis);

			sBrowser = prop.getProperty("browser");
			sUrl = prop.getProperty("url");
			sFirstname = prop.getProperty("firstname");
			sSurname = prop.getProperty("surname");
			sEmail = prop.getProperty("email");
			sPassword = prop.getProperty("password");
			sBirthday_day = prop.getProperty("birthday_day");
			sBirthday_month = prop.getProperty("birthday_month");
			sBirthday_year = prop.getProperty("birthday_year");
			sSex = prop.getProperty("sex");

			sFirstname_name = prop.getProperty("firstname_name");
			sSurname_name = prop.getProperty("surname_name");
			sEmail_name = prop.getProperty("email_name");
			sEmail_confirm_name = prop.getProperty("email_confirm_name");
			sPassword_name = prop.getProperty("password_name");
			sBirthday_day_name = prop.getProperty("birthday_day_name");
			sBirthday_month_name = prop.getProperty("birthday_month_name");
			sBirthday_year_name = prop.getProperty("birthday_year_name");
			sSex_xpath = prop.getProperty("sex_xpath");
			sCreate_acount_button_name = prop.getProperty("create_acount_button_name");

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (sBrowser.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "D:\\Maria\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (sBrowser.equals("FF")) {

			System.setProperty("webdriver.gecko.driver", "D:\\Maria\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(sUrl);

	}

	@AfterMethod
	public void closeBrowser() {
		// driver.quit();
	}

}
