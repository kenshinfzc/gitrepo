package com.fzc.javatest.xiancheng.synchronize;

public class ATMThread extends Thread {
	private Account acct;
	private int amount;
	public ATMThread(String name, Account acct,int amount) {
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
		synchronized (acct) {
			if(acct.getBalance()>amount){
				System.out.println(Thread.currentThread().getName()+" get balance:"+amount);
				try {
					Thread.sleep(1);
//					acct.wait(1);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println(Thread.currentThread().getName()+" get control again");
				acct.setBalance(acct.getBalance()-amount);
				System.out.println(Thread.currentThread().getName()+" remained balance is "+acct.getBalance());
			}else{
				System.out.println(Thread.currentThread().getName()+" there is no enough balance!");
			}
		}
	}
}
