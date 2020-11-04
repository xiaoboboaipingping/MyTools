package com.tools.office;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class ReadExcel {
	public static void main(String[] args) throws RowsExceededException, WriteException {
//		String sourceFile ="d:\\TMP200318A.xls"; //源文件
//		try{
//			  Workbook book = Workbook.getWorkbook(new File(sourceFile));
//			  //0代表第一个工作表对象
//			  Sheet sheet =(Sheet) book.getSheet(0);
//			  int rows =sheet.getRows();
//			  int cols =sheet.getColumns();
//			  String colname1 =sheet.getCell(0, 0).getContents().trim();
//			  String colname2 =sheet.getCell(1, 0).getContents().trim();
//			  String colname3 =sheet.getCell(2, 0).getContents().trim();
//			  System.out.println(colname1+","+colname2+","+colname3);
//			  for (int z = 1; z <rows; z++)
//			  {
//				      //0代表列数，z代表行数
//				  String name =sheet.getCell(0, z).getContents();
//				  String sex =sheet.getCell(1, z).getContents();
//				  String ID =sheet.getCell(2, z).getContents();
//				  System.out.println(name+","+sex+","+ID);
//			  }
//	       }catch(Exception e){
//	    	   e.printStackTrace();
//	       }
		
		writeExcel();
	}
	private static void writeExcel() throws RowsExceededException, WriteException{
		  Workbook   wb=null;  
		  WritableWorkbook wwb=null;  
		  try {  
			   //从源文件中进行读取  
			   wb=Workbook.getWorkbook(new File("d:\\TMP200318A.xls"));  		     
			   wwb=Workbook.createWorkbook(new File("d:\\123.xls"),wb);  		  		     
			   WritableSheet ws= wwb.getSheet(0);  
			   for(int i=1;i<10870;i++){  
				   Label l=new Label(7,i,"1234321");				
				   ws.addCell(l);	  
			   }
			 } catch (BiffException e) {  
			  // TODO Auto-generated catch block  
			  e.printStackTrace();  
			 } catch (IOException e) {  
			  // TODO Auto-generated catch block  
			  e.printStackTrace();  
			 }  
		       
		     finally{  
		      //关闭  
		      try {  
		       wwb.write();  
		       wwb.close();  
		      } catch (Exception e) {  
		       // TODO Auto-generated catch block  
		       e.printStackTrace();  
		      }  
		        
		      wb.close();  
		        
		     }  
		     System.out.println("修改了");    
}
}
	
