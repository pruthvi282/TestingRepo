package genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {


	public String readingData(String path,String sheet,int rownum,int cellnum) throws Throwable{
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		String value=wb.getSheet(sheet).getRow(rownum).getCell(cellnum).getStringCellValue();
		return value;
		
	}
}
