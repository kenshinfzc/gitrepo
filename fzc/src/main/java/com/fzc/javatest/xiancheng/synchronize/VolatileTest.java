package com.fzc.javatest.xiancheng.synchronize;

import java.util.concurrent.atomic.AtomicInteger;

/*
 volatile 可以实现内存可见性，强制不进行指令重排序，但是不能实现操作的原子性
 */
public class VolatileTest {

	public static void main(String[] args) {
		// 可见性测试
		/*ThreadDemo td = new ThreadDemo();
		new Thread(td).start();
		while(true){
			boolean a = td.isStatus();
			if(a){
				System.out.println("--------------");
				break;
			}
		}*/
		//原子性测试
		ThreadDemo1 td1 = new ThreadDemo1();
		for (int i = 0; i < 10; i++) {
			new Thread(td1).start();
		}
	}
}
//volatile  可见性测试
class ThreadDemo implements Runnable{
	volatile private boolean status = false;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(200);
		} catch (Exception e) {
			// TODO: handle exception
		}
		status = true;
	}
	public boolean isStatus() {
		return status;
	}
}
//原子性测试     AtomicInteger原子性测试
class ThreadDemo1 implements Runnable{
//	private volatile int i=0;
	private AtomicInteger i = new AtomicInteger(0);
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(getI());
	}
	
	public int getI(){
//		return i++;
		return i.incrementAndGet();
	}
}