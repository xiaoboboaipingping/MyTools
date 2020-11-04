package com.tools.string;

import java.math.BigDecimal;

/**
 * 精确的四则运算
 * @author Administrator
 *
 */
public class CalculateUtils {
	
	/**
	 * 精确计算加法
	 * @param value1
	 * @param value2
	 * @return
	 */
	public static BigDecimal add(double value1,double value2){
		BigDecimal b1 = new BigDecimal(Double.toString(value1));
		BigDecimal b2 = new BigDecimal(Double.toString(value2));
		return b1.add(b2);
	}
	
	/**
	 * 精确计算减法 value1 - value2
	 * @param value1
	 * @param value2
	 * @return
	 */
	public BigDecimal sub(double value1,double value2){
		BigDecimal b1 = new BigDecimal(Double.toString(value1));
		BigDecimal b2 = new BigDecimal(Double.toString(value2));
		return b1.subtract(b2);
	}
	
	/**
	 * 精确计算乘法 
	 * @param value1
	 * @param value2
	 * @return
	 */
	public static BigDecimal mul(double value1,double value2){
		BigDecimal b1 = new BigDecimal(Double.toString(value1));
		BigDecimal b2 = new BigDecimal(Double.toString(value2));
		return b1.multiply(b2);
	}
	/**
	 * 精确计算除法，num是保留几位小数
	 * @param value1
	 * @param value2
	 * @param num
	 * @return
	 */
	public BigDecimal div(double value1,double value2,int num){
		if(num < 0){
			System.out.println("小数位必须大于等于0");
			return new BigDecimal("-1");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(value1));
		BigDecimal b2 = new BigDecimal(Double.toString(value2));
		return b1.divide(b2,num,BigDecimal.ROUND_HALF_UP);
	}
}
