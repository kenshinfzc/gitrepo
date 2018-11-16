package com.fzc.javatest.shejimoshi.factory.absfactory;

public class PizzaStore {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		OrderPizza op = new OrderPizza();
//		op.setAbsFactory(new LDFactory());
		op.setAbsFactory(new NYFactory());
		op.orderPizza();
	}

}