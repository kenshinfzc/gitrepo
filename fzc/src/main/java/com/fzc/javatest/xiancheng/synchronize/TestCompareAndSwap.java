package com.fzc.javatest.xiancheng.synchronize;

public class TestCompareAndSwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
class CompareAndSwap{
	volatile private int val;
	
	public synchronized int getVal(){
		return val;
	}
	public synchronized int incrementAndGet(){
		 for (;;) {
	            int current = getVal();
	            int next = current + 1;
	            if (compareAndSet(current, next))
	                return next;
	        }
	}
	
	public synchronized boolean compareAndSet(int expectedVal ,int newVal){
		return compareAndSwapInt(expectedVal, newVal);
	}
	
	public synchronized boolean compareAndSwapInt(int expectedVal ,int newVal){
		int oldVal = val;
		if(oldVal == expectedVal){
			return true;
		}else{
			return false;
		}
	}
}
