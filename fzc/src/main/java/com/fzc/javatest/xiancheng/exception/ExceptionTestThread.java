package com.fzc.javatest.xiancheng.exception;

public class ExceptionTestThread extends Thread {
	public ExceptionTestThread(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		float a = 5/0;
	}
	
}
