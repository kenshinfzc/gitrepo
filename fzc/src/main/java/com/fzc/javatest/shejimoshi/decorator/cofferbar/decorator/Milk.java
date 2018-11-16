package com.fzc.javatest.shejimoshi.decorator.cofferbar.decorator;

import com.fzc.javatest.shejimoshi.decorator.cofferbar.Drink;

public class Milk extends Decorator {

	public Milk(Drink d) {
		super(d);
		super.setDescription("Milk");
		super.setPrice(4);
	}

}
