package com.fzc.javatest.xiancheng.synchronize;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account acct = new Account(111, 500);
		
		/**
		 * 同步代码块   
		 * 需要设置同步监视器对象     调用对象的wait方法时，当前线程会站厅，并释放同步监视器
		 */
//		ATMThread at1 = new ATMThread("zhangsan",acct, 300);
//		at1.start();
//		ATMThread at2 = new ATMThread("lisi",acct, 300);
//		at2.start();
//		ATMThread at3 = new ATMThread("wangwu",acct, 300);
//		at3.start();
		
		/**
		 * 同步方法  
		 * 一般在操作对象中设置     调用对象的wait方法时，当前线程会暂停，并释放同步监视器 
		 * sleep 、yield 方法不会释放同步监视器
		 */
//		ATMThread1 at11 = new ATMThread1("zhangsan1",acct, 300);
//		at11.start();
//		ATMThread1 at21 = new ATMThread1("lisi1",acct, 300);
//		at21.start();
//		ATMThread1 at31 = new ATMThread1("wangwu1",acct, 300);
//		at31.start();
		
		//volatile  并不能替代synchronized
		VolatileAccount vacct = new VolatileAccount(111, 500);
		ATMThreadVolatile at11 = new ATMThreadVolatile("zhangsan1",vacct, 300);
		at11.start();
		ATMThreadVolatile at21 = new ATMThreadVolatile("lisi1",vacct, 300);
		at21.start();
		ATMThreadVolatile at31 = new ATMThreadVolatile("wangwu1",vacct, 300);
		at31.start();
	}
}
