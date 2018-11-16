package com.fzc.javatest.shejimoshi.factory.simplefactory;

import com.fzc.javatest.shejimoshi.factory.pizza.AmericaPizza;
import com.fzc.javatest.shejimoshi.factory.pizza.ChinesePizza;
import com.fzc.javatest.shejimoshi.factory.pizza.Pizza;

public class SimpleFactory {
	/**
	 * 简单工厂模式，
	 * 优点：能够实现对象创建与主程序的逻辑解耦
	 * 缺点：单一工厂功能单一，扩展性较差
	 * 建议：使用抽象工厂模式，可实现工厂的扩展
	 * @param type
	 * @return
	 */
	public static Pizza getPizza(String type) {
		// TODO Auto-generated constructor stub
		Pizza pizza = null;
		if("chinese".equals(type)){
			pizza = new ChinesePizza();
		}else if("america".equals(type)){
			pizza = new AmericaPizza();
		}else{
			pizza = null;
		}
		return pizza;
	}

}
