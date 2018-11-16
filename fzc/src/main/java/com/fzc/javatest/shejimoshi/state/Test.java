package com.fzc.javatest.shejimoshi.state;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CandyMachine cm = new CandyMachine(3);
		cm.printState();
		cm.insertCoin();
		cm.printState();
		cm.turnCrunk();
		cm.printState();
		cm.returnCoin();
	}

}
