package com.tools.study.reflect;

public class Example_01 {
	String s;
	int i,i2,i3;
	private Example_01(){
		this.i = 5;
		this.i2 = 6;
		this.i3 = 7;
		this.s = "�Ҳ٣���Ȼ��ʵ�����ң���";
	}
	protected Example_01(String s,int i){
		this.s = s;
		this.i = i;
	}
	public Example_01(String ...strings) throws NumberFormatException{
		if(0<strings.length){
			i = Integer.valueOf(strings[0]);
		}
		if(1<strings.length){
			i2 = Integer.valueOf(strings[1]);
		}
		if(2<strings.length){
			i3 = Integer.valueOf(strings[2]);
		}
	}
	public void print(){
		System.out.println("s="+s);
		System.out.println("i="+i);
		System.out.println("i2="+i2);
		System.out.println("i3="+i3);
	}
}
