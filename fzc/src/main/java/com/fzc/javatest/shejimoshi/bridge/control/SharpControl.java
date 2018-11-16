package com.fzc.javatest.shejimoshi.bridge.control;


public class SharpControl implements Control {

	@Override
	public void on() {
		// TODO Auto-generated method stub
		System.out.println("sharp on;");
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		System.out.println("sharp off;");
	}

	@Override
	public void setChannel(int ch) {
		// TODO Auto-generated method stub
		System.out.println("sharp channel on:"+ch);
	}

	@Override
	public void setVolume(int vo) {
		// TODO Auto-generated method stub
		System.out.println("sharp volume on:"+vo);
	}


}
