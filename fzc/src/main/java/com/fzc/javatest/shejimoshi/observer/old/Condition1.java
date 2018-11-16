package com.fzc.javatest.shejimoshi.observer.old;

public class Condition1 {
	private int temper;
	private int pressure;
	private int wet;
	
	public void update(int temper, int pressure ,int wet){
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
