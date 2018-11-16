package com.fzc.javatest.shejimoshi.bridge;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LGTvControl lg = new LGTvControl();
		lg.onOff();
		lg.nextChannel();
		lg.nextChannel();
		
		SonyTvControl sony = new SonyTvControl();
		sony.onOff();
		sony.preChannel();
		sony.preChannel();
		sony.nextChannel();
		
		SharpTvControl sh = new SharpTvControl();
		sh.onOff();
		sh.preChannel();
		sh.nextChannel();
	}

}
