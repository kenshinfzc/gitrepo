package com.fzc.javatest.shejimoshi.bridge.bridge;

import com.fzc.javatest.shejimoshi.bridge.control.Control;

public class TVControl extends TVControlAbs {
	int ch = 0;
	int preCh = 0;
	boolean state = false;
	
	public TVControl(Control control) {
		super(control);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onOff() {
		// TODO Auto-generated method stub
		if(state){
			state = false;
			control.off();
		}else{
			state = true;
			control.on();
		}
	}

	@Override
	public void nextChannel() {
		// TODO Auto-generated method stub
		preCh = ch;
		ch++;
		control.setChannel(ch);
	}

	@Override
	public void preChannel() {
		// TODO Auto-generated method stub
		preCh = ch;
		ch--;
		control.setChannel(ch);
	}

	public void backChannel(){
		int temp = ch;
		ch = preCh;
		control.setChannel(ch);
		preCh = temp;
	}
}
