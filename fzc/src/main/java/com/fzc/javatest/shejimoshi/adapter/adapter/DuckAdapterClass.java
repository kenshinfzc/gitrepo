package com.fzc.javatest.shejimoshi.adapter.adapter;

import com.fzc.javatest.shejimoshi.adapter.duck.Duck;
import com.fzc.javatest.shejimoshi.adapter.turkey.Turkey;
import com.fzc.javatest.shejimoshi.adapter.turkey.WildTurkey;

public class DuckAdapterClass extends WildTurkey implements Duck {
	
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		super.fly();
	}

	@Override
	public void quack() {
		// TODO Auto-generated method stub
		super.haha();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		super.display();
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}


}
