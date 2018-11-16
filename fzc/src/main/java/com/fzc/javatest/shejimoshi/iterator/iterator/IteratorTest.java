package com.fzc.javatest.shejimoshi.iterator.iterator;

/*
 迭代器模式：
 	提供一种方法，顺序访问处理聚合对象中的所有对象 
 	可以实现访问者和被访问者的解耦，独立修改，方便扩展
 使用场景：
 	需要顺序访问一个组合内的多个对象的时候使用
 */
public class IteratorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LunchMenu l = new LunchMenu();
		SupperMenu s = new SupperMenu();
		Waiter w = new Waiter(l, s);
		w.addIterator(l.getLunchIterator());
		w.addIterator(s.getSupperIterator());
		w.printAllMenuItem();
	}

}
