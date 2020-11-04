package com.tools.office;

import java.io.FileOutputStream;
import java.io.IOException;

//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.hssf.util.CellRangeAddress;
//import org.apache.poi.hssf.util.HSSFColor;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.Font;
//import org.apache.poi.ss.usermodel.IndexedColors;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.util.RegionUtil;

public class WriteExcel {
	public static void main(String[] args) {
//		//创建工作簿
//		Workbook wb = new HSSFWorkbook();
//		
//		//创建A、B两个 Sheet 页
//		Sheet sheetA = wb.createSheet("新农合业务量统计");
//		//设置标题字体
//		Font fontTitle = wb.createFont();
//      	fontTitle.setFontHeightInPoints((short) 11); //字体大小
//      	fontTitle.setColor(HSSFColor.BLACK.index); //字体颜色
//      	fontTitle.setFontName("宋体"); //字体
//      	fontTitle.setBoldweight(Font.BOLDWEIGHT_BOLD); //粗体显示
////      font.setItalic(true); //是否使用斜体
////      font.setStrikeout(true); //是否使用划线
//		
//		
//        //设置标题单元格类型
//		CellStyle cellStyleTitle = wb.createCellStyle();
//		cellStyleTitle.setFont(fontTitle);
//      	cellStyleTitle.setFillPattern(CellStyle.SOLID_FOREGROUND);
//      	cellStyleTitle.setAlignment(CellStyle.ALIGN_CENTER); //水平布局：居中
//      	cellStyleTitle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
//      	cellStyleTitle.setWrapText(true);//设置自动换行
//      
//      	cellStyleTitle.setBorderBottom(CellStyle.BORDER_THIN); //下边框  
//      	cellStyleTitle.setBorderLeft(CellStyle.BORDER_THIN);//左边框   
//      	cellStyleTitle.setBorderTop(CellStyle.BORDER_THIN);//上边框    
//      	cellStyleTitle.setBorderRight(CellStyle.BORDER_THIN);//右边框   
//		
//		CellRangeAddress region  = new CellRangeAddress(2, 3, 1, 1); // 起始行号，终止行号， 起始列号，终止列号
//		CellRangeAddress region1 = new CellRangeAddress(2, 2, 2, 8); // 起始行号，终止行号， 起始列号，终止列号
//		CellRangeAddress region2 = new CellRangeAddress(2, 3, 9, 9); // 起始行号，终止行号， 起始列号，终止列号
//		CellRangeAddress region3 = new CellRangeAddress(2, 3, 10, 10); // 起始行号，终止行号， 起始列号，终止列号
//        sheetA.addMergedRegion(region);
//        sheetA.addMergedRegion(region1);
//        sheetA.addMergedRegion(region2);
//        sheetA.addMergedRegion(region3);
//		
//		//创建A的两个单元行
//		Row row0 = sheetA.createRow(2);
//		Row row1 = sheetA.createRow(2);
//		Row row2 = sheetA.createRow(2);
//		Row row3 = sheetA.createRow(2);
//		
//		Row row11 = sheetA.createRow(3);
//		Row row12 = sheetA.createRow(3);
//		Row row13 = sheetA.createRow(3);
//		Row row14 = sheetA.createRow(3);
//		Row row15 = sheetA.createRow(3);
//		Row row16 = sheetA.createRow(3);
//		Row row17 = sheetA.createRow(3);
//		
//		//创建sheetA第一、二行的单元格
//		Cell cell0 = row0.createCell(1);
//		Cell cell10 = row1.createCell(2);
//		Cell cell11 = row2.createCell(9);
//		Cell cell12 = row3.createCell(10);
//
//		Cell cel11 = row11.createCell(2);
//		Cell cel12 = row12.createCell(3);
//		Cell cel13 = row13.createCell(4);
//		Cell cel14 = row14.createCell(5);
//		Cell cel15 = row15.createCell(6);
//		Cell cel16 = row16.createCell(7);
//		Cell cel17 = row17.createCell(8);
//
//		
//		//给单元格赋值
//		cell0.setCellValue("日期");
//		cell0.setCellStyle(cellStyleTitle);
//		cell10.setCellValue("渠道（笔数）");
//		cell10.setCellStyle(cellStyleTitle);
//		cell11.setCellValue("总笔数");
//		cell11.setCellStyle(cellStyleTitle);
//		cell12.setCellValue("总金额");
//		cell12.setCellStyle(cellStyleTitle);
//		
//		
//		cel11.setCellValue("柜面");
//		cel11.setCellStyle(cellStyleTitle);
//		cel12.setCellValue("ATM");
//		cel12.setCellStyle(cellStyleTitle);
//		cel13.setCellValue("POS");
//		cel13.setCellStyle(cellStyleTitle);
//		cel14.setCellValue("自助机具");
//		cel14.setCellStyle(cellStyleTitle);
//		cel15.setCellValue("手机银行");
//		cel15.setCellStyle(cellStyleTitle);
//		cel16.setCellValue("微信银行");
//		cel16.setCellStyle(cellStyleTitle);
//		cel17.setCellValue("网上银行");
//		cel17.setCellStyle(cellStyleTitle);
//		
//		//赋值
//		for(int i =0;i<5;i++){
//			Row rowt = sheetA.createRow(i+4);
//			
//			Cell cellt = rowt.createCell(1);
//			cellt.setCellValue("11.11");
//			cellt.setCellStyle(cellStyleTitle);
//			
//			Cell cellt1 = rowt.createCell(2);
//			cellt1.setCellValue("4906");
//			cellt1.setCellStyle(cellStyleTitle);
//			
//			Cell cellt2 = rowt.createCell(3);
//			cellt2.setCellValue("104");
//			cellt2.setCellStyle(cellStyleTitle);
//			
//			Cell cellt3 = rowt.createCell(4);
//			cellt3.setCellValue("160");
//			cellt3.setCellStyle(cellStyleTitle);
//			
//			Cell cellt4 = rowt.createCell(5);
//			cellt4.setCellValue("0");
//			cellt4.setCellStyle(cellStyleTitle);
//			
//			Cell cellt5 = rowt.createCell(6);
//			cellt5.setCellValue("162");
//			cellt5.setCellStyle(cellStyleTitle);
//			
//			Cell cellt6 = rowt.createCell(7);
//			cellt6.setCellValue("157");
//			cellt6.setCellStyle(cellStyleTitle);
//			
//			Cell cellt7 = rowt.createCell(8);
//			cellt7.setCellValue("7");
//			cellt7.setCellStyle(cellStyleTitle);
//			
//			Cell cellt8 = rowt.createCell(9);
//			cellt8.setCellValue("5496");
//			cellt8.setCellStyle(cellStyleTitle);
//			
//			Cell cellt9 = rowt.createCell(10);
//			cellt9.setCellValue("1538860");
//			cellt9.setCellStyle(cellStyleTitle);
//						
//		}
//		
//		try {
//			FileOutputStream fos = new FileOutputStream("D:\\test\\newExcel.xls");
//			wb.write(fos);
//			fos.close();
//			//((FileOutputStream) wb).close();
//			System.out.println("写数据结束！");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//
//		
////		//创建工作薄(excel)
////        Workbook wb = new HSSFWorkbook();
////        //创建sheet
////        Sheet createSheet = wb.createSheet("sheet1");
////
////        //设置标题字体
////        Font fontTitle = wb.createFont();
//////        fontTitle.setFontHeightInPoints((short) 18); //字体大小
//////        fontTitle.setColor(HSSFColor.BLACK.index); //字体颜色
//////        fontTitle.setFontName("宋体"); //字体
//////        fontTitle.setBoldweight(Font.BOLDWEIGHT_BOLD); //粗体显示
////        //font.setItalic(true); //是否使用斜体
////        //font.setStrikeout(true); //是否使用划线
////
////        //设置标题单元格类型
////        CellStyle cellStyleTitle = wb.createCellStyle();
////        cellStyleTitle.setFont(fontTitle);
////        cellStyleTitle.setFillForegroundColor(IndexedColors.LIME.getIndex());
////        cellStyleTitle.setFillPattern(CellStyle.SOLID_FOREGROUND);
////        cellStyleTitle.setAlignment(CellStyle.ALIGN_CENTER); //水平布局：居中
////        cellStyleTitle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
////        cellStyleTitle.setWrapText(true);//设置自动换行
////        
////        cellStyleTitle.setBorderBottom(CellStyle.BORDER_THIN); //下边框  
////        cellStyleTitle.setBorderLeft(CellStyle.BORDER_THIN);//左边框   
////        cellStyleTitle.setBorderTop(CellStyle.BORDER_THIN);//上边框    
////        cellStyleTitle.setBorderRight(CellStyle.BORDER_THIN);//右边框   
////        cellStyleTitle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
////        cellStyleTitle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
////        cellStyleTitle.setTopBorderColor(IndexedColors.BLACK.getIndex());
////        cellStyleTitle.setRightBorderColor(IndexedColors.BLACK.getIndex());
////
////        
////        //创建合并单元格  ---begin
////        //CellRangeAddress region = new CellRangeAddress(0, 0, 1, 3);// 下标从0开始 起始行号，终止行号， 起始列号，终止列号
////        CellRangeAddress region2 = new CellRangeAddress(1, 2, 0, 0);// 起始行号，终止行号， 起始列号，终止列号
////        CellRangeAddress region3 = new CellRangeAddress(1, 1, 1, 3);// 起始行号，终止行号， 起始列号，终止列号
////        //在sheet里增加合并单元格  
////        //createSheet.addMergedRegion(region);
////        createSheet.addMergedRegion(region2);
////        createSheet.addMergedRegion(region3);
////        
////        // -----------填充第一行数据-------------
////        Row rowTitle = createSheet.createRow(0);
////        Cell cellTitle = rowTitle.createCell(0);
////        cellTitle.setCellStyle(cellStyleTitle);
////        cellTitle.setCellValue("");// 设置标题内容
////        Cell cellTitle1_1 = rowTitle.createCell(1);
////        cellTitle1_1.setCellStyle(cellStyleTitle);
////        cellTitle1_1.setCellValue("");// 设置标题内容
////        // -----------填充第二行数据-------------
////        Row rowTitle1 = createSheet.createRow(1);
////        Cell cellTitle1 = rowTitle1.createCell(0);
////        cellTitle1.setCellStyle(cellStyleTitle);
////        cellTitle1.setCellValue("店名");//  设置内容
////        Cell cellTitle11 = rowTitle1.createCell(1);
////        cellTitle11.setCellStyle(cellStyleTitle);
////        cellTitle11.setCellValue("王总");//
////        Cell cellTitle111 = rowTitle1.createCell(2);
////        cellTitle111.setCellStyle(cellStyleTitle);
////        cellTitle111.setCellValue("");// 虽然这个单元格不可以不设置，但是要给它设置样式，所以也写了
////        Cell cellTitle1111 = rowTitle1.createCell(3);
////        cellTitle1111.setCellStyle(cellStyleTitle);
////        cellTitle1111.setCellValue("");// 虽然这个单元格不可以不设置，但是要给它设置样式，所以也写了
////        // -----------填充第三行数据-------------
////        Row rowTitle2 = createSheet.createRow(2);
////        Cell cellTitle2 = rowTitle2.createCell(1);
////        cellTitle2.setCellStyle(cellStyleTitle);
////        cellTitle2.setCellValue("装修费");//  设置内容
////        Cell cellTitle22 = rowTitle2.createCell(2);
////        cellTitle22.setCellStyle(cellStyleTitle);
////        cellTitle22.setCellValue("加盟费");//  设置内容
////        Cell cellTitle222 = rowTitle2.createCell(3);
////        cellTitle222.setCellStyle(cellStyleTitle);
////        cellTitle222.setCellValue("人员培训费");//  设置内容 
////        // 合并单元格 ----end
////        // 第四行数据留着下面写
////
////        //设置表头字体
////        Font fontHead = wb.createFont();
////        fontHead.setFontHeightInPoints((short) 14); //字体大小
////        fontHead.setColor(Font.COLOR_NORMAL); //字体颜色
////        fontHead.setFontName("Microsoft Sans Serif"); //字体
////        fontHead.setBoldweight(Font.BOLDWEIGHT_BOLD); //粗体显示
////        //font.setItalic(true); //是否使用斜体
////        //font.setStrikeout(true); //是否使用划线
////
////        //设置表头单元格类型
////        CellStyle cellStyleHead = wb.createCellStyle();
////        cellStyleHead.setFont(fontHead);
////        cellStyleHead.setAlignment(CellStyle.ALIGN_CENTER); //水平布局：居中
////        cellStyleHead.setFillForegroundColor(IndexedColors.LIME.getIndex());
////        cellStyleHead.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
////        cellStyleHead.setWrapText(true);//设置自动换行
////
////        cellStyleHead.setBorderBottom(CellStyle.BORDER_THIN); //下边框  
////        cellStyleHead.setBorderLeft(CellStyle.BORDER_THIN);//左边框   
////        cellStyleHead.setBorderTop(CellStyle.BORDER_THIN);//上边框    
////        cellStyleHead.setBorderRight(CellStyle.BORDER_THIN);//右边框   
////        cellStyleHead.setBottomBorderColor(IndexedColors.BLACK.getIndex());
////        cellStyleHead.setLeftBorderColor(IndexedColors.BLACK.getIndex());
////        cellStyleHead.setTopBorderColor(IndexedColors.BLACK.getIndex());
////        cellStyleHead.setRightBorderColor(IndexedColors.BLACK.getIndex());
////
////        //创建第一行，标题
////        Row row = createSheet.createRow(3);
////        String[] cellHead = {"", "","", ""};
////        // 设置列宽
////        double[] titleWidth = {10, 24, 24, 24};
////        for (int i = 0; i < cellHead.length; i++) {
////            Cell createCell = row.createCell(i);
////            createCell.setCellValue(cellHead[i]);
////            createCell.setCellStyle(cellStyleHead);
////        }
////        
////
////        //设置内容字体
////        Font fontData = wb.createFont();
////        fontData.setFontHeightInPoints((short) 14); //字体大小
////        fontData.setColor(Font.COLOR_NORMAL); //字体颜色
////        fontData.setFontName("Microsoft Sans Serif"); //字体
////        //font.setBoldweight(Font.BOLDWEIGHT_BOLD); //粗体显示
////        //font.setItalic(true); //是否使用斜体
////        //font.setStrikeout(true); //是否使用划线
////
////        //设置内容单元格类型
////        CellStyle cellStyleDataOdd = wb.createCellStyle();
////        cellStyleDataOdd.setFont(fontData);
////        cellStyleDataOdd.setFillPattern(CellStyle.SOLID_FOREGROUND);
////        cellStyleDataOdd.setAlignment(CellStyle.ALIGN_CENTER); //水平布局：居中
////        cellStyleDataOdd.setWrapText(true);
////
////        cellStyleDataOdd.setBorderBottom(CellStyle.BORDER_THIN); //下边框
////        cellStyleDataOdd.setBorderLeft(CellStyle.BORDER_THIN);//左边框
////        cellStyleDataOdd.setBorderTop(CellStyle.BORDER_THIN);//上边框
////        cellStyleDataOdd.setBorderRight(CellStyle.BORDER_THIN);//右边框
////        cellStyleDataOdd.setBottomBorderColor(IndexedColors.BLACK.getIndex());
////        cellStyleDataOdd.setLeftBorderColor(IndexedColors.BLACK.getIndex());
////        cellStyleDataOdd.setTopBorderColor(IndexedColors.BLACK.getIndex());
////        cellStyleDataOdd.setRightBorderColor(IndexedColors.BLACK.getIndex());
////
//////        try {
//////            int no = 1;
//////            for (int i = 0; i < datas.length(); i++) {
//////                JSONObject dayData = datas.getJSONObject(i);
//////                String date = dayData.optString("date");
//////                JSONArray detail = dayData.getJSONArray("detail");
//////                
//////                for (int k = 0; k < detail.length(); k++) {
//////                    JSONObject ss = detail.getJSONObject(k);
//////                    
//////                    row = createSheet.createRow(k + 4);
//////                    int j = 0;
//////                    // 店名
//////                    Cell cell1 = row.createCell(j++);
//////                    cell1.setCellValue(ss.optString("xxxxx"));
//////                    cell1.setCellStyle(cellStyleDataOdd);
//////                    // 装修费
//////                    Cell cell2 = row.createCell(j++);
//////                    cell2.setCellValue(ss.optString("xxxxx"));
//////                    cell2.setCellStyle(cellStyleDataOdd);
//////                    // 加盟费
//////                    Cell cell7 = row.createCell(j++);
//////                    cell7.setCellValue(ss.optString("xxxxxx"));
//////                    cell7.setCellStyle(cellStyleDataOdd);
//////                    // 人员培训费
//////                    Cell cellH = row.createCell(j++);
//////                    cellH.setCellValue(ss.optString("xxxxxx"));
//////                    cellH.setCellStyle(cellStyleDataOdd);
//////                }
//////            }
//////                
//////        } catch (JSONException e) {
//////            e.printStackTrace();
//////        }
////        
////        // 设置列宽
////        for (int i = 0; i < titleWidth.length; i++) {
////             createSheet.setColumnWidth((short) i, (short) titleWidth[i] * 256);
////        }
////        
////        // 设置上面四行冻结
////        createSheet.createFreezePane( 0, 4, 1, 4); // 前两个参数是你要用来拆分的列数和行数。后两个参数是下面窗口的可见象限，其中第三个参数是右边区域可见的左边列数，第四个参数是下面区域可见的首行
////		
////		try {
////		FileOutputStream fos = new FileOutputStream("D:\\test\\newExcel.xls");
////		wb.write(fos);
////		fos.close();
////		//((FileOutputStream) wb).close();
////		System.out.println("写数据结束！");
////	} catch (IOException e) {
////		// TODO Auto-generated catch block
////		e.printStackTrace();
////	}	
//	}
//	
//	//用poi自带的工具类来处理合并后的边框
//	public static void setBorderStyle(int border,CellRangeAddress region,Sheet sheet,Workbook wb){
//		RegionUtil.setBorderBottom(border,region, sheet, wb);
//		RegionUtil.setBorderLeft(border,region, sheet, wb);
//		RegionUtil.setBorderRight(border,region, sheet, wb);
//		RegionUtil.setBorderTop(border,region, sheet, wb);
//	}
//
//
////	
////	public static boolean dataToExcel( ){
////		Boolean flag = false;
////		
////		return flag;
////	}
	}
}
