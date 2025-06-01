package api.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcellFile {
	
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static int getRowCount(String file,String sheet) throws IOException {
		
		//sh.getLastCellNum
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(sheet);
		
		int ttlrows = sh.getLastRowNum()+1;
		return ttlrows;		
	}
	
	public static int getColCount(String file,String sheet) throws IOException {
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(sheet);
		
		int ttlcols = sh.getRow(0).getLastCellNum();
		return ttlcols;
	}
	
	public static String getCellValue(String file,String sheet,int Row, int Cell) throws IOException {
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(sheet);
		cell = wb.getSheet(sheet).getRow(Row).getCell(Cell);
		DataFormatter formatter = new DataFormatter();
	    String value = formatter.formatCellValue(cell);  // ✅ Converts any type to a formatted String

	    wb.close();
	   fis.close();

	    return value;
		
		
		
	}
}
