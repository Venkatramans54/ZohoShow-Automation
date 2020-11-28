package com.zohoAutomation.wrapper;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonWrapper {
	
	public String takeScreenshot(WebDriver driver,String ScreenshotName) throws Exception {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("src/../Images/" + ScreenshotName + ".png");
		String path = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return path;
		
	}
	public Object[][] parseExcel(String filename, String sheetName,int columnCount) {
		File file=new File(filename);
		XSSFWorkbook wkbook;
		XSSFSheet sheet;
		Object[][] arr=new Object[0][0];
		try {
			FileInputStream excel=new FileInputStream(file);
			wkbook=new XSSFWorkbook(excel);
			sheet=wkbook.getSheet(sheetName);
			int start=sheet.getFirstRowNum();
			int end=sheet.getLastRowNum();
			
			arr=new Object[start+1][columnCount];
			for(int i=start;i<=end;i++) {
				for(int j=0;j<=columnCount-1;j++) {
					arr[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return arr;
	}
}
