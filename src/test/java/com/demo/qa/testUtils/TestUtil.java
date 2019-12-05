package com.demo.qa.testUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.demo.qa.testCases.BaseTest;

public class TestUtil extends BaseTest {

	public static long PAGE_LOAD_TIMEOUT=60;
	public static long IMPLICIT_WAIT=10;
	public static String projectPath= System.getProperty("user.dir");
	
	public static Object[][] getTestData(String sheetName) {
		try {

			XSSFWorkbook workbook = new XSSFWorkbook(projectPath+"\\src\\main\\java\\com\\demo\\qa\\testData\\DemoTestData.xlsx");
			XSSFSheet sheet= workbook.getSheet(sheetName);
			int rowCount= sheet.getPhysicalNumberOfRows();
			int colCount= sheet.getRow(0).getPhysicalNumberOfCells();

			Object data[][]= new Object[rowCount-1][colCount];

			for(int i=1; i<rowCount;i++) {		
				for(int j=0; j<colCount;j++) {
					String cellData=sheet.getRow(i).getCell(j).getStringCellValue();
					data[i-1][j]=cellData;
				}

			}
			return data;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}
		return null;



	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(projectPath + "/screenshots/" + System.currentTimeMillis() + ".png"));

	}


}
