package com.fzc.javatest.xiancheng.threadpool;

public class RunnableThread implements Runnable {
	private int i ;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(i=0;i<50;i++){
			System.out.println(Thread.currentThread().getName()+"  "+i);
		}
	}

}
