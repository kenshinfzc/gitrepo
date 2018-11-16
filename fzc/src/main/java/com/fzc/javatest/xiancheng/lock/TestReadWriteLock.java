package com.fzc.javatest.xiancheng.lock;

public class TestReadWriteLock {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		TestServiceForReadWriteLock service = new TestServiceForReadWriteLock();
//		ThreadA ta = new ThreadA(service);
		ThreadB tb = new ThreadB(service);
		ThreadA tc = new ThreadA(service);
//		ThreadB td = new ThreadB(service);
//		ta.start();
		tb.start();
		tc.start();
//		td.start();
		Thread.sleep(3000);
		
	
	}
	
	static public class ThreadA extends Thread{
		private TestServiceForReadWriteLock service ;
		public ThreadA(TestServiceForReadWriteLock service) {
			// TODO Auto-generated constructor stub
			this.service = service;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			service.readAwait();
		}
	}

	static public class ThreadB extends Thread{
		private TestServiceForReadWriteLock service ;
		public ThreadB(TestServiceForReadWriteLock service) {
			// TODO Auto-generated constructor stub
			this.service = service;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			service.writeAwait();
		}
	}
}
