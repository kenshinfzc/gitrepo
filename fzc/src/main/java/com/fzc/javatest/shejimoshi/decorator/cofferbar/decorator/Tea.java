package com.fzc.javatest.shejimoshi.decorator.cofferbar.decorator;

import com.fzc.javatest.shejimoshi.decorator.cofferbar.Drink;

public class Tea extends Decorator {

	public Tea(Drink d) {
		super(d);
		super.setDescription("Tea");
		super.setPrice(5);
	}

}
