package com.tools.commons.lang;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

public class ToolsCommonsLangUtils {
	public static void main(String[] args) {
		//判断是否为null
		//System.out.println(StringUtils.isEmpty(null)); 
		
		//判断是否不是null
		//System.out.println(StringUtils.isNotEmpty(""));
		
		//判断是否是空(如果有空格，会去掉空格判断)或者null
		//System.out.println(StringUtils.isBlank(null));
		
		//判断是否不是空(如果有空格，会去掉空格判断)或者null
		//System.out.println(StringUtils.isNotBlank(""));
		
		//去空格
		//System.out.println(StringUtils.trim("   abc  "));
		
		//去空格，将Null和"" 转换为Null  
        //System.out.println(StringUtils.trimToNull(""));
        
        //去空格，将NULL 和 "" 转换为""  
        //System.out.println(StringUtils.trimToEmpty(null));
		
		//去除特殊字符  \n \t \r\n等
        //System.out.println(StringUtils.strip("大家好  啊  \n"));
		
		//同上，将""和null转换为Null  
        //System.out.println(StringUtils.stripToNull(" 12312312 \t"));
        
        //仅当字符串为Null时 转换为指定的字符串(二参数)  
        //System.out.println(StringUtils.defaultString(null, "df"));
		
		//当字符串为null或者""时，转换为指定的字符串(二参数)  
        //System.out.println(StringUtils.defaultIfEmpty("123", "sos"));
        
		//如果第二个参数为null去空格(否则去掉字符串2边一样的字符，到不一样为止)
        //System.out.println(StringUtils.strip("ffsfsdf", "f"));
		
		//如果第二个参数为null只去前面空格(否则去掉字符串前面一样的字符，到不一样为止)  
		//System.out.println(StringUtils.stripStart("ddsuuu ", "d"));
		
		//如果第二个参数为null只去后面空格，(否则去掉字符串后面一样的字符，到不一样为止)
		//System.out.println(StringUtils.stripEnd("dabads", "das"));
		
		//判断2个字符串是否相等,NULL也相等
		//System.out.println(StringUtils.equals(null, null));  
		
		//判断2个字符串是否相等(忽略大小写)
		//System.out.println(StringUtils.equalsIgnoreCase("abc", "ABc"));  
		
		//普通查找字符，如果一参数为null或者""返回-1
		//System.out.println(StringUtils.indexOf(null, "a"));  
		
		//从指定位置(三参数)开始查找，本例从第2个字符开始查找k字符  
		//System.out.println(StringUtils.indexOf("akfekcd中华", "k", 2));  
		
		//查找，第三个参数是出现第几次，比如说下面的字符串，查找的就是k出现第二次的位置
		//System.out.println(StringUtils.ordinalIndexOf("akfekcd中华", "k", 2));  
		
		//查找不区分大小写
		//System.out.println(StringUtils.indexOfIgnoreCase("adfs", "D"));
		
		//在指定位置查找，不区分大小写
		//System.out.println(StringUtils.indexOfIgnoreCase("adfs", "a", 3));  
		
		//重后往前查找
		//System.out.println(StringUtils.lastIndexOf("adfas", "a")); 
		
		//在指定位置，重后往前查找
		//System.out.println(StringUtils.lastIndexOf("dabasdafs", "a", 7));  
		
		//重后往前查找，第三个参数是出现第几次，比如说下面的字符串，查找的就是f出现第二次的位置
		//System.out.println(StringUtils.lastOrdinalIndexOf("yksdfdht", "f", 1));  
		
		//重后往前查，不区分大小写
		//System.out.println(StringUtils.lastIndexOfIgnoreCase("sdffet", "E"));
		
		//重后往前查，不区分大小写(未解)
		//System.out.println(StringUtils.lastIndexOfIgnoreCase("efefrfs看", "F" , 2));  
		
		//是否包含，参数1是否包含参数2
		//System.out.println(StringUtils.contains("sdf", "df"));
		
		//是否包含(不区分大小写)，参数1是否包含参数2
		//System.out.println(StringUtils.containsIgnoreCase("sdf", "D")); 
		
		//是否包含空格(有问题)
		//System.out.println(StringUtils.containsWhitespace(" d"));
	
		//查询字符串跟数组任一元素相同的第一次相同的位置
		//System.out.println(StringUtils.indexOfAny("absfekf", new String[]{"f", "b"}));  
		
		//定义原数组
//		String array[] = new String[]{" 中华 ", "民 国", "国共和国"};
//		System.out.println("原数组是：");
//		for(int i=0;i<array.length;i++){
//	    	System.out.println("["+array[i]+"]");
//	    }
		
		//数组去掉所有空格
//	    String retArray[] = StringUtils.stripAll(array); 
//	    System.out.println("转换后的数组是：");
//	    for(int i=0;i<retArray.length;i++){
//	    	System.out.println("["+retArray[i]+"]");
//	    }
	    
		//如果第二个参数为null.对数组每个字符串进行去空格。(否则去掉数组每个元素开始和结尾一样的字符) 
//	    String retArray[] = StringUtils.stripAll(array,"国"); 
//	    System.out.println("转换后的数组是：");
//	    for(int i=0;i<retArray.length;i++){
//	    	System.out.println("["+retArray[i]+"]");
//	    }	
		/**
         * count 创建一个随机字符串，其长度是指定的字符数,字符将从参数的字母数字字符集中选择，如参数所示。
         * letters true,生成的字符串可以包括字母字符
         * numbers true,生成的字符串可以包含数字字符
         */
//		String random = RandomStringUtils.random(5,true, false);
//		System.out.println(random);
		
		/**
         * 创建一个随机字符串，其长度是指定的字符数。
         * 将从所有字符集中选择字符
         */
//		String random = RandomStringUtils.random(22);
//        System.out.println(random);
		
		/**
         * 创建一个随机字符串，其长度是指定的字符数。
         * 字符将从字符串指定的字符集中选择，不能为空。如果NULL，则使用所有字符集。
         */
		String random = RandomStringUtils.random(15, "abcdefgABCDEFG123456789");
        System.out.println(random);
		
	}
}
