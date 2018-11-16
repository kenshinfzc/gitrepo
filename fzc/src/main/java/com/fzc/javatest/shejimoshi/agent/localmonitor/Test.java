package com.fzc.javatest.shejimoshi.agent.localmonitor;

import java.rmi.RemoteException;

import com.fzc.javatest.shejimoshi.agent.candymachine.CandyMachine;

public class Test {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		CandyMachine cm = new CandyMachine("test1", 2);
		cm.insertCoin();
		Moniter.addCandyMachine(cm);
		CandyMachine cm2 = new CandyMachine("test2", 3);
		Moniter.addCandyMachine(cm2);
		
		Moniter.display();
		
	}

}
