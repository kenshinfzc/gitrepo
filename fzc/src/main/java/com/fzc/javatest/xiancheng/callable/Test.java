package com.fzc.javatest.xiancheng.callable;

import java.util.concurrent.FutureTask;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CallableThread ct = new CallableThread();
		FutureTask<Integer> ft = new FutureTask<Integer>(ct);
		for(int i=0;i<50;i++){
			System.out.println(Thread.currentThread().getName()+"---"+i);
			if(i==20){
				new Thread(ft).start();
			}
		}
		try {
			System.out.println("返回值："+ft.get());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
