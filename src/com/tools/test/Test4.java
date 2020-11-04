package com.tools.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import com.tools.study.dom4j.Dom4jUtils;


public class Test4 {
	private static List<String> listMapsaa = new ArrayList<String>();
	private static List<String> listMapsss = new ArrayList<String>();
	
	public static void main(String[] args) {
//		String path = "D:/QQQ/trades";
//		System.out.println("开始执行");
//		try {
//			searchFiles(path);
//			findStringInFile();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("执行结束");
//        char a = '吴';
//        if(a<127){
//       	 System.out.println("非法字符");
//        }
//		String x = "123456\t\r\n456";
//		System.out.println("原字符串："+x);
//		char xArray[] = x.toCharArray();
//		String x1 = "";
//		for (int i=0;i<xArray.length;i++){
//			if(xArray[i] != '\t' && xArray[i] !='\r' && xArray[i] !='\n'){
//				x1 += xArray[i];
//			}
//			//System.out.println(xArray[i]);
//		}
//		System.out.println("新字符串："+x1);
		
		//Dom4jUtils dom4jUtils = new Dom4jUtils();
//		String aa = Dom4jUtils.test();
//		System.out.println(aa);
		
//	    String str = "测试字符转换 a beautiful girl"; //默认环境，已是UTF-8编码  
//	    try {  
//	        String strGBK = URLEncoder.encode(str, "GBK");  
//	        System.out.println(strGBK);  
//	        String strUTF8 = URLDecoder.decode(str, "UTF-8");  
//	        System.out.println(strUTF8);  
//	    } catch (UnsupportedEncodingException e) {  
//	        e.printStackTrace();  
//	    }  

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        DateFormat format1 = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        String str = "20190101";
        try {
			date = format1.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        String stringDate = sdf.format(date);//date-->String
        
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        for(int i =0;i<309;i++){
        	if(i == 0){
        		calendar.add(Calendar.DAY_OF_MONTH, 0); //把日期往后增加一天
        	}else{
        		calendar.add(Calendar.DAY_OF_MONTH, 1); //把日期往后增加一天
        	}
            date = calendar.getTime();
            stringDate = sdf.format(date);//date-->String
            System.out.println(stringDate);        	
        }


	}
	
	
	public static void searchFiles(String root_path) throws Exception {
	    File root_file = new File(root_path);
	    if (root_file.exists()) {
	        File[] files = root_file.listFiles();//当前文件夹下所有文件和文件夹名
	        if (files.length == 0) {
	            System.out.println("文件夹是空的!");
	            return;
	        } 
	        else {
	            for (File file : files) {
	                //判断是文件夹还是文件
	                if (file.isDirectory()) {
	                    //System.out.println("文件夹:" + file.getAbsolutePath());
	                    searchFiles(file.getAbsolutePath());
	                } 
	                //找到java文件，或文件file.isFile()
	                else if (file.toString().endsWith("java")) {
	                	//System.out.println("文件:" + file.getAbsolutePath());
	                    listMapsaa.add(file.getAbsolutePath());
	                }
	            }
	        }
	       
	    } 
	    else {
	        System.out.println("文件不存在!");
	    }  
	}
	
	public static void findStringInFile() throws Exception{  
		List<Map<String, String>> listMap = new ArrayList<Map<String,String>>();
  		listMap = DataBase.query("select * from test");
  		if(listMap!=null&&listMap.size()>0){ 
  			for (int i = 0; i < listMap.size(); i++) { 		
  				label:
  				for (int j = 0; j < listMapsaa.size(); j++) {
  				String test = listMap.get(i).get("TRXNO"); 
  				File file = new File((String)listMapsaa.get(j));  
  		      	InputStreamReader read = new InputStreamReader(new FileInputStream(file),"UTF-8");//考虑到编码格式  
  		      	BufferedReader bufferedReader = new BufferedReader(read);  
  		     	String line = null;  
  		      while ((line = bufferedReader.readLine()) != null) {  
  		    	if (line.contains(test.trim())) { 
  		    		listMapsss.add(test.trim());
  		    		break label;  
  		    	}
  	             }    
  				}
  			}
      }
  		System.out.println(listMapsss.toString()); 
  		System.out.println("----end----------");
	}
}
