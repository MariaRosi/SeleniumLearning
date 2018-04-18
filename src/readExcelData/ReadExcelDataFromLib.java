package readExcelData;

import library.ReadExcelConfig;

public class ReadExcelDataFromLib {

	public static void main(String[] args) {
		
		ReadExcelConfig obj = new ReadExcelConfig("D:\\Maria\\Selenium\\ExcelRead\\TestData.xlsx");
		
		String sUserName = obj.getData(0, 0, 0);
		String sUserPwd = obj.getData(0, 0, 1);
		
		System.out.println("The user name is "+sUserName);
		System.out.println("The user pwd is "+sUserPwd);

	}

}
