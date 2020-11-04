package com.tools.string;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换的一些函数
 * @author Administrator
 *
 */
public class DateUtils {
	
	public static String dateFormat(String time){
		Date d = new Date(time);
		Format format = new SimpleDateFormat("yyyyMMdd");
		String dateString = format.format(d);
		return dateString;
	} 
	
	public static void main(String[] args) {
		String dateRet = dateFormat("2018-06-25 12:00:00");
		System.out.println(dateRet);
	}
}
