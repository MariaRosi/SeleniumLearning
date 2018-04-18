package handleDynamicCalender;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectDynamicCalender {

	WebDriver driver;
	String sDateSelect = "18/September/2018";

	@BeforeMethod
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver", "D:\\Maria\\Selenium\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com");
	}

	@Test
	public void selectDate() throws Exception {
		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		driver.switchTo().frame("mainpanel");

		driver.findElement(By.xpath("//a[text()='Calendar']")).click();

		Thread.sleep(3000);

		String dayArray[] = sDateSelect.split("/");
		String sDaySelect = dayArray[0];
		String sMonthSelect = dayArray[1];
		String sYearSelect = dayArray[2];

		System.out.println("Selected Day is = " + sDaySelect);
		System.out.println("Selected Month is = " + sMonthSelect);
		System.out.println("Selected Year is = " + sYearSelect);

		Select select_Year = new Select(driver.findElement(By.name("slctYear")));

		select_Year.selectByVisibleText(sYearSelect);

		Select select_Month = new Select(driver.findElement(By.name("slctMonth")));

		select_Month.selectByVisibleText(sMonthSelect);
		
		Thread.sleep(3000);

		// *[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		// *[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
		// *[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[3]/td[1]

		String sBeforeXpath = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String sAfterXPath = "]/td[";
		String sEndsWith = "]";
		String sDoubleQoute = "\"";

		String sDateValue = "";
		boolean flag = false;
		
		String sXpathTemp = "";
		WebElement ele;

		for (int rowCount = 2; rowCount <= 7; rowCount++) {
			for (int columnCnt = 1; columnCnt <= 7; columnCnt++) {

				try {
					
					sXpathTemp = sDoubleQoute + sBeforeXpath + rowCount + sAfterXPath + columnCnt + sEndsWith + sDoubleQoute;
					System.out.println("sXpathTemp is = "+ sXpathTemp);
					
					ele =  driver
							.findElement(By.xpath(sXpathTemp));
					sDateValue = ele.getText();
							
					//sDateValue = driver
						//	.findElement(By.xpath(sBeforeXpath + rowCount + sAfterXPath + columnCnt + sEndsWith))
						//	.getText();

					//sDateValue = driver
					//		.findElement(By.xpath("//div[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[5]/td[3]"))
					//		.getText();
					System.out.println("sDateValue is = "+ sDateValue);
				} catch (Exception e) {
					System.out.println("Please enter correct date");
					flag = true;
					break;

				}

				if (sDateValue.equals(sDaySelect)) {
					driver.findElement(By.xpath(sBeforeXpath + rowCount + sAfterXPath + columnCnt + sEndsWith)).click();
					flag = true;
					break;

				}

			}

			if (flag) {
				break;
			}
		}

	}

	@AfterMethod
	public void closeBrowser() {
		// driver.quit();

	}

}
