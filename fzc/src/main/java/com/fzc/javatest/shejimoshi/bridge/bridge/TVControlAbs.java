package com.fzc.javatest.shejimoshi.bridge.bridge;

import com.fzc.javatest.shejimoshi.bridge.control.Control;

public abstract class TVControlAbs {
	Control control;
	public TVControlAbs(Control control) {
		// TODO Auto-generated constructor stub
		this.control = control; 
	}

	public abstract void onOff();
	public abstract void nextChannel();
	public abstract void preChannel();
}
