package com.fzc.javatest.shejimoshi.agent.remotemonitor;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.fzc.javatest.shejimoshi.agent.candymachine.State;

public interface CandyMachineRemote extends Remote {
	public int getCandyCnt() throws RemoteException;
	public String getLoc() throws RemoteException;
	public State getState() throws RemoteException;
}
