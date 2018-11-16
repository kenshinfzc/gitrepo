package com.fzc.javatest.shejimoshi.iterator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LunchMenu l = new LunchMenu();
		SupperMenu s = new SupperMenu();
		Waiter w = new Waiter(l, s);
		w.printAllMenuItem();
	}

}
