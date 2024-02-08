package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils  {
	
	public void writeExcel(List<String>arr,int col) throws IOException {
	//FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\NewsHeadings.xlsx");
	FileOutputStream fo=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\NewsHeadings.xlsx");	
	XSSFWorkbook wb=new XSSFWorkbook();
	XSSFSheet sheet=wb.createSheet();
	int count=arr.size();
	for(int i=0;i<count;i++) {
	XSSFRow row=sheet.createRow(i);
	row.createCell(col).setCellValue(arr.get(i));
	}
	
	wb.write(fo);
	wb.close();
	//file.close();
	fo.close();;
	}
	

}
