package com.fzc.javatest.shejimoshi.agent.candymachine;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.fzc.javatest.shejimoshi.agent.remotemonitor.CandyMachineRemote;

public class CandyMachine extends UnicastRemoteObject implements CandyMachineRemote {
	public SoldOutState soldOutState;
	public OnReadyState onReadyState;
	public HasCoinState hasCoinState;
	public SoldState soldState;
	public WinnerState winnerState;
	private State state ;
	private int candyCnt = 0;
	private String loc = "";

	public CandyMachine(String loc ,int candyCnt) throws RemoteException {
		this.setLoc(loc);
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

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public State getState() {
		// TODO Auto-generated method stub
		return state;
	}
}
