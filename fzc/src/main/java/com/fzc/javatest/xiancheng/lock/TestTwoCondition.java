package com.fzc.javatest.xiancheng.lock;

public class TestTwoCondition {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		TestServiceForTwoCondition service = new TestServiceForTwoCondition();
		ThreadA ta = new ThreadA(service);
		ThreadB tb = new ThreadB(service);
		ta.start();
		tb.start();
		Thread.sleep(3000);
		System.out.println(service.lock.getHoldCount());
		service.signalAllA();
		
	
	}
	
	static public class ThreadA extends Thread{
		private TestServiceForTwoCondition service ;
		public ThreadA(TestServiceForTwoCondition service) {
			// TODO Auto-generated constructor stub
			this.service = service;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			service.awaitA();
		}
	}

	static public class ThreadB extends Thread{
		private TestServiceForTwoCondition service ;
		public ThreadB(TestServiceForTwoCondition service) {
			// TODO Auto-generated constructor stub
			this.service = service;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			service.awaitB();
		}
	}
}
