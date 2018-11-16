package com.fzc.javatest.shejimoshi.factory.absfactory;

import com.fzc.javatest.shejimoshi.factory.pizza.NYAmericaPizza;
import com.fzc.javatest.shejimoshi.factory.pizza.NYChinesePizza;
import com.fzc.javatest.shejimoshi.factory.pizza.Pizza;

public class NYFactory implements AbsFactory {

	public NYFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Pizza getPizza(String type) {
		Pizza pizza = null;
		if("chinese".equals(type)){
			pizza = new NYChinesePizza();
		}else if("america".equals(type)){
			pizza = new NYAmericaPizza();
		}else{
			pizza = null;
		}
		return pizza;
	}

}
