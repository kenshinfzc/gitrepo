package com.fzc.javatest.shejimoshi.template;

/*
 模板模式：
 	针对一类具有相同流程的事物，可以抽象出一个模板类，将固定的流程原先定义好，不同的对象只要实现各自的特征方法，就能实现功能
 	模板类中一般包含final的抽象流程控制方法，final的公用方法，可变的对象方法，以及可选的hook方法
 */
public class TemplateTest {
	
	public static void main(String[] args) {
		HotDrink coffee = new Coffee();
		HotDrink tea = new Tea();
		coffee.steps();
		tea.steps();
		HotDrink teaHook = new TeaWithHook();
		teaHook.steps();
	}
}
