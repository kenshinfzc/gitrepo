package com.fzc.javatest.shejimoshi.agent.remotemonitor;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.fzc.javatest.shejimoshi.agent.candymachine.CandyMachine;

public class Moniter {
	private static ArrayList<CandyMachineRemote> l = new ArrayList<CandyMachineRemote>();
	
	public static void addCandyMachine(CandyMachineRemote cm){
		l.add(cm);
	}
	
	public static void display() throws RemoteException{
		for(CandyMachineRemote cm : l){
			System.out.println("loc:"+cm.getLoc()+"---cnt:"+cm.getCandyCnt());
		}
	}
	

}
