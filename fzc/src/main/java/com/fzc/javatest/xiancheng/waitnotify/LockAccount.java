package com.fzc.javatest.xiancheng.waitnotify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAccount implements AccountIF{
	private final Lock lock = new ReentrantLock();
	private final Condition con = lock.newCondition();
	private int accountNo;
	private int balance;
	private boolean flag = false;
	
	public LockAccount(int accountNo, int balance) {
		// TODO Auto-generated constructor stub
		this.accountNo = accountNo;
		this.balance = balance;
	}
	
	public void draw(int amount,int i){
		lock.lock();
		try {
//			System.out.println(Thread.currentThread().getName()+i);
			while(!flag){
				con.await();
			}
				System.out.println(Thread.currentThread().getName()+" get balance:"+amount);
				setBalance(getBalance()-amount);
				System.out.println(Thread.currentThread().getName()+" remained balance is "+getBalance());
				flag = false;
				con.signalAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void deposit(int amount,int i){
		lock.lock();
		try {
//			System.out.println(Thread.currentThread().getName()+i);
			while(flag){
				con.await();
			}
				System.out.println(Thread.currentThread().getName()+" add balance:"+amount);
				setBalance(getBalance()+amount);
				System.out.println(Thread.currentThread().getName()+" remained balance is "+getBalance());
				flag = true;
				con.signalAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			lock.unlock();
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
