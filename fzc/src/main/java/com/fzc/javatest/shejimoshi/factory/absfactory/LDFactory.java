package com.fzc.javatest.shejimoshi.factory.absfactory;

import com.fzc.javatest.shejimoshi.factory.pizza.LDAmericaPizza;
import com.fzc.javatest.shejimoshi.factory.pizza.LDChinesePizza;
import com.fzc.javatest.shejimoshi.factory.pizza.Pizza;

public class LDFactory implements AbsFactory {

	public LDFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Pizza getPizza(String type) {
		Pizza pizza = null;
		if("chinese".equals(type)){
			pizza = new LDChinesePizza();
		}else if("america".equals(type)){
			pizza = new LDAmericaPizza();
		}else{
			pizza = null;
		}
		return pizza;
	}

}
