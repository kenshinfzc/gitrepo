package com.fzc.javatest.shejimoshi.strategy.duck;

import com.fzc.javatest.shejimoshi.strategy.flybehavior.FastFlyBehavior;
import com.fzc.javatest.shejimoshi.strategy.quackbehavior.GaGaQuackBehavior;

public class GreenHeadDuck extends Duck {
	public GreenHeadDuck() {
		// TODO Auto-generated constructor stub
		fly = new FastFlyBehavior();
		quack = new GaGaQuackBehavior();
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("GreenHeadDuck");
	}

}
