package com.tools.zip;

import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
	public static void main(String[] args) {
//		String src_file = "D:\\test\\SS01E012H101330201001501073942016071105152318.xml";
//		String dst_file = "D:\\test\\230000E012H1013302010015010739420180123140917.zip";
//		String encode = "230000E012H1013302010015010739420180123140917";
//		ZipUtils.encrypt_zip(src_file, dst_file, encode);
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");  
		System.out.println(formatter.format(date)); 
	}
}
