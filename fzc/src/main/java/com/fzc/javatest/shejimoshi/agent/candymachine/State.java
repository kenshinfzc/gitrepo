package com.fzc.javatest.shejimoshi.agent.candymachine;

import java.io.Serializable;

public interface State extends Serializable{
	public void insertCoin();
	public void turnCrunk();
	public void returnCoin();
	public void candyOut();
	public void printState();

}
