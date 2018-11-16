package com.fzc.javatest.shejimoshi.state.state;

import java.util.Random;

public class HasCoinState implements State {
	private CandyMachine cm ;
	public HasCoinState(CandyMachine cm) {
		// TODO Auto-generated constructor stub
		this.cm = cm ;
	}

	@Override
	public void insertCoin() {
		// TODO Auto-generated method stub
		System.out.println("you can't insert coin,there is already one;");
	}

	@Override
	public void turnCrunk() {
		// TODO Auto-generated method stub
		System.out.println("you turn crunk, wait a moment;");
		//10%概率出两个
		int i = new Random().nextInt();
		if(i==0){
			cm.setState(cm.winnerState);
		}else{

			cm.setState(cm.soldState);
		}
	}

	@Override
	public void returnCoin() {
		// TODO Auto-generated method stub
		System.out.println("a coin is return;");
	}

	@Override
	public void candyOut() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printState() {
		// TODO Auto-generated method stub
		System.out.println("HasCoinState;");
	}

}
