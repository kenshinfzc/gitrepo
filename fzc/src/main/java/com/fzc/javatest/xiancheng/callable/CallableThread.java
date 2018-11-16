package com.fzc.javatest.xiancheng.callable;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int i = 0;
		for(;i<50;i++){
			System.out.println(Thread.currentThread().getName()+"----"+i);
		}
		return i;
	}

}
