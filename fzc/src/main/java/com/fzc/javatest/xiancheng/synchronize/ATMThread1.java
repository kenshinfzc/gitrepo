package com.fzc.javatest.xiancheng.synchronize;

public class ATMThread1 extends Thread {
	private Account acct;
	private int amount;
	public ATMThread1(String name, Account acct,int amount) {
		// TODO Auto-generated constructor stub
		super(name);
		this.acct = acct;
		this.amount = amount;
	}
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		acct.draw(amount);
	}
}
