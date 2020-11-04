package com.tools.commons.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;

public class ToolsFileUtils {
	public static void main(String[] args) throws IOException {

			
		//FileUtils读取文件--------------------
//		String filename = "menu.xml";
//		File file = new File("D:\\test\\"+filename);
//		try {
//			List<String> lines = FileUtils.readLines(file, "UTF-8");
//			//int i = 1;
//			//System.out.println("SELECT * FROM xip_tradeinfo WHERE XIP_TRADCODE IN (");
//			for(String msg:lines){
//				//System.out.println(msg);
//				//if(msg.contains("item")){
//					//String xx[] = msg.split(" ");
//					
//					System.out.println(msg);
//					//i ++;
//				//}
//				//FileUtils.write(new File("D:\\lntraf\\"+filename+".txt"), ttt,"GBK",true); 
//			}
//				//System.out.println(")");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		File dir = new File("C:\\Users\\xiaobobo\\Desktop\\代理非银支付机构征收社保费业务需求");
//		List<File> fileList = (List<File>) FileUtils.listFiles(dir, null, false);
//		for(File f:fileList){
//			System.out.println(f.getName());
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
		//boolean b=FileUtils.directoryContains(new File("D:\\test1\\"), new File("D:\\test1\\ZFYK1.cfg"));  
		//System.out.println(b);  
		
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
		
		//默认只遍历下一层非空文件，即第二个参数EmptyFileFilter.NOT_EMPTY,为第三个参数为null
	    Collection<File> files= FileUtils.listFiles(new File("D:/test/work"), FileFilterUtils.suffixFileFilter("cfg"), null);
	    for(File file:files)
	    {
	        //System.out.println(file.getName());
	    	System.out.println(file.getAbsolutePath()); //全路径
	    }
	}
}
