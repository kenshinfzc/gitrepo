package com.fzc.javatest.shejimoshi.decorator.cofferbar;

import com.fzc.javatest.shejimoshi.decorator.cofferbar.coffee.LongBlackCoffee;
import com.fzc.javatest.shejimoshi.decorator.cofferbar.decorator.Milk;
import com.fzc.javatest.shejimoshi.decorator.cofferbar.decorator.Tea;

/*
 装饰器模式：
 	动态的将新功能附加到对象上。 在对象功能扩展方面，它比继承更有弹性
 使用场景：
 	主体与多个附加项的复杂组合场景，将多个功能动态的附加到主体上时，比继承更灵活；
 优点：
 	主体与功能自由组合，不会产生大量的类，扩展性强，主体与功能的新增独立，符合开闭原则
 */

public class CoffeeBar {

	public static void main(String[] args) {
		Drink o = new LongBlackCoffee();
		System.out.println("description:"+o.getDescription());
		System.out.println("price:"+o.cost());
		
		Drink d = new Milk(o);
		d = new Tea(d);
		d = new Tea(d);
		System.out.println("description:"+d.getDescription());
		System.out.println("price:"+d.cost());
	}

}
