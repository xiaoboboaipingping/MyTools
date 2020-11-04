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
	 * ����33ѡ6
	 * author: 
	 * @return
	 */
	private static List<Integer> randomRedBall(){
		int[] redBall = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,
				28,29,30,31,32,33};
		int redRandom = 0;
		List<Integer> retRandomList = new ArrayList<Integer>();
		Random random = new Random();
		//����
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
	 * �н���ʽ��
	 * 1����������ȫ��+1��������  1�Ƚ�
	 * 2����������ȫ��                    2�Ƚ�
	 * 3�����������+1��������      3�Ƚ�
	 * 4�����������                        4�Ƚ�
	 * 5���ĸ�������+1��������      4�Ƚ�
	 * 6���ĸ�������                        5�Ƚ�
	 * 7������������+1��������      5�Ƚ�
	 * 8������������+1��������      6�Ƚ�
	 * 9��һ��������+1��������      6�Ƚ�
	 * 10��һ��������                      6�Ƚ�
	 * 
	 * @param ranList
	 * @param choiceList
	 * @return
	 */
	private static int suanfa(List<Integer> ranList,List<Integer> choiceList,int retBlueBall,int choiceBlueBall){
		int ret = 0;
		Collection c = CollectionUtils.retainAll(ranList, choiceList);
		//������бȽ�
		if(retBlueBall == choiceBlueBall){
			//�����е����
			//������бȽ�
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
			//������бȽ�
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
		
		//��ȡ�������
		List<Integer> retList = randomRedBall();
		//��ȡ�������
		int blueBall = randomBlueBall();
		int cycleNum = 1;
		
		//�������
		List<Integer> choiceList = new ArrayList<Integer>();
		//��������
		int choiceBlueBall = 0;
		
		while(true){
			if(cycleNum > 6){
				break;
			}
			System.out.println("�������"+cycleNum+"����ɫ���룺");
			Scanner scanner = new Scanner(System.in);
			String inNum = scanner.nextLine();
			System.out.println("����ĵ�"+cycleNum+"����ɫ�����ǣ�"+inNum);
			choiceList.add(Integer.parseInt(inNum));
			cycleNum ++;
		}
		
		System.out.println("��������ɫ���룺");
		Scanner scanner = new Scanner(System.in);
		String inNum = scanner.nextLine();
		System.out.println("�������ɫ�����ǣ�"+inNum);
		choiceBlueBall = Integer.parseInt(inNum);
		scanner.close();
				
		int retNum = suanfa(retList,choiceList,blueBall,choiceBlueBall);
		System.out.println("���������ǣ�");
		Collections.sort(retList);
		for(int i=0;i<retList.size();i++){
			System.out.print(retList.get(i)+" ");
		}
		System.out.println(" "+blueBall);
		
		System.out.println("ѡ������ǣ�");
		Collections.sort(choiceList);
		for(int i=0;i<choiceList.size();i++){
			System.out.print(choiceList.get(i)+" ");
		}
		System.out.println(" "+choiceBlueBall);
		
		if(retNum == 0){
			System.out.println("û���н�������ģ�����һ�Σ�");
		}else{
			System.out.println("��ϲ������"+retNum+"�Ƚ�");
		}
	}
}
