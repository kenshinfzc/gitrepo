package com.fzc.javatest.shejimoshi.mediator;

public class TV extends Colleague {

	public TV(String name, Mediator mediator) {
		super(name, mediator);
		// TODO Auto-generated constructor stub
		mediator.register(name, this);
	}

	@Override
	public void sendMessage(int state) {
		// TODO Auto-generated method stub

	}

	public void tvOn(){
		System.out.println("TV on;");
	}
}
