package com.fzc.javatest.xiancheng.waitnotify;

public class DrawThread extends Thread {
	private AccountIF acct;
	private int amount;
	public DrawThread(String name, AccountIF acct,int amount) {
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
		for(int i=0;i<20;i++){
			acct.draw(amount,i);
		}
	}
}
