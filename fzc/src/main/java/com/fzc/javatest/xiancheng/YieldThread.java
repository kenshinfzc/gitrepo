package com.fzc.javatest.xiancheng;

public class YieldThread extends Thread {
	private int i ;
	public YieldThread(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(i=0;i<100;i++){
			System.out.println(this.getName()+"  "+i);
			if(i==20){
				Thread.yield();
			}
		}
	}
}
