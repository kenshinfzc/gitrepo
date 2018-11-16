package com.fzc.javatest.xiancheng.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestServiceForReadWriteLock {
	public ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	public void readAwait(){
		lock.readLock().lock();
		try {
			System.out.println("await readLock will wait time is "+System.currentTimeMillis());
			Thread.sleep(1000);
			System.out.println("await readLock is back time is "+System.currentTimeMillis());
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			lock.readLock().unlock();
		}
	}
	
	public void writeAwait(){
		lock.writeLock().lock();
		try {
			System.out.println("await writeLock will wait time is "+System.currentTimeMillis());
			Thread.sleep(1000);
			System.out.println("await writeLock is back time is "+System.currentTimeMillis());
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			lock.writeLock().unlock();
		}
	}
	
}
