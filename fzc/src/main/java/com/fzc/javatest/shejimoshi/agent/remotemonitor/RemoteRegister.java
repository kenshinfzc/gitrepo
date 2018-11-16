package com.fzc.javatest.shejimoshi.agent.remotemonitor;

import java.rmi.Naming;
import java.rmi.RemoteException;

import com.fzc.javatest.shejimoshi.agent.candymachine.CandyMachine;
//远端对象注册
public class RemoteRegister {

	public static void main(String[] args) throws RemoteException, Exception {
		// TODO Auto-generated method stub
		CandyMachine cm = new CandyMachine("test1", 3);
		Naming.rebind("rmi://127.0.0.1:6600/test1", cm);
		CandyMachine cm2 = new CandyMachine("test2", 2);
		Naming.rebind("rmi://127.0.0.1:6600/test2", cm2);
		cm2.insertCoin();
	}

}
