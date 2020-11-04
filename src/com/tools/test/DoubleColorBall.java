package com.tools.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.collections.CollectionUtils;

public class DoubleColorBall {
	/**
	 * 红球：33选6
	 * author: 
	 * @return
	 */
	private static List<Integer> randomRedBall(){
		int[] redBall = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,
				28,29,30,31,32,33};
		int redRandom = 0;
		List<Integer> retRandomList = new ArrayList<Integer>();
		Random random = new Random();
		//红球
		for(int i=0;i<6;i++){
			redRandom = random.nextInt(redBall.length+1-i);
			retRandomList.add(redBall[redRandom]);
			int middleNum = redBall[redBall.length-i-1];
			redBall[redBall.length-1-i] = redBall[redRandom];
			redBall[redRandom] = middleNum;
		}
		
		return retRandomList;
	}
	
	private static int randomBlueBall(){
		int[] blueBall = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		Random random = new Random();
		int blueRandom = random.nextInt(blueBall.length+1);
		return blueRandom;
	}
	
	
	/**
	 * 中奖方式：
	 * 1、六个红球全中+1个蓝球中  1等奖
	 * 2、六个红球全中                    2等奖
	 * 3、五个红球中+1个蓝球中      3等奖
	 * 4、五个红球中                        4等奖
	 * 5、四个红球中+1个蓝球中      4等奖
	 * 6、四个红球中                        5等奖
	 * 7、三个红球中+1个蓝球中      5等奖
	 * 8、两个红球中+1个蓝球中      6等奖
	 * 9、一个红球中+1个蓝球中      6等奖
	 * 10、一个蓝球中                      6等奖
	 * 
	 * @param ranList
	 * @param choiceList
	 * @return
	 */
	private static int suanfa(List<Integer> ranList,List<Integer> choiceList,int retBlueBall,int choiceBlueBall){
		int ret = 0;
		Collection c = CollectionUtils.retainAll(ranList, choiceList);
		//蓝球进行比较
		if(retBlueBall == choiceBlueBall){
			//蓝球中的情况
			//红球进行比较
			switch(c.size()){
			case 0:
				ret = 6;
				break;
			case 1:
				ret = 6;
				break;
			case 2:
				ret = 6;
				break;
			case 3:
				ret = 5;
				break;
			case 4:
				ret = 4;
				break;
			case 5:
				ret = 3;
				break;
			case 6:
				ret = 1;
				break;
			}	
		}else{
			//红球进行比较
			switch(c.size()){
			case 0:
				ret = 0;
				break;
			case 1:
				ret = 0;
				break;
			case 2:
				ret = 0;
				break;
			case 3:
				ret = 0;
				break;
			case 4:
				ret = 5;
				break;
			case 5:
				ret = 4;
				break;
			case 6:
				ret = 2;
				break;
			}
		}

		return ret;
	}
	
	public static void main(String[] args) {
		
		//获取结果红球
		List<Integer> retList = randomRedBall();
		//获取结果蓝球
		int blueBall = randomBlueBall();
		int cycleNum = 1;
		
		//输入红球
		List<Integer> choiceList = new ArrayList<Integer>();
		//输入蓝球
		int choiceBlueBall = 0;
		
		while(true){
			if(cycleNum > 6){
				break;
			}
			System.out.println("请输入第"+cycleNum+"个红色号码：");
			Scanner scanner = new Scanner(System.in);
			String inNum = scanner.nextLine();
			System.out.println("输入的第"+cycleNum+"个红色号码是："+inNum);
			choiceList.add(Integer.parseInt(inNum));
			cycleNum ++;
		}
		
		System.out.println("请输入蓝色号码：");
		Scanner scanner = new Scanner(System.in);
		String inNum = scanner.nextLine();
		System.out.println("输入的蓝色号码是："+inNum);
		choiceBlueBall = Integer.parseInt(inNum);
		scanner.close();
				
		int retNum = suanfa(retList,choiceList,blueBall,choiceBlueBall);
		System.out.println("开奖号码是：");
		Collections.sort(retList);
		for(int i=0;i<retList.size();i++){
			System.out.print(retList.get(i)+" ");
		}
		System.out.println(" "+blueBall);
		
		System.out.println("选择号码是：");
		Collections.sort(choiceList);
		for(int i=0;i<choiceList.size();i++){
			System.out.print(choiceList.get(i)+" ");
		}
		System.out.println(" "+choiceBlueBall);
		
		if(retNum == 0){
			System.out.println("没有中奖，别灰心，在来一次！");
		}else{
			System.out.println("恭喜您中了"+retNum+"等奖");
		}
	}
}
