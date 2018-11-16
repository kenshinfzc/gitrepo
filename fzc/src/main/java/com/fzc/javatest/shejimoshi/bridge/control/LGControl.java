package com.fzc.javatest.shejimoshi.bridge.control;


public class LGControl implements Control {

	@Override
	public void on() {
		// TODO Auto-generated method stub
		System.out.println("LG on;");
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		System.out.println("LG off;");
	}

	@Override
	public void setChannel(int ch) {
		// TODO Auto-generated method stub
		System.out.println("LG channel on:"+ch);
	}

	@Override
	public void setVolume(int vo) {
		// TODO Auto-generated method stub
		System.out.println("LG volume on:"+vo);
	}


}
