package com.fzc.javatest.xiancheng;

public class FirstThread extends Thread {
	private int i ;
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(i=0;i<100;i++){
			System.out.println(this.getName()+"  "+i);
		}
	}
}
