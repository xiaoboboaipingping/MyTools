package com.tools.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test2 {
	private final Date start;
	private final Date end;
	
	public Test2(Date start,Date end){
		if(start.compareTo(end) >0)
			throw new IllegalArgumentException(start+"after "+end);
		this.start = new Date(start.getTime());
		this.end =  new Date(end.getTime());
	}
	
	public Date start(){
		return start;
	}
	
	public Date end(){
		return end;
	}
	
	public static void main(String[] args) {
		int a = 1;
		System.out.println(a%200);
	}
}
