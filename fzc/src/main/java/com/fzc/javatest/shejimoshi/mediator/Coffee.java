package com.fzc.javatest.shejimoshi.mediator;

public class Coffee extends Colleague {

	public Coffee(String name, Mediator mediator) {
		super(name, mediator);
		// TODO Auto-generated constructor stub
		mediator.register(name, this);
	}

	@Override
	public void sendMessage(int state) {
		// TODO Auto-generated method stub
		mediator.getMessage(state, this);
	}
	
	public void startCoffee(){
		System.out.println("coffee start ;");
	}
	
	public void stopCoffee(){
		System.out.println("coffee stop ;");
		sendMessage(1);
	}

}
