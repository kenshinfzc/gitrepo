package com.fzc.javatest.xiancheng;

public class MyThread extends Thread {
	private int count=5;
	/*public MyThread(String name) {
		// TODO Auto-generated constructor stub
		super();
		this.setName(name);
	}*/
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(count>0){
			count--;
			System.out.println(Thread.currentThread().getName()+" 计算，count="+count);
		}
	}
}
