package com.fzc.javatest.shejimoshi.command;

public interface Control {
	public void onButton(int index);
	public void offButton(int index);
	public void undoButton(int index);
}
