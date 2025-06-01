package api.Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	
	
	
	@DataProvider(name = "alldata")
	public static String[][] excelData() throws IOException {
		String fName=System.getProperty("user.dir")+"//TestData//TestData.xlsx";
		
		int ttlRowCnt=ReadExcellFile.getRowCount(fName, "Sheet1");
		int ttlcellcnt=ReadExcellFile.getColCount(fName, "Sheet1");
		
		String userData[][] = new String[ttlRowCnt-1][ttlcellcnt];
		
		for(int r=1; r<ttlRowCnt; r++) {
			for(int c= 0;c<ttlcellcnt;c++) {
				userData[r-1][c]=ReadExcellFile.getCellValue(fName, "Sheet1", r, c);
				
			}
		}
		return userData;
		
}
	@DataProvider(name="userNameData")
		public static String[] usernameData() throws IOException {
		String fname=System.getProperty("user.dir")+"//TestData//TestData.xlsx";
		int totalRowCount=ReadExcellFile.getRowCount(fname, "Sheet1");
		//int totalCeCount = ReadExcellFile.getColCount(fname, "Sheet1");
		
		String userData[]=new String[totalRowCount];
		for(int r=0;r<totalRowCount;r++) {
			userData[r-1]=ReadExcellFile.getCellValue(fname, "Sheet1", r, 1);
			
		}
		return userData;		
	}
	
}