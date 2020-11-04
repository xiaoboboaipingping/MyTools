package com.tools.commons.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;

public class ToolsFileUtils4 {
	public static void main(String[] args) throws IOException {

			
		//FileUtils读取文件--------------------
//		String filename = "JSL000220200618.DZ";
//		File file = new File("C:\\Users\\xiaobobo\\Desktop\\银联\\20200618\\"+filename);
//		try {
//			List<String> lines = FileUtils.readLines(file, "GBK");
//			int rowNum = 0;
//			for(String msg:lines){
//				//System.out.println(msg);
//				if(rowNum == 0){
//					System.out.println(msg);
//					rowNum ++;
//					continue;
//				}
//				
//				String [] msgNs = msg.split(";");
//				for(int i = 0;i<msgNs.length;i++){
//					String msgN = msgNs[i];
//					if(i == 0){
//						msgN = msgN.substring(75,msgN.length());
//						System.out.println(msgN);
//					}else{
//						System.out.println(msgN);
//					}
//					
//				}
//				
//				rowNum ++;
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		//FileUtils写入文件--------------------
		//方式1
		//FileUtils.write(new File("D:\\work\\ZFYK1.cfg"), "程序换api","GBK",true); 
		
		//方式2
		//List<String> lines=new ArrayList<String>();  
		//lines.add("欢迎访问:");
		//lines.add("www.cxyapi.com");  
		//FileUtils.writeLines(new File("D:\\work\\ZFYK1.cfg"),lines,true);  
		
		//方式3
		//FileUtils.writeStringToFile(new File("D:\\work\\ZFYK1.cfg"), "作者：cxy", "GBK",true); 
		
		
		//FileUtils删除文件或文件夹--------------------
		//方式1
		//FileUtils.deleteDirectory(new File("D:\\test"));//删除文件夹
		
		//方式2
		//FileUtils.deleteQuietly(new File("D:\\test\\ZFYK1.cfg")); //文件夹不是空任然可以被删除，永远不会抛出异常
		
		
		//FileUtils移动文件/文件夹--------------------
		//方式1移动文件夹
		//FileUtils.moveDirectory(new File("D:\\work\\"), new File("D:\\test\\")); //相当于改名
		
		//方式2移动文件夹
		//FileUtils.moveDirectoryToDirectory(new File("D:\\test1\\"), new File("D:\\test2\\"), true); 
		
		//方式3移动文件
		//FileUtils.moveFile(new File("D:\\test1\\ZFYK1.cfg"), new File("D:\\test2\\ZFYK1.cfg")); //文件夹不存在会创建
	
		
		//FileUtils复制文件/文件夹--------------------
		//方式1复制文件夹
		//FileUtils.copyDirectory(new File("D:\\test1\\"), new File("D:\\test3\\"));   
		
		//方式2复制文件夹将test1复制到test3文件夹下
		//FileUtils.copyDirectoryToDirectory(new File("D:\\test1\\"), new File("D:\\test3\\"));  
		
		//方式3复制文件
		//FileUtils.copyFile(new File("D:\\test1\\ZFYK1.cfg"), new File("D:\\test2\\ZFYK1.cfg"));
		
		//方式4复制文件
		//FileUtils.copyFileToDirectory(new File("D:\\test1\\ZFYK1.cfg"), new File("D:\\test3\\")); //文件夹不存在会创建
		
		//方式5复制url
		//FileUtils.copyURLToFile(new URL("http://www.baidu.com/"), new File("D:\\test1\\ZFYK2.cfg")); 
		
			
		//FileUtils其他操作--------------------
		//判断是否包含文件或者文件夹  
//		boolean b=FileUtils.directoryContains(new File("D:\\test\\"), new File("D:\\test\\123.txt"));  
//		System.out.println(b);  
		
		//获得临时目录 和 用户目录  
		//System.out.println(FileUtils.getTempDirectoryPath());  
		//System.out.println(FileUtils.getUserDirectoryPath());  
		
		//打开流，如果不存在创建文件及其目录结构  
		//第二个参数表示 文件流是否是追加方式  
		//FileOutputStream fos=FileUtils.openOutputStream(new File("D:\\test1\\ZFYK1.cfg"),true);  
		//fos.write(new String("欢迎访问：www.cxyapi.com\r\n").getBytes());  
		//fos.close();  
		
		//文件 或 文件夹大小  
		//System.out.println(FileUtils.sizeOf(new File("D:\\test1\\ZFYK1.cfg")));  
		//System.out.println(FileUtils.sizeOfDirectory(new File("D:\\test1\\")));
		
		//3．察看剩余空间  
		//long freeSpace = FileSystemUtils.freeSpace("C:/"); 
		//System.out.println(freeSpace);
	}
}
