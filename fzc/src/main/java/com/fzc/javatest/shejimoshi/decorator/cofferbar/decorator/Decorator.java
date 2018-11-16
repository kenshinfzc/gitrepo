package com.fzc.javatest.shejimoshi.decorator.cofferbar.decorator;

import com.fzc.javatest.shejimoshi.decorator.cofferbar.Drink;

public class Decorator extends Drink {
	private Drink d;
	
	public Decorator(Drink d) {
		this.d = d;
	}
	@Override
	public int cost() {
		return d.cost() + super.getPrice();
	}
	
	@Override
	public String getDescription(){
		return d.getDescription() +";"+ super.getDescription();
	}
}
