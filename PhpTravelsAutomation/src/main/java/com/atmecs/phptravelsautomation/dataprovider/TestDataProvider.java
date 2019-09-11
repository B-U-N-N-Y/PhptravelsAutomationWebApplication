package com.atmecs.phptravelsautomation.dataprovider;

import org.testng.annotations.DataProvider;

import com.atmecs.phptravelsautomation.constants.FilePath;
import com.atmecs.phptravelsautomation.utils.ReadExcelFile;

public class TestDataProvider {


	@DataProvider(name = "toolsShop")
	public Object[][] testData() {
		ReadExcelFile file = new ReadExcelFile(FilePath.TESTDATA_FILE);
		int sheetIndex = 0;
		int rowNo= 1;
		int rowCount = file.totalRowsinSheet(sheetIndex);
		int colCount = file.totalColsinSheet(sheetIndex,rowNo);

		System.out.println("In testData:: rowCount=" + rowCount);
		System.out.println("In testData:: colCount=" + colCount);

		Object[][] data = new Object[rowCount][colCount];

		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			for (int colIndex = 0; colIndex < colCount; colIndex++) {

				data[rowIndex][colIndex] = file.getData(sheetIndex, rowIndex + 1, colIndex);
			}
		}
		return data;
	}

	    
	    public static void main(String[] args) {
			
		
		Object[][] data = new TestDataProvider().testData();
		for (Object[] objects : data) {
			String iname= (String) objects[0];
			String pname=(String) objects[1];
		
			/*String fromDate = (String) objects[4];
			String toDate = (String) objects[5];
			String partialdays = (String) objects[6];
			String duration = (String) objects[7];*/
			
			System.out.println(" " + iname + " -- " + pname);//+"..."+color+"--"+order+"--"+fromDate+"--"+toDate+"--"+partialdays+"--"+duration);
		
		
		}   

	    }
	   
}
