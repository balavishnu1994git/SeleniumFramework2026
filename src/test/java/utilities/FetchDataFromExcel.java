package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ConstantsData.ConstsntData;


public class FetchDataFromExcel {
	
	
	
	public static String getUserCredentials(int x,int y) throws IOException
	{
		FileInputStream fs=new FileInputStream(ConstsntData.EXCEL_PATH);
		XSSFWorkbook workbook= new XSSFWorkbook(fs);
		XSSFSheet sheet=workbook.getSheetAt(0);//Exl first sheet
		XSSFCell val=sheet.getRow(x).getCell( y);
		String url=val.toString();
		 workbook.close();
		    fs.close();

		    return url;
	}

}
