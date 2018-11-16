package com.fzc.javatest.xiancheng.waitnotify;

public class Account implements AccountIF{
	private int accountNo;
	private int balance;
	private boolean flag = false;
	
	public Account(int accountNo, int balance) {
		// TODO Auto-generated constructor stub
		this.accountNo = accountNo;
		this.balance = balance;
	}
	
	public synchronized void draw(int amount,int i){
		System.out.println(Thread.currentThread().getName()+i);
		while(!flag){
			try {
				System.out.println(Thread.currentThread().getName()+i+" lalala wo draw wait");
				this.wait();
				System.out.println(Thread.currentThread().getName()+i+" lalala wo draw wait back");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			System.out.println(Thread.currentThread().getName()+i+" get balance:"+amount);
			setBalance(getBalance()-amount);
			System.out.println(Thread.currentThread().getName()+i+" remained balance is "+getBalance());
			flag = false;
			this.notifyAll();
			System.out.println(Thread.currentThread().getName()+i+" lalala wo dtaw notifyAll hai zai");
	}
	
	public synchronized void deposit(int amount,int i){
		System.out.println(Thread.currentThread().getName()+i);
		while(flag){
			try {
				System.out.println(Thread.currentThread().getName()+i+" lalala wo deposit wait");
				this.wait();
				System.out.println(Thread.currentThread().getName()+i+" lalala wo deposit wait back");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
			System.out.println(Thread.currentThread().getName()+i+" add balance:"+amount);
			setBalance(getBalance()+amount);
			System.out.println(Thread.currentThread().getName()+i+" remained balance is "+getBalance());
			flag = true;
			this.notifyAll();

			System.out.println(Thread.currentThread().getName()+i+" lalala wo deposit notifyAll hai zai");
	}

	/**
	 * @return the accountNo
	 */
	public int getAccountNo() {
		return accountNo;
	}

	/**
	 * @param accountNo the accountNo to set
	 */
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	/**
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}
}
