package com.fzc.javatest.xiancheng;

public class GroupTestThread extends Thread {
	private int i ;
	
	public GroupTestThread(ThreadGroup tg, String name) {
		// TODO Auto-generated constructor stub
		super(tg, name);
	}
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(this.getThreadGroup().getName()+"----"+this.getName());
	}
}
