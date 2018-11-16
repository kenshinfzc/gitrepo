package com.fzc.javatest.xiancheng.exception;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExceptionTestThread ett = new ExceptionTestThread("ceshi");
		ett.setUncaughtExceptionHandler(new MyExceptionHandler());
		ett.start();
	}

}
