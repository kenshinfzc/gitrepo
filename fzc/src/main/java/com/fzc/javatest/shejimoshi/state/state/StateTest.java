package com.fzc.javatest.shejimoshi.state.state;

/*
 状态模式：能根据内部状态的变化，改变对象的行为，看起来好像修改了类
 适用场景：
 	对象的行为取决于对象的状态的，并且它必须在运行时刻根据状态改变它的行为
 优点：
 	免去了过多的if–else判断，这对于一些复杂的和繁琐的判断逻辑有很好的帮助。
 	状态的变化控制在不同的状态对象手中，主对象只调用状态中封装的方法，不直接操作状态，符合开闭原则；
 	添加状态时，需要实现状态接口，同步修改关联状态的关联方法，主对象基本不需要修改，逻辑解耦
缺点：使用状态模式，势必会造成更多的接口和类，对于非常简单的状态判断，可以不使用
 */
public class StateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CandyMachine cm = new CandyMachine(1);
		cm.printState();
		cm.insertCoin();
		cm.printState();
		cm.turnCrunk();
		cm.printState();
		cm.returnCoin();
	}

}
