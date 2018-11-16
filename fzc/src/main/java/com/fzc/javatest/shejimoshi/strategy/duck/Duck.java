package com.fzc.javatest.shejimoshi.strategy.duck;

import com.fzc.javatest.shejimoshi.strategy.flybehavior.FlyBehavior;
import com.fzc.javatest.shejimoshi.strategy.quackbehavior.QuackBehavior;

public abstract class Duck {
	protected FlyBehavior fly;
	protected QuackBehavior quack;
	
	public FlyBehavior getFly() {
		return fly;
	}
	public void setFly(FlyBehavior fly) {
		this.fly = fly;
	}
	public QuackBehavior getQuack() {
		return quack;
	}
	public void setQuack(QuackBehavior quack) {
		this.quack = quack;
	}
	public void fly(){
		fly.fly();
	};
	public void quack(){
		quack.quack();
	}
	public void swim(){
		System.out.println("duck swim;");
	}
	public abstract void display();

}
