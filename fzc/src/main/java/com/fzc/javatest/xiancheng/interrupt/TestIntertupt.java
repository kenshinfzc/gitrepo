package com.fzc.javatest.xiancheng.interrupt;

public class TestIntertupt {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		TestThread tt = new TestThread();
		tt.start();
		Thread.sleep(1);
		System.out.println("TestThread state1 ="+tt.getState()+" time = "+System.currentTimeMillis());
		tt.interrupt();
		System.out.println("TestThread state2 ="+tt.getState()+" time = "+System.currentTimeMillis());
		Thread.sleep(10);
		System.out.println("TestThread state3 ="+tt.getState()+" time = "+System.currentTimeMillis());
	}
	
	static public class TestThread extends Thread {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while(!isInterrupted()){
					System.out.println("TestThread begin state ="+this.getState()+" time = "+System.currentTimeMillis());
					Thread.sleep(10000);
					System.out.println("TestThread end state ="+this.getState()+" time = "+System.currentTimeMillis());
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
