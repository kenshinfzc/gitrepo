package com.fzc.javatest.xiancheng;

public class DaemonThread extends Thread {
	private int i ;
	public DaemonThread(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(i=0;i<200;i++){
			System.out.println(this.getName()+"  "+i);
		}
	}
}
