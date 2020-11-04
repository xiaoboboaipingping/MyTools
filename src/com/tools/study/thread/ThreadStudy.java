package com.tools.study.thread;

public class ThreadStudy extends Thread {
	private int count = 10;
	
	public void run() {
		while(true){
			System.out.println(count+" ");
			if(--count == 0){
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		new ThreadStudy().start();
	}
}
