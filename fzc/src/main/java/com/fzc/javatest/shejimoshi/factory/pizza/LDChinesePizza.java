package com.fzc.javatest.shejimoshi.factory.pizza;

public class LDChinesePizza extends Pizza {

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		super.setName("LDChinesePizza");
		System.out.println(name+": prepare;");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChinesePizza cp = new ChinesePizza();
		cp.prepare();
		cp.bake();
		cp.cut();
	}

}
