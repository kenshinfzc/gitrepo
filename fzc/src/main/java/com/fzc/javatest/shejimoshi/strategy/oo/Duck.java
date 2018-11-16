package com.fzc.javatest.shejimoshi.strategy.oo;

public abstract class Duck {
	public void fly(){
		System.out.println("duck fly;");
	};
	public void quack(){
		System.out.println("duck gaga");
	};
	public void swim(){
		System.out.println("duck swim;");
	}
	public abstract void display();

}
