package com.fzc.javatest.xiancheng.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestServiceForTwoCondition {
	public ReentrantLock lock = new ReentrantLock();
	public Condition cona = lock.newCondition();
	public Condition conb = lock.newCondition();
	
	public void awaitA(){
		lock.lock();
		try {
			System.out.println("await A will wait time is "+System.currentTimeMillis());
			cona.await();
			System.out.println("await A is back time is "+System.currentTimeMillis());
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			lock.unlock();
		}
	}
	
	public void awaitB(){
		lock.lock();
		try {
			System.out.println("await B will wait time is "+System.currentTimeMillis());
			conb.await();
			System.out.println("await B is back time is "+System.currentTimeMillis());
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			lock.unlock();
		}
	}
	
	public void signalAllA(){
		lock.lock();
		try {
			System.out.println("signalAll A time is "+System.currentTimeMillis());
			cona.signalAll();
			System.out.println("signalAll A lalala time is "+System.currentTimeMillis());
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			lock.unlock();
		}
	}
	
	public void signalAllB(){
		lock.lock();
		try {
			System.out.println("signalAll B time is "+System.currentTimeMillis());
			conb.signalAll();
			System.out.println("signalAll B lalala time is "+System.currentTimeMillis());
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			lock.unlock();
		}
	}
}
