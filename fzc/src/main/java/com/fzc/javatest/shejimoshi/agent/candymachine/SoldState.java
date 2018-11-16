package com.fzc.javatest.shejimoshi.agent.candymachine;

public class SoldState implements State {
	private CandyMachine cm ;
	public SoldState(CandyMachine cm) {
		// TODO Auto-generated constructor stub
		this.cm = cm ;
	}

	@Override
	public void insertCoin() {
		// TODO Auto-generated method stub
		System.out.println("you can't insert coin,a candy is comming soon;");
		
	}

	@Override
	public void turnCrunk() {
		// TODO Auto-generated method stub
		System.out.println("you can't turn crunk,a candy is comming soon;");
	}

	@Override
	public void returnCoin() {
		// TODO Auto-generated method stub
		System.out.println("you can't return coin,a candy is comming soon;");
	}

	@Override
	public void candyOut() {
		// TODO Auto-generated method stub
		cm.candyOut();
		if(cm.getCandyCnt()>0){
			cm.setState(cm.onReadyState);
		}else{
			System.out.println("there is no candy;");
			cm.setState(cm.soldOutState);
		}
	}

	@Override
	public void printState() {
		// TODO Auto-generated method stub
		System.out.println("SoldState;");
	}

}
