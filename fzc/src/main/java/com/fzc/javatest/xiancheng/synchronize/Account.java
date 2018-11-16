package com.fzc.javatest.xiancheng.synchronize;

public class Account {
	private int accountNo;
	private int balance;
	
	public Account(int accountNo, int balance) {
		// TODO Auto-generated constructor stub
		this.accountNo = accountNo;
		this.balance = balance;
	}
	
	public synchronized void draw(int amount){
		if(getBalance()>amount){
			System.out.println(Thread.currentThread().getName()+" get balance:"+amount);
			try {
				Thread.sleep(1);
//				this.wait(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(Thread.currentThread().getName()+" get control again");
			setBalance(getBalance()-amount);
			System.out.println(Thread.currentThread().getName()+" remained balance is "+getBalance());
		}else{
			System.out.println(Thread.currentThread().getName()+" there is no enough balance!");
		}
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
