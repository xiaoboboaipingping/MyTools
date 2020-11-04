package com.tools.string;

import java.util.Random;

/**
 * 随机获取的一些操作
 * @author wu-haibo
 *
 */
public class RandomUtils {
	
	/**
	 * 获取随机整数
	 */
	public static int getRmInt(){
		Random random = new Random();
		return random.nextInt();
	}
	
	/**
	 * 获取随机整数大于0并且小于10
	 */
	public static int getRmIntZeToTen(){
		Random random = new Random();
		return random.nextInt(10);
	}
	
	/**
	 * 获取随机布尔值
	 */
	public static boolean getRmBoolean(){
		Random random = new Random();
		return random.nextBoolean();
	}
	
	/**
	 * 获取随机双精度值
	 */
	public static double getRmDouble(){
		Random random = new Random();
		return random.nextDouble();
	}
	
	/**
	 * 获取随机浮点值
	 */
	public static float getRmFloat(){
		Random random = new Random();
		return random.nextFloat();
	}	
	
	/**
	 * 获取随机概率密度为高斯分布的双精度值
	 */
	public static Double getRmGaussian(){
		Random random = new Random();
		return random.nextGaussian();
	}	
	
	/**
	 * 根据传入的是大写还是小写返回a--z还是A--Z
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
