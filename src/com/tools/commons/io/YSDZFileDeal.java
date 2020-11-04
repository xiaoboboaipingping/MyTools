package com.tools.commons.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class YSDZFileDeal {
	public static void main(String[] args) {
		List<File> files = (List<File>) FileUtils.listFiles(new File("C:\\Users\\xiaobobo\\Desktop\\银联\\银商\\20201027"), null, true);
		List<File> files2 = (List<File>) FileUtils.listFiles(new File("C:\\Users\\xiaobobo\\Desktop\\银联\\银商\\20201027"), null, true);
		String writeFilePath = "C:\\Users\\xiaobobo\\Desktop\\银联\\银商\\20201027\\new\\";
		List<String> fileNames = new ArrayList<>();
		for(File f:files){
			String fileName = f.getName();
			String [] temp = fileName.split("_");
			String jg_code = temp[1];
			boolean flag = false;
			//System.out.println(fileNames);
			for(String fname:fileNames){
				if(fileName.equals(fname)){
					flag = true;
				}
			}
			if(flag){
				continue;
			}
			for(File f2:files2){
				String fileName2 = f2.getName();
				if(fileName.equals(fileName2)){
					continue;
				}else{
					String [] temp2 = fileName2.split("_");
					String jg_code2 = temp2[1];
					if(jg_code.equals(jg_code2)){
						fileNames.add(fileName2);
						File wirteFile = new File(writeFilePath + fileName);
						WriteFiles(f,f2,wirteFile);
					}else{
						continue;
					}
				}
			}
		}
	}
	
	//合并2个文件并生成新文件
	public static void WriteFiles(File f1,File f2,File writeFile){
		try {
			List<String> lines = FileUtils.readLines(f1, "GBK");
			int num = 0;
			String f1head = "";
			String f1body = "";
			String f2head = "";
			String f2body = "";
			String writeHead = "";
			String writeBody = "";
			for(String msg:lines){	
				//System.out.println("f1"+msg);
				if(num == 0){
					f1head = msg;
				}else{
					f1body = f1body + msg+"\r\n";
				}
				num ++;
			}
			num = 0;
			List<String> lines2 = FileUtils.readLines(f2, "GBK");
			for(String msg2:lines2){	
				//System.out.println("f2"+msg2);
				if(num == 0){
					f2head = msg2;
				}else{
					f2body = f2body + msg2+"\r\n";
				}
				num ++;
			}
//			System.out.println(f1head);
//			System.out.println(f2head);
			String [] f1tmp = f1head.split("\\|");
			String [] f2tmp = f2head.split("\\|");
			double totalAmt = Double.parseDouble(f1tmp[2]) + Double.parseDouble(f2tmp[2]);
			long totalNum = Long.parseLong(f1tmp[3]) + Long.parseLong(f2tmp[3]);
			//System.out.println(f1.getName() + "   "+ totalAmt + "    "+totalNum);
			
			writeHead = f1tmp[0] + "|" + f1tmp[1] + "|" + totalAmt + "|" + totalNum;
			writeBody = f1body + f2body;
			System.out.println(f2body);
			FileUtils.write(writeFile, writeHead + "\r\n" +writeBody,"GBK",true); 
			
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
