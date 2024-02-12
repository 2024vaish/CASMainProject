package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils  {
	
	public void writeExcel(String fileName,List<String>arr) throws IOException {
	FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\"+fileName+".xlsx");
	FileOutputStream fo=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\"+fileName+".xlsx");	
	XSSFWorkbook wb=new XSSFWorkbook();
	XSSFSheet sheet=wb.createSheet();
	int count=arr.size();
	int r=0;
	for(String s:arr) {
	XSSFRow row=sheet.createRow(r);
	row.createCell(0).setCellValue(s);
	r++;
	}
	wb.write(fo);
	wb.close();
	file.close();
	fo.close();;
	}
	
	public void writeExcel(String fileName,String data,int r,int c) throws IOException {
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\"+fileName+".xlsx");
		FileOutputStream fo=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\"+fileName+".xlsx");	
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sheet=wb.createSheet();
		//int count=arr.size();
		//int r=0;
		//for(String s:arr) {
		XSSFRow row=sheet.createRow(r);
		row.createCell(c).setCellValue(data);
	
		
		wb.write(fo);
		wb.close();
		file.close();
		fo.close();;
		}
	public List<String> readExcel(String fileName) throws IOException{
		
		FileInputStream file=new FileInputStream(System.getProperty("user.dir") + "\\testdata\\"+fileName+".xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet ws = wb.getSheetAt(0);
		List<String> data=new ArrayList<String>();
		int rows = ws.getLastRowNum();
		for (int j = 0; j < rows; j++) {
			XSSFRow r = ws.getRow(j);
			data.add(r.getCell(0).toString());
		}
		return data;
		
	}
	

}
