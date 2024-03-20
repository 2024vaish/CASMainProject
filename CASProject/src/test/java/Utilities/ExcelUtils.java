package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils  {
	FileInputStream fi;
	FileOutputStream fo;
	XSSFWorkbook wb;
	XSSFSheet ws;
	XSSFRow row;
	XSSFCell cell;
	public void writeExcel(String fileName,List<String>arr) throws IOException  {
	try
	{
		fi=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\"+fileName+".xlsx");
		fo=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\"+fileName+".xlsx");	
		wb=new XSSFWorkbook();
		ws=wb.createSheet();
		int count=arr.size();
		int r=0;
		for(String s:arr) {
			row=ws.createRow(r);
			row.createCell(0).setCellValue(s);
			r++;
			}
	}
	catch(IOException E) {
	}
	finally {
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
		}
	
	}
	
	public void writeExcel(String fileName,String data,int r,int c) throws IOException {
		try {
		fi=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\"+fileName+".xlsx");
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheetAt(0);
		row=ws.createRow(r);
		cell=row.createCell(c);
		cell.setCellValue(data);
		fo=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\"+fileName+".xlsx");
		}
		catch(IOException E){
		}
		finally {
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
		}
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
