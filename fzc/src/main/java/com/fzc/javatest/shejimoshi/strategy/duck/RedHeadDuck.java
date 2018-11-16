package com.fzc.javatest.shejimoshi.strategy.duck;

import com.fzc.javatest.shejimoshi.strategy.flybehavior.SlowFlyBehavior;
import com.fzc.javatest.shejimoshi.strategy.quackbehavior.HaHaQuackBehavior;

public class RedHeadDuck extends Duck {
	public RedHeadDuck() {
		// TODO Auto-generated constructor stub
		fly = new SlowFlyBehavior();
		quack = new HaHaQuackBehavior();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("RedHeadDuck");
	}

}
