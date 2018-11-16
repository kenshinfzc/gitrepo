package com.fzc.javatest.xiancheng.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ShutDownAndTerminatedTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
		service.submit(new ShortTask());
		service.submit(new ShortTask());
		service.submit(new LongTask());
		service.submit(new ShortTask());
		System.out.println("isShutdown:" + service.isShutdown()+",time = "+System.currentTimeMillis());
		System.out.println("isTerminated:" + service.isTerminated()+",time = "+System.currentTimeMillis());
		service.shutdown();
		// List<Runnable> list = service.shutdownNow();
		// System.out.println(list.size());
		System.out.println("isShutdown:" + service.isShutdown()+",time = "+System.currentTimeMillis());
		System.out.println("isTerminated:" + service.isTerminated()+",time = "+System.currentTimeMillis());

		try {
			if(!service.awaitTermination(1, TimeUnit.SECONDS)){
				service.shutdownNow();
				System.out.println("isShutdown:" + service.isShutdown()+",time = "+System.currentTimeMillis());
				System.out.println("isTerminated:" + service.isTerminated()+",time = "+System.currentTimeMillis());
			}
			
			/*while (!service.awaitTermination(1, TimeUnit.SECONDS)) {
				System.out.println("线程池没有关闭"+",time = "+System.currentTimeMillis());
				System.out.println("isTerminated:" + service.isTerminated()+",time = "+System.currentTimeMillis());
			}*/
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("线程池已经关闭");
		System.out.println("isTerminated:" + service.isTerminated()+",time = "+System.currentTimeMillis());

	}

	static public class ShortTask implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("short task begin time = "+System.currentTimeMillis());
		}
	}

	static public class LongTask implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				System.out.println("long task begin time = "+System.currentTimeMillis());
				Thread.sleep(4000);
				System.out.println("long task end time = "+System.currentTimeMillis());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
