package com.fzc.javatest.shejimoshi.adapter.adapter;

import com.fzc.javatest.shejimoshi.adapter.duck.Duck;
import com.fzc.javatest.shejimoshi.adapter.turkey.Turkey;

public class DuckAdapter implements Duck {
	private Turkey t ;
	public DuckAdapter(Turkey t) {
		this.t = t ;
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		t.fly();
	}

	@Override
	public void quack() {
		// TODO Auto-generated method stub
		t.haha();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		t.display();
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
