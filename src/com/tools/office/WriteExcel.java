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
//		//����������
//		Workbook wb = new HSSFWorkbook();
//		
//		//����A��B���� Sheet ҳ
//		Sheet sheetA = wb.createSheet("��ũ��ҵ����ͳ��");
//		//���ñ�������
//		Font fontTitle = wb.createFont();
//      	fontTitle.setFontHeightInPoints((short) 11); //�����С
//      	fontTitle.setColor(HSSFColor.BLACK.index); //������ɫ
//      	fontTitle.setFontName("����"); //����
//      	fontTitle.setBoldweight(Font.BOLDWEIGHT_BOLD); //������ʾ
////      font.setItalic(true); //�Ƿ�ʹ��б��
////      font.setStrikeout(true); //�Ƿ�ʹ�û���
//		
//		
//        //���ñ��ⵥԪ������
//		CellStyle cellStyleTitle = wb.createCellStyle();
//		cellStyleTitle.setFont(fontTitle);
//      	cellStyleTitle.setFillPattern(CellStyle.SOLID_FOREGROUND);
//      	cellStyleTitle.setAlignment(CellStyle.ALIGN_CENTER); //ˮƽ���֣�����
//      	cellStyleTitle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
//      	cellStyleTitle.setWrapText(true);//�����Զ�����
//      
//      	cellStyleTitle.setBorderBottom(CellStyle.BORDER_THIN); //�±߿�  
//      	cellStyleTitle.setBorderLeft(CellStyle.BORDER_THIN);//��߿�   
//      	cellStyleTitle.setBorderTop(CellStyle.BORDER_THIN);//�ϱ߿�    
//      	cellStyleTitle.setBorderRight(CellStyle.BORDER_THIN);//�ұ߿�   
//		
//		CellRangeAddress region  = new CellRangeAddress(2, 3, 1, 1); // ��ʼ�кţ���ֹ�кţ� ��ʼ�кţ���ֹ�к�
//		CellRangeAddress region1 = new CellRangeAddress(2, 2, 2, 8); // ��ʼ�кţ���ֹ�кţ� ��ʼ�кţ���ֹ�к�
//		CellRangeAddress region2 = new CellRangeAddress(2, 3, 9, 9); // ��ʼ�кţ���ֹ�кţ� ��ʼ�кţ���ֹ�к�
//		CellRangeAddress region3 = new CellRangeAddress(2, 3, 10, 10); // ��ʼ�кţ���ֹ�кţ� ��ʼ�кţ���ֹ�к�
//        sheetA.addMergedRegion(region);
//        sheetA.addMergedRegion(region1);
//        sheetA.addMergedRegion(region2);
//        sheetA.addMergedRegion(region3);
//		
//		//����A��������Ԫ��
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
//		//����sheetA��һ�����еĵ�Ԫ��
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
//		//����Ԫ��ֵ
//		cell0.setCellValue("����");
//		cell0.setCellStyle(cellStyleTitle);
//		cell10.setCellValue("������������");
//		cell10.setCellStyle(cellStyleTitle);
//		cell11.setCellValue("�ܱ���");
//		cell11.setCellStyle(cellStyleTitle);
//		cell12.setCellValue("�ܽ��");
//		cell12.setCellStyle(cellStyleTitle);
//		
//		
//		cel11.setCellValue("����");
//		cel11.setCellStyle(cellStyleTitle);
//		cel12.setCellValue("ATM");
//		cel12.setCellStyle(cellStyleTitle);
//		cel13.setCellValue("POS");
//		cel13.setCellStyle(cellStyleTitle);
//		cel14.setCellValue("��������");
//		cel14.setCellStyle(cellStyleTitle);
//		cel15.setCellValue("�ֻ�����");
//		cel15.setCellStyle(cellStyleTitle);
//		cel16.setCellValue("΢������");
//		cel16.setCellStyle(cellStyleTitle);
//		cel17.setCellValue("��������");
//		cel17.setCellStyle(cellStyleTitle);
//		
//		//��ֵ
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
//			System.out.println("д���ݽ�����");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//
//		
////		//����������(excel)
////        Workbook wb = new HSSFWorkbook();
////        //����sheet
////        Sheet createSheet = wb.createSheet("sheet1");
////
////        //���ñ�������
////        Font fontTitle = wb.createFont();
//////        fontTitle.setFontHeightInPoints((short) 18); //�����С
//////        fontTitle.setColor(HSSFColor.BLACK.index); //������ɫ
//////        fontTitle.setFontName("����"); //����
//////        fontTitle.setBoldweight(Font.BOLDWEIGHT_BOLD); //������ʾ
////        //font.setItalic(true); //�Ƿ�ʹ��б��
////        //font.setStrikeout(true); //�Ƿ�ʹ�û���
////
////        //���ñ��ⵥԪ������
////        CellStyle cellStyleTitle = wb.createCellStyle();
////        cellStyleTitle.setFont(fontTitle);
////        cellStyleTitle.setFillForegroundColor(IndexedColors.LIME.getIndex());
////        cellStyleTitle.setFillPattern(CellStyle.SOLID_FOREGROUND);
////        cellStyleTitle.setAlignment(CellStyle.ALIGN_CENTER); //ˮƽ���֣�����
////        cellStyleTitle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
////        cellStyleTitle.setWrapText(true);//�����Զ�����
////        
////        cellStyleTitle.setBorderBottom(CellStyle.BORDER_THIN); //�±߿�  
////        cellStyleTitle.setBorderLeft(CellStyle.BORDER_THIN);//��߿�   
////        cellStyleTitle.setBorderTop(CellStyle.BORDER_THIN);//�ϱ߿�    
////        cellStyleTitle.setBorderRight(CellStyle.BORDER_THIN);//�ұ߿�   
////        cellStyleTitle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
////        cellStyleTitle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
////        cellStyleTitle.setTopBorderColor(IndexedColors.BLACK.getIndex());
////        cellStyleTitle.setRightBorderColor(IndexedColors.BLACK.getIndex());
////
////        
////        //�����ϲ���Ԫ��  ---begin
////        //CellRangeAddress region = new CellRangeAddress(0, 0, 1, 3);// �±��0��ʼ ��ʼ�кţ���ֹ�кţ� ��ʼ�кţ���ֹ�к�
////        CellRangeAddress region2 = new CellRangeAddress(1, 2, 0, 0);// ��ʼ�кţ���ֹ�кţ� ��ʼ�кţ���ֹ�к�
////        CellRangeAddress region3 = new CellRangeAddress(1, 1, 1, 3);// ��ʼ�кţ���ֹ�кţ� ��ʼ�кţ���ֹ�к�
////        //��sheet�����Ӻϲ���Ԫ��  
////        //createSheet.addMergedRegion(region);
////        createSheet.addMergedRegion(region2);
////        createSheet.addMergedRegion(region3);
////        
////        // -----------����һ������-------------
////        Row rowTitle = createSheet.createRow(0);
////        Cell cellTitle = rowTitle.createCell(0);
////        cellTitle.setCellStyle(cellStyleTitle);
////        cellTitle.setCellValue("");// ���ñ�������
////        Cell cellTitle1_1 = rowTitle.createCell(1);
////        cellTitle1_1.setCellStyle(cellStyleTitle);
////        cellTitle1_1.setCellValue("");// ���ñ�������
////        // -----------���ڶ�������-------------
////        Row rowTitle1 = createSheet.createRow(1);
////        Cell cellTitle1 = rowTitle1.createCell(0);
////        cellTitle1.setCellStyle(cellStyleTitle);
////        cellTitle1.setCellValue("����");//  ��������
////        Cell cellTitle11 = rowTitle1.createCell(1);
////        cellTitle11.setCellStyle(cellStyleTitle);
////        cellTitle11.setCellValue("����");//
////        Cell cellTitle111 = rowTitle1.createCell(2);
////        cellTitle111.setCellStyle(cellStyleTitle);
////        cellTitle111.setCellValue("");// ��Ȼ�����Ԫ�񲻿��Բ����ã�����Ҫ����������ʽ������Ҳд��
////        Cell cellTitle1111 = rowTitle1.createCell(3);
////        cellTitle1111.setCellStyle(cellStyleTitle);
////        cellTitle1111.setCellValue("");// ��Ȼ�����Ԫ�񲻿��Բ����ã�����Ҫ����������ʽ������Ҳд��
////        // -----------������������-------------
////        Row rowTitle2 = createSheet.createRow(2);
////        Cell cellTitle2 = rowTitle2.createCell(1);
////        cellTitle2.setCellStyle(cellStyleTitle);
////        cellTitle2.setCellValue("װ�޷�");//  ��������
////        Cell cellTitle22 = rowTitle2.createCell(2);
////        cellTitle22.setCellStyle(cellStyleTitle);
////        cellTitle22.setCellValue("���˷�");//  ��������
////        Cell cellTitle222 = rowTitle2.createCell(3);
////        cellTitle222.setCellStyle(cellStyleTitle);
////        cellTitle222.setCellValue("��Ա��ѵ��");//  �������� 
////        // �ϲ���Ԫ�� ----end
////        // ������������������д
////
////        //���ñ�ͷ����
////        Font fontHead = wb.createFont();
////        fontHead.setFontHeightInPoints((short) 14); //�����С
////        fontHead.setColor(Font.COLOR_NORMAL); //������ɫ
////        fontHead.setFontName("Microsoft Sans Serif"); //����
////        fontHead.setBoldweight(Font.BOLDWEIGHT_BOLD); //������ʾ
////        //font.setItalic(true); //�Ƿ�ʹ��б��
////        //font.setStrikeout(true); //�Ƿ�ʹ�û���
////
////        //���ñ�ͷ��Ԫ������
////        CellStyle cellStyleHead = wb.createCellStyle();
////        cellStyleHead.setFont(fontHead);
////        cellStyleHead.setAlignment(CellStyle.ALIGN_CENTER); //ˮƽ���֣�����
////        cellStyleHead.setFillForegroundColor(IndexedColors.LIME.getIndex());
////        cellStyleHead.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
////        cellStyleHead.setWrapText(true);//�����Զ�����
////
////        cellStyleHead.setBorderBottom(CellStyle.BORDER_THIN); //�±߿�  
////        cellStyleHead.setBorderLeft(CellStyle.BORDER_THIN);//��߿�   
////        cellStyleHead.setBorderTop(CellStyle.BORDER_THIN);//�ϱ߿�    
////        cellStyleHead.setBorderRight(CellStyle.BORDER_THIN);//�ұ߿�   
////        cellStyleHead.setBottomBorderColor(IndexedColors.BLACK.getIndex());
////        cellStyleHead.setLeftBorderColor(IndexedColors.BLACK.getIndex());
////        cellStyleHead.setTopBorderColor(IndexedColors.BLACK.getIndex());
////        cellStyleHead.setRightBorderColor(IndexedColors.BLACK.getIndex());
////
////        //������һ�У�����
////        Row row = createSheet.createRow(3);
////        String[] cellHead = {"", "","", ""};
////        // �����п�
////        double[] titleWidth = {10, 24, 24, 24};
////        for (int i = 0; i < cellHead.length; i++) {
////            Cell createCell = row.createCell(i);
////            createCell.setCellValue(cellHead[i]);
////            createCell.setCellStyle(cellStyleHead);
////        }
////        
////
////        //������������
////        Font fontData = wb.createFont();
////        fontData.setFontHeightInPoints((short) 14); //�����С
////        fontData.setColor(Font.COLOR_NORMAL); //������ɫ
////        fontData.setFontName("Microsoft Sans Serif"); //����
////        //font.setBoldweight(Font.BOLDWEIGHT_BOLD); //������ʾ
////        //font.setItalic(true); //�Ƿ�ʹ��б��
////        //font.setStrikeout(true); //�Ƿ�ʹ�û���
////
////        //�������ݵ�Ԫ������
////        CellStyle cellStyleDataOdd = wb.createCellStyle();
////        cellStyleDataOdd.setFont(fontData);
////        cellStyleDataOdd.setFillPattern(CellStyle.SOLID_FOREGROUND);
////        cellStyleDataOdd.setAlignment(CellStyle.ALIGN_CENTER); //ˮƽ���֣�����
////        cellStyleDataOdd.setWrapText(true);
////
////        cellStyleDataOdd.setBorderBottom(CellStyle.BORDER_THIN); //�±߿�
////        cellStyleDataOdd.setBorderLeft(CellStyle.BORDER_THIN);//��߿�
////        cellStyleDataOdd.setBorderTop(CellStyle.BORDER_THIN);//�ϱ߿�
////        cellStyleDataOdd.setBorderRight(CellStyle.BORDER_THIN);//�ұ߿�
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
//////                    // ����
//////                    Cell cell1 = row.createCell(j++);
//////                    cell1.setCellValue(ss.optString("xxxxx"));
//////                    cell1.setCellStyle(cellStyleDataOdd);
//////                    // װ�޷�
//////                    Cell cell2 = row.createCell(j++);
//////                    cell2.setCellValue(ss.optString("xxxxx"));
//////                    cell2.setCellStyle(cellStyleDataOdd);
//////                    // ���˷�
//////                    Cell cell7 = row.createCell(j++);
//////                    cell7.setCellValue(ss.optString("xxxxxx"));
//////                    cell7.setCellStyle(cellStyleDataOdd);
//////                    // ��Ա��ѵ��
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
////        // �����п�
////        for (int i = 0; i < titleWidth.length; i++) {
////             createSheet.setColumnWidth((short) i, (short) titleWidth[i] * 256);
////        }
////        
////        // �����������ж���
////        createSheet.createFreezePane( 0, 4, 1, 4); // ǰ������������Ҫ������ֵ����������������������������洰�ڵĿɼ����ޣ����е������������ұ�����ɼ���������������ĸ���������������ɼ�������
////		
////		try {
////		FileOutputStream fos = new FileOutputStream("D:\\test\\newExcel.xls");
////		wb.write(fos);
////		fos.close();
////		//((FileOutputStream) wb).close();
////		System.out.println("д���ݽ�����");
////	} catch (IOException e) {
////		// TODO Auto-generated catch block
////		e.printStackTrace();
////	}	
//	}
//	
//	//��poi�Դ��Ĺ�����������ϲ���ı߿�
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
