package com.fzc.javatest.shejimoshi.bridge.control;

public interface Control {
	public void on();
	public void off();
	public void setChannel(int ch);
	public void setVolume(int vo);
}
