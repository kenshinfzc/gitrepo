package com.fzc.javatest.xiancheng.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadPoolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testThreadPool();
	}

	private static void testThreadPool() {
		// TODO Auto-generated method stub
		ExecutorService es = Executors.newFixedThreadPool(3);
//		es.execute(new Thread(new RunnableThread()));
		es.submit(new CallableThread());
		es.submit(new CallableThread());
		
		Future<Integer> ft = es.submit(new CallableThread());
		try {
			System.out.println("return i = "+ft.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
