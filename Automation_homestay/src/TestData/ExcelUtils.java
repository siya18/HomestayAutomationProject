package TestData;


import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	private static XSSFSheet ExcelSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell ExcelCell;
	private static XSSFRow ExcelRow;
	
	
	
	public static void setExcelFile(String Path, String SheetName) throws Exception
	{
		try {
			FileInputStream ExcelFile=new FileInputStream(Path);
			ExcelWBook= new XSSFWorkbook(ExcelFile);
			ExcelSheet=ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String getCellData(int RowNum, int ColNum)
	{
		String CellData;
		ExcelCell=ExcelSheet.getRow(RowNum).getCell(ColNum);
		
		if(ExcelCell==null)
		{
			CellData="";
		}
		else
		{
			CellData=ExcelCell.getStringCellValue();
		}
		 
		return CellData;
	
	}
	public static void setCellData(String Result,int RowNum, int ColNum)
	{
		ExcelRow=ExcelSheet.getRow(RowNum);
		ExcelCell=ExcelRow.getCell(ColNum);
		if(ExcelCell==null)
		{
			ExcelCell=ExcelRow.createCell(ColNum);
			ExcelCell.setCellValue(Result);
		}
		else
		{
			ExcelCell.setCellValue(Result);
		}
	
	
	FileOutputStream fileout;
	{
	try
	{
		fileout= new FileOutputStream(Constant.TestDataSheetPath+Constant.TestDataFileName);
		ExcelWBook.write(fileout);
		fileout.flush();
		fileout.close();
	}
	catch(Exception E)
	{
		System.out.println("Exception"+E);
	}
	
	}
	
	
	}
	
	
	
	
	
	
	

}
