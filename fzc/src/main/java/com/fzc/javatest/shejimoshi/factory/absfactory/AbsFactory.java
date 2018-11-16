package com.fzc.javatest.shejimoshi.factory.absfactory;

import com.fzc.javatest.shejimoshi.factory.pizza.Pizza;

/*
  抽象工厂模式
  优点：能够实现对象创建与主程序的逻辑解耦，并且能够很好的实现工厂的扩展
  与策略模式的比较：工厂相当于黑盒子，策略相当于白盒子
	 用途不一样 
		工厂是创建型模式,它的作用就是创建对象； 
		策略是行为型模式,它的作用是让一个对象在许多行为中选择一种行为;
	 关注点不一样 
		一个关注对象创建 
		一个关注行为的封装
	 解决不同的问题 
		工厂模式是创建型的设计模式，它接受指令，创建出符合要求的实例；它主要解决的是资源的统一分发，将对象的创建完全独立出来，让对象的创建和具体的使用客户无关。主要应用在多数据库选择，类库文件加载等。
		策略模式是为了解决的是策略的切换与扩展，更简洁的说是定义策略族，分别封装起来，让他们之间可以相互替换，策略模式让策略的变化独立于使用策略的客户。
 */
public interface AbsFactory {
	public Pizza getPizza(String type);
}
