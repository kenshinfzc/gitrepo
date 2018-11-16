package com.fzc.javatest.shejimoshi.agent.localmonitor;

import java.util.ArrayList;

import com.fzc.javatest.shejimoshi.agent.candymachine.CandyMachine;

public class Moniter {
	private static ArrayList<CandyMachine> l = new ArrayList<CandyMachine>();
	
	public static void addCandyMachine(CandyMachine cm){
		l.add(cm);
	}
	
	public static void display(){
		for(CandyMachine cm : l){
			System.out.println("loc:"+cm.getLoc()+"---cnt:"+cm.getCandyCnt());
			cm.printState();
		}
	}
	

}
