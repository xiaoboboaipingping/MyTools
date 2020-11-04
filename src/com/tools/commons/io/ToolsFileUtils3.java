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

public class ToolsFileUtils3 {
	public static void main(String[] args) throws IOException {

			
		//FileUtils��ȡ�ļ�--------------------
		String filename = "PMTS-F.log";
		File file = new File("C:\\Users\\xiaobobo\\Desktop\\�������\\"+filename);
		try {
			List<String> lines = FileUtils.readLines(file, "GBK");
			String lastMsg = "";
			for(String msg:lines){
					if(msg.contains("20200309134356680")){
						lastMsg = lastMsg + msg+"\r\n";
					}					
				//FileUtils.write(new File("D:\\lntraf\\"+filename+".txt"), ttt,"GBK",true); 
			}
			FileUtils.write(new File("C:\\Users\\xiaobobo\\Desktop\\�������\\test.txt"), lastMsg,"GBK",false); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//FileUtilsд���ļ�--------------------
		//��ʽ1
		//FileUtils.write(new File("D:\\work\\ZFYK1.cfg"), "����api","GBK",true); 
		
		//��ʽ2
		//List<String> lines=new ArrayList<String>();  
		//lines.add("��ӭ����:");
		//lines.add("www.cxyapi.com");  
		//FileUtils.writeLines(new File("D:\\work\\ZFYK1.cfg"),lines,true);  
		
		//��ʽ3
		//FileUtils.writeStringToFile(new File("D:\\work\\ZFYK1.cfg"), "���ߣ�cxy", "GBK",true); 
		
		
		//FileUtilsɾ���ļ����ļ���--------------------
		//��ʽ1
		//FileUtils.deleteDirectory(new File("D:\\test"));//ɾ���ļ���
		
		//��ʽ2
		//FileUtils.deleteQuietly(new File("D:\\test\\ZFYK1.cfg")); //�ļ��в��ǿ���Ȼ���Ա�ɾ������Զ�����׳��쳣
		
		
		//FileUtils�ƶ��ļ�/�ļ���--------------------
		//��ʽ1�ƶ��ļ���
		//FileUtils.moveDirectory(new File("D:\\work\\"), new File("D:\\test\\")); //�൱�ڸ���
		
		//��ʽ2�ƶ��ļ���
		//FileUtils.moveDirectoryToDirectory(new File("D:\\test1\\"), new File("D:\\test2\\"), true); 
		
		//��ʽ3�ƶ��ļ�
		//FileUtils.moveFile(new File("D:\\test1\\ZFYK1.cfg"), new File("D:\\test2\\ZFYK1.cfg")); //�ļ��в����ڻᴴ��
	
		
		//FileUtils�����ļ�/�ļ���--------------------
		//��ʽ1�����ļ���
		//FileUtils.copyDirectory(new File("D:\\test1\\"), new File("D:\\test3\\"));   
		
		//��ʽ2�����ļ��н�test1���Ƶ�test3�ļ�����
		//FileUtils.copyDirectoryToDirectory(new File("D:\\test1\\"), new File("D:\\test3\\"));  
		
		//��ʽ3�����ļ�
		//FileUtils.copyFile(new File("D:\\test1\\ZFYK1.cfg"), new File("D:\\test2\\ZFYK1.cfg"));
		
		//��ʽ4�����ļ�
		//FileUtils.copyFileToDirectory(new File("D:\\test1\\ZFYK1.cfg"), new File("D:\\test3\\")); //�ļ��в����ڻᴴ��
		
		//��ʽ5����url
		//FileUtils.copyURLToFile(new URL("http://www.baidu.com/"), new File("D:\\test1\\ZFYK2.cfg")); 
		
			
		//FileUtils��������--------------------
		//�ж��Ƿ�����ļ������ļ���  
		//boolean b=FileUtils.directoryContains(new File("D:\\test1\\"), new File("D:\\test1\\ZFYK1.cfg"));  
		//System.out.println(b);  
		
		//�����ʱĿ¼ �� �û�Ŀ¼  
		//System.out.println(FileUtils.getTempDirectoryPath());  
		//System.out.println(FileUtils.getUserDirectoryPath());  
		
		//��������������ڴ����ļ�����Ŀ¼�ṹ  
		//�ڶ���������ʾ �ļ����Ƿ���׷�ӷ�ʽ  
		//FileOutputStream fos=FileUtils.openOutputStream(new File("D:\\test1\\ZFYK1.cfg"),true);  
		//fos.write(new String("��ӭ���ʣ�www.cxyapi.com\r\n").getBytes());  
		//fos.close();  
		
		//�ļ� �� �ļ��д�С  
		//System.out.println(FileUtils.sizeOf(new File("D:\\test1\\ZFYK1.cfg")));  
		//System.out.println(FileUtils.sizeOfDirectory(new File("D:\\test1\\")));
		
		//3���쿴ʣ��ռ�  
		//long freeSpace = FileSystemUtils.freeSpace("C:/"); 
		//System.out.println(freeSpace);
	}
}
