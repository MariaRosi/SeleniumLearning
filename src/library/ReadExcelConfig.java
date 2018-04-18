package library;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelConfig {
	
	public static XSSFWorkbook wb;
	
	public ReadExcelConfig(String fileName) {
		
		try {
			File srcFile = new File(fileName);
			
			FileInputStream fis = new FileInputStream(srcFile);
			
			wb = new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			System.out.println("The Exception in ReadExcelConfig constructor  is "+e.getMessage());
		}
	}
	
	public String getData(int iSheetNumber, int iRow,int iColumn) {
		
		XSSFSheet sheet = wb.getSheetAt(iSheetNumber);
		
		String sData = sheet.getRow(iRow).getCell(iColumn).getStringCellValue();
		
		return sData;
		
	}
	

}
