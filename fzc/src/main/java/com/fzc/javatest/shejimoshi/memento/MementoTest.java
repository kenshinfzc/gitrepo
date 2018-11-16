package com.fzc.javatest.shejimoshi.memento;

/*
 备忘录模式：在不破坏封装的前提下，存储关键对象的重要状态，从而可以在将来把对象还原到存储的那个状态
 	抽象的备忘录接口，不同的对象内部实现不同的备忘录类，
 	封装公用的备忘录处理类，提供备忘录保存与还原的公用方法
优点：
	  状态存储在外面，不和关键对象混在一起，这可以帮助维护内聚  
	  提供了容易实现的恢复能力
	  保持了关键对象的数据封装
缺点：
	  资源消耗上面备忘录对象会很昂贵
	  存储和恢复状态的过程比较耗时
适用场合：
  	必须保存一个对象在某一个时刻的(整体或部分)状态，在对象以外的地方, 以后需要时恢复到先前的状态时

 */
public class MementoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FunctionA fa = new FunctionA();
		fa.testState1();
		fa.showState();
		fa.saveState();
		fa.testState2();
		fa.showState();
		fa.restoreMemento(MementoCaretaker.queryMemento("functiona"));
		fa.showState();
		
//		fa.saveState();
//		fa.queryState();
//		FunctionB fb = new FunctionB();
//		fb.saveState();
//		fb.queryState("functionb");
	}

}
