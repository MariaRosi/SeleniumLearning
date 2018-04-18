package testNGLearning;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {
	
	@Test(dataProvider="getData")
	public void doDataProviderTest(String sUserName, String sUserPwd, String sExpectedResult, String sBrowserName) {
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = new Object[2][4];
		
		//First Row
		data[0][0] = "Username1";
		data[0][1] = "Password1";
		data[0][2] = "Pass";
		data[0][3] = "Chrome";
		
		//Second Row
		data[1][0] = "Username2";
		data[1][1] = "Password2";
		data[1][2] = "Fail";
		data[1][3] = "Firefox";
		
		return data;
		
	}

}
