package com.fzc.javatest.shejimoshi.state;

public class CandyMachine {
	private final int soldOutState = 0;
	private final int onReadyState = 1;
	private final int hasCoinState = 2;
	private final int soldState = 3;
	
	private int candyCnt = 0;
	private int state = 0;
	public CandyMachine(int candyCnt) {
		this.candyCnt = candyCnt;
		if(candyCnt>0){
			state = onReadyState;
		}
	}
	
	public void insertCoin(){
		switch (state) {
		case 0:
			System.out.println("you can't insert coin,there is no candy;");
			break;
		case 1:
			System.out.println("you have inserted coin, you can turn the crunk;");
			state = hasCoinState;
			break;
		case 2:
			System.out.println("you can't insert coin,there is already one;");
			break;
		case 3:
			System.out.println("you can't insert coin,a candy is comming soon;");
			break;

		default:
			break;
		}
	}
	
	public void turnCrunk(){
		switch (state) {
		case 0:
			System.out.println("you can't turn,there is no candy;");
			break;
		case 1:
			System.out.println("you can't turn util you insert a coin;");
			break;
		case 2:
			System.out.println("you turn crunk, wait a moment;");
			candyOut();
			break;
		case 3:
			System.out.println("you can't turn crunk,a candy is comming soon;");
			break;

		default:
			break;
		}
	}
	
	private void candyOut() {
		candyCnt--;
		if(candyCnt>0){
			state = onReadyState;
		}else{
			System.out.println("there is no candy;");
			state = soldOutState;
		}

	}

	public void returnCoin(){
		switch (state) {
		case 0:
			System.out.println("you can't return coin,there is no candy;");
			break;
		case 1:
			System.out.println("you can't return coin there is no coin;");
			break;
		case 2:
			System.out.println("a coin is return;");
			state = onReadyState; 
			break;
		case 3:
			System.out.println("you can't return coin,a candy is comming soon;");
			break;

		default:
			break;
		}
	}
	
	public void printState(){
		switch (state) {
		case 0:
			System.out.println("soldOutState;");
			break;
		case 1:
			System.out.println("onReadyState;");
			break;
		case 2:
			System.out.println("hasCoinState;");
			break;
		case 3:
			System.out.println("soldState;");
			break;

		default:
			break;
		}
	}
	

	public int getCandyCnt() {
		return candyCnt;
	}

	public int getState() {
		return state;
	}
}
