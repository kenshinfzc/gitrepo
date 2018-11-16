package com.fzc.javatest.shejimoshi.state.state;

public class CandyMachine {
	public SoldOutState soldOutState;
	public OnReadyState onReadyState;
	public HasCoinState hasCoinState;
	public SoldState soldState;
	public WinnerState winnerState;
	private State state ;
	private int candyCnt = 0;

	public CandyMachine(int candyCnt) {
		this.candyCnt = candyCnt;
		soldOutState = new SoldOutState(this);
		onReadyState = new OnReadyState(this);
		hasCoinState = new HasCoinState(this);
		soldState = new SoldState(this);
		winnerState = new WinnerState(this);
		if(candyCnt>0){
			state = onReadyState;
		}
	}
	
	public void insertCoin(){
		state.insertCoin();
	}
	
	public void turnCrunk(){
		state.turnCrunk();
		state.candyOut();
	}
	
	public void candyOut() {
		candyCnt--;
		System.out.println("a candy is rolling out;");
	}

	public void returnCoin(){
		state.returnCoin();
	}
	
	public void printState(){
		state.printState();
	}

	/**
	 * @param candyCnt the candyCnt to set
	 */
	public void setCandyCnt(int candyCnt) {
		this.candyCnt = candyCnt;
	}
	public int getCandyCnt() {
		return candyCnt;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}
}
