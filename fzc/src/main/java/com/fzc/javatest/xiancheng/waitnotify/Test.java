package com.fzc.javatest.xiancheng.waitnotify;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		testWaitNotify();
		
		testLock();
		
	}
	//	wait()会立即释放锁
	//	notify()、notifyAll() 会执行完同步块里面的代码，才会释放锁
	private static void testWaitNotify() {
		// TODO Auto-generated method stub
		AccountIF acct = new Account(111, 0);
		DrawThread dt = new DrawThread("draw zhangsan",acct, 300);
		dt.start();
		DrawThread dt4 = new DrawThread("draw mazi",acct, 300);
		dt4.start();
		DepositThread dt2 = new DepositThread("deposit lisi",acct, 300);
//		dt2.setPriority(Thread.MAX_PRIORITY);
		dt2.start();
		DepositThread dt3 = new DepositThread("deposit wangwu",acct, 300);
//		dt3.setPriority(Thread.MIN_PRIORITY);
		dt3.start();
	}

	private static void testLock() {
		// TODO Auto-generated method stub
		AccountIF acct = new LockAccount(111, 0);
		DrawThread dt = new DrawThread("draw zhangsan",acct, 300);
		dt.start();
		DrawThread dt4 = new DrawThread("draw mazi",acct, 300);
		dt4.start();
		DepositThread dt2 = new DepositThread("deposit lisi",acct, 300);
		dt2.setPriority(Thread.MAX_PRIORITY);
		dt2.start();
		DepositThread dt3 = new DepositThread("deposit wangwu",acct, 300);
		dt3.setPriority(Thread.MIN_PRIORITY);
		dt3.start();
	}
}
