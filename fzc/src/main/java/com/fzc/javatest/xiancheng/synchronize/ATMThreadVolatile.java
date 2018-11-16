package com.fzc.javatest.xiancheng.synchronize;

public class ATMThreadVolatile extends Thread {
	private VolatileAccount acct;
	private int amount;
	public ATMThreadVolatile(String name, VolatileAccount acct,int amount) {
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
