package com.fzc.javatest.shejimoshi.bridge.control;


public class SonyControl implements Control {

	@Override
	public void on() {
		// TODO Auto-generated method stub
		System.out.println("sony on;");
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		System.out.println("sony off;");
	}

	@Override
	public void setChannel(int ch) {
		// TODO Auto-generated method stub
		System.out.println("sony channel on:"+ch);
	}

	@Override
	public void setVolume(int vo) {
		// TODO Auto-generated method stub
		System.out.println("sony volume on:"+vo);
	}


}
