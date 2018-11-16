package com.fzc.javatest.shejimoshi.state.state;

public class OnReadyState implements State {
	private CandyMachine cm ;
	public OnReadyState(CandyMachine cm) {
		// TODO Auto-generated constructor stub
		this.cm = cm ;
	}

	@Override
	public void insertCoin() {
		// TODO Auto-generated method stub
		System.out.println("you have inserted coin, you can turn the crunk;");
		cm.setState(cm.hasCoinState);	
	}

	@Override
	public void turnCrunk() {
		// TODO Auto-generated method stub
		System.out.println("you can't turn util you insert a coin;");
	}

	@Override
	public void returnCoin() {
		// TODO Auto-generated method stub
		System.out.println("you can't return coin there is no coin;");
	}

	@Override
	public void candyOut() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printState() {
		// TODO Auto-generated method stub
		System.out.println("OnReadyState;");
	}

}
