package com.fzc.javatest.shejimoshi.mediator;

public class Alarm extends Colleague {
	private String state ;
	public Alarm(String name, Mediator mediator) {
		super(name, mediator);
		// TODO Auto-generated constructor stub
		mediator.register(name, this);
	}

	@Override
	public void sendMessage(int state) {
		// TODO Auto-generated method stub
		mediator.getMessage(state,this);
	}
	
	public void sendAlarm(int state){
		System.out.println("alarm on:"+state);
		sendMessage(state);
	}

}
