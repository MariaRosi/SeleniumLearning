package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	public static void captureScreenshots(WebDriver driver, String filename) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;

			File sourseFile = ts.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(sourseFile, new File("./Screenshots/" + filename + ".png"));

		} catch (Exception e) {
			System.out.println("Exception in taking screenshots " + e.getMessage());
		}
	}

	public static Object[][] getTestDataFromExcel(String filename, String sheetname) {
		System.out.println("******** getTestDataFromExcel ********* START");
		System.out.println("******** filename ********* "+filename);
		System.out.println("******** sheetname ********* "+sheetname);
		
		File srcFile = null;
		FileInputStream fis = null;
		XSSFWorkbook wb = null;
		XSSFSheet sheet = null;

		int rowCnt = 0;
		int columnCnt = 0;

		Object data[][] = null;

		try {
			srcFile = new File(filename);

			fis = new FileInputStream(srcFile);

			wb = new XSSFWorkbook(fis);

			sheet = wb.getSheet(sheetname);
			
			rowCnt = sheet.getLastRowNum();
			columnCnt = sheet.getRow(0).getLastCellNum();
			
			System.out.println("******** rowCnt ********* "+rowCnt);
			System.out.println("******** columnCnt ********* "+columnCnt);
			

			data = new Object[rowCnt][columnCnt];

			for (int i = 0; i < rowCnt; i++) {
				for (int k = 0; k < columnCnt; k++) {
					
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					System.out.println(data[i][k]);

				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("******** getTestDataFromExcel ********* END");
		return data;

	}

}
