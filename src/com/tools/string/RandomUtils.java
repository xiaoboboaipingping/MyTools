package com.tools.string;

import java.util.Random;

/**
 * �����ȡ��һЩ����
 * @author wu-haibo
 *
 */
public class RandomUtils {
	
	/**
	 * ��ȡ�������
	 */
	public static int getRmInt(){
		Random random = new Random();
		return random.nextInt();
	}
	
	/**
	 * ��ȡ�����������0����С��10
	 */
	public static int getRmIntZeToTen(){
		Random random = new Random();
		return random.nextInt(10);
	}
	
	/**
	 * ��ȡ�������ֵ
	 */
	public static boolean getRmBoolean(){
		Random random = new Random();
		return random.nextBoolean();
	}
	
	/**
	 * ��ȡ���˫����ֵ
	 */
	public static double getRmDouble(){
		Random random = new Random();
		return random.nextDouble();
	}
	
	/**
	 * ��ȡ�������ֵ
	 */
	public static float getRmFloat(){
		Random random = new Random();
		return random.nextFloat();
	}	
	
	/**
	 * ��ȡ��������ܶ�Ϊ��˹�ֲ���˫����ֵ
	 */
	public static Double getRmGaussian(){
		Random random = new Random();
		return random.nextGaussian();
	}	
	
	/**
	 * ���ݴ�����Ǵ�д����Сд����a--z����A--Z
	 * @param uppOrLow
	 * @return
	 */
	public static char getRandomChar(String uppOrLow){
		if("a".equals(uppOrLow)){
			return (char)('a' + Math.random()*('z'-'a'+1));
		}else if("A".equals(uppOrLow)){
			return (char)('A' + Math.random()*('Z'-'A'+1));
		}else{
			return ' ';
		}
	}
}
