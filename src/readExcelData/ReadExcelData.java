package readExcelData;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static void main(String[] args) throws  Exception {
		
		File srcFile = new File("D:\\Maria\\Selenium\\ExcelRead\\TestData.xlsx");
		
		FileInputStream fis = new FileInputStream(srcFile);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet0 = wb.getSheetAt(0);
		
		String strUsername = sheet0.getRow(0).getCell(0).getStringCellValue();
		String strUserpwd = sheet0.getRow(0).getCell(1).getStringCellValue();
		
		System.out.println("The user name is "+strUsername);
		System.out.println("The user pwd is "+strUserpwd);
		
		wb.close();

	}

}
