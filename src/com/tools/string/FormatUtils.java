package com.tools.string;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 将double类型变量转换成对应的String格式
 * @author Administrator
 *
 */
public class FormatUtils {
	
	/**
	 * 通用方式
	 * 例子1：入参1：###,###.###
	 *      入参2：123456.789
	 *      输出：123,456.789
	 *      
	 * 例子2：入参1：00000000.###kg
	 *      入参2：123456.789
	 *      输出：00123456.789kg
	 *      
	 * 例子3：入参1：#.###%
	 *      入参2：0.789
	 *      输出：78.9%
	 *      
	 * 例子4：入参1：###.##
	 *      入参2：123456.789
	 *      输出：123456.79
	 *      
	 * 例子5：入参1：0.00\u2030
	 *      入参2：0.789
	 *      输出：789.00‰     
	 * @param pattern
	 * @param value
	 * @return
	 */
	public static String formatTools(String pattern,double value){
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		return decimalFormat.format(value);
	}
}
