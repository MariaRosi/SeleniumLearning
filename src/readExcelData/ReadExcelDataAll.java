package readExcelData;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDataAll {

	public static void main(String[] args) throws  Exception {
		
		String strUsername = "";
		String strUserpwd = "";
		
		File srcFile = new File("D:\\Maria\\Selenium\\ExcelRead\\TestData.xlsx");
		
		FileInputStream fis = new FileInputStream(srcFile);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet0 = wb.getSheetAt(0);
		
		int iRowCount = sheet0.getLastRowNum();
		
		for (int i=0;i<iRowCount;i++) {
			
			strUsername = sheet0.getRow(i).getCell(0).getStringCellValue();
			strUserpwd = sheet0.getRow(i).getCell(1).getStringCellValue();
			
			System.out.println("The user name is "+strUsername);
			System.out.println("The user pwd is "+strUserpwd);
		}

		wb.close();

	}

}
