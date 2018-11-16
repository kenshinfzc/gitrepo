package com.fzc.javatest.shejimoshi.state.state;

public class SoldOutState implements State {
	private CandyMachine cm ;
	public SoldOutState(CandyMachine cm) {
		// TODO Auto-generated constructor stub
		this.cm = cm ;
	}

	@Override
	public void insertCoin() {
		// TODO Auto-generated method stub
		System.out.println("you can't insert coin,there is no candy;");
		
	}

	@Override
	public void turnCrunk() {
		// TODO Auto-generated method stub
		System.out.println("you can't turn,there is no candy;");
	}

	@Override
	public void returnCoin() {
		// TODO Auto-generated method stub
		System.out.println("you can't return coin,there is no candy;");
	}

	@Override
	public void candyOut() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printState() {
		// TODO Auto-generated method stub
		System.out.println("SoldOutState;");
	}

}
