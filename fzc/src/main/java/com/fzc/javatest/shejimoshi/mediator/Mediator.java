package com.fzc.javatest.shejimoshi.mediator;

public interface Mediator {
	public void register(String name, Colleague colleague);
	public void getMessage(int state, Colleague colleague);
	public void sendMessage();
}
