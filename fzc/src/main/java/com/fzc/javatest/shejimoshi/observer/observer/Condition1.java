package com.fzc.javatest.shejimoshi.observer.observer;

public class Condition1 implements Observer {
	private int temper;
	private int pressure;
	private int wet;
	
	@Override
	public void update(int temper, int pressure, int wet) {
		// TODO Auto-generated method stub
		this.temper = temper;
		this.pressure = pressure;
		this.wet = wet;
		display();
	}
	
	public void display(){
		System.out.println("Condition1 temper:"+temper);
		System.out.println("Condition1 pressure:"+pressure);
		System.out.println("Condition1 wet:"+wet);
	}

}
