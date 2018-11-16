package com.fzc.javatest.shejimoshi.agent.remotemonitor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.fzc.javatest.shejimoshi.agent.candymachine.CandyMachine;

/*
 远程代理：远程对象的本地备份  RMI
 CandyMachineRemote  接口作为本地对象的代理
 */
public class Test {

	public static void main(String[] args) throws RemoteException {
		CandyMachineRemote cm;
		try {
			cm = (CandyMachineRemote) Naming.lookup("rmi://127.0.0.1:6600/test1");
			Moniter.addCandyMachine(cm);
			cm = (CandyMachineRemote) Naming.lookup("rmi://127.0.0.1:6600/test2");
			Moniter.addCandyMachine(cm);
			Moniter.display();
		} catch (MalformedURLException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
