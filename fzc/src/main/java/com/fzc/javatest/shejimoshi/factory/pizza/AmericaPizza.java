package com.fzc.javatest.shejimoshi.factory.pizza;

public class AmericaPizza extends Pizza {

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		super.setName("AmericaPizza");
		System.out.println(name+": prepare;");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AmericaPizza cp = new AmericaPizza();
		cp.prepare();
		cp.bake();
		cp.cut();
	}

}
