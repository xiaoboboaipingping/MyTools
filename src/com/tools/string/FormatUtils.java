package com.tools.string;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * ��double���ͱ���ת���ɶ�Ӧ��String��ʽ
 * @author Administrator
 *
 */
public class FormatUtils {
	
	/**
	 * ͨ�÷�ʽ
	 * ����1�����1��###,###.###
	 *      ���2��123456.789
	 *      �����123,456.789
	 *      
	 * ����2�����1��00000000.###kg
	 *      ���2��123456.789
	 *      �����00123456.789kg
	 *      
	 * ����3�����1��#.###%
	 *      ���2��0.789
	 *      �����78.9%
	 *      
	 * ����4�����1��###.##
	 *      ���2��123456.789
	 *      �����123456.79
	 *      
	 * ����5�����1��0.00\u2030
	 *      ���2��0.789
	 *      �����789.00��     
	 * @param pattern
	 * @param value
	 * @return
	 */
	public static String formatTools(String pattern,double value){
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		return decimalFormat.format(value);
	}
}
