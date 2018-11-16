package com.fzc.javatest.shejimoshi.bridge;

import com.fzc.javatest.shejimoshi.bridge.control.SonyControl;

public class SonyTvControl extends SonyControl implements TVControl {
	int ch = 0;
	boolean state = false;
	@Override
	public void onOff() {
		// TODO Auto-generated method stub
		if(state){
			state = false;
			super.off();
		}else{
			state = true;
			super.on();
		}
	}

	@Override
	public void nextChannel() {
		// TODO Auto-generated method stub
		super.setChannel(++ch);
	}

	@Override
	public void preChannel() {
		// TODO Auto-generated method stub
		super.setChannel(--ch);
	}

}
