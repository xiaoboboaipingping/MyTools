package com.tools.string;

import java.math.BigDecimal;

/**
 * ��ȷ����������
 * @author Administrator
 *
 */
public class CalculateUtils {
	
	/**
	 * ��ȷ����ӷ�
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
	 * ��ȷ������� value1 - value2
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
	 * ��ȷ����˷� 
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
	 * ��ȷ���������num�Ǳ�����λС��
	 * @param value1
	 * @param value2
	 * @param num
	 * @return
	 */
	public BigDecimal div(double value1,double value2,int num){
		if(num < 0){
			System.out.println("С��λ������ڵ���0");
			return new BigDecimal("-1");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(value1));
		BigDecimal b2 = new BigDecimal(Double.toString(value2));
		return b1.divide(b2,num,BigDecimal.ROUND_HALF_UP);
	}
}
