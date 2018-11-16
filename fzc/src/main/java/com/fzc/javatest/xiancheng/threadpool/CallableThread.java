package com.fzc.javatest.xiancheng.threadpool;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<Integer>{
	private int i ;
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		for(;i<50;i++){
			System.out.println(Thread.currentThread().getName()+"----"+i);
		}
		return i;
	}
}
