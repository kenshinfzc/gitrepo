package com.fzc.javatest.shejimoshi.strategy;

import com.fzc.javatest.shejimoshi.strategy.duck.GreenHeadDuck;
import com.fzc.javatest.shejimoshi.strategy.duck.RedHeadDuck;
import com.fzc.javatest.shejimoshi.strategy.flybehavior.FastFlyBehavior;

/*
 分别封装行为接口，实现算法族，超类里放行为接口对象，在子类里具体设定行为对象。 原则就是：分离变化部分，封装接口，基于接口编程各种功能。
  此模式让行为算法的变化独立于算法的使用者。
    
面向对象（oo）的继承方式 不能同时兼容扩展性和复用性，且耦合度高
采用策略模式，将复杂的变化行为与对象的创建解耦，并实现行为的复用 与 灵活替换

策略模式，定义了一系列的算法，并将每一个算法封装起来，而且使它们还可以相互替换。
算法的复用性高，且让算法独立于使用它的客户而独立变化

使用场景：
	某一个功能有多种方案可以选择的情景
*/

public class StimulateDuck {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GreenHeadDuck d = new GreenHeadDuck();
		d.display();
		d.swim();
		d.fly();
		d.quack();
		RedHeadDuck r = new RedHeadDuck();
		r.display();
		r.swim();
		r.fly();
		r.quack();
		r.setFly(new FastFlyBehavior());
		r.display();
		r.fly();
		r.quack();
	}

}
