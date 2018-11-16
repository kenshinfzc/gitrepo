package com.fzc.javatest.shejimoshi.state.state;

public class WinnerState implements State {
	private CandyMachine cm ;
	public WinnerState(CandyMachine cm) {
		// TODO Auto-generated constructor stub
		this.cm = cm ;
	}
	@Override
	public void insertCoin() {
		// TODO Auto-generated method stub
		System.out.println("you can't insert coin, winner;");
	}

	@Override
	public void turnCrunk() {
		// TODO Auto-generated method stub
		System.out.println("you can't turn crunk,winner ;");
	}

	@Override
	public void returnCoin() {
		// TODO Auto-generated method stub
		System.out.println("you can't return coin, winner;");
	}

	@Override
	public void candyOut() {
		// TODO Auto-generated method stub
		cm.candyOut();
		if(cm.getCandyCnt()>0){
			System.out.println("you are a winner, we will give you another candy;");
			cm.candyOut();
			if(cm.getCandyCnt()>0){
				cm.setState(cm.onReadyState);
			}else{
				cm.setState(cm.soldOutState);
			}
			
		}else{
			System.out.println("there is no candy;");
			cm.setState(cm.soldOutState);
		}
	}

	@Override
	public void printState() {
		// TODO Auto-generated method stub
		System.out.println("WinnerState;");
	}

}
