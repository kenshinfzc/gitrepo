package com.fzc.javatest.shejimoshi.mediator;

public abstract class Colleague {
	protected Mediator mediator;
	protected String name ;
	public Colleague(String name, Mediator mediator) {
		// TODO Auto-generated constructor stub
		this.name = name ;
		this.mediator = mediator;
	}
	public abstract void sendMessage(int state);
}
