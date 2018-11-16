package com.fzc.javatest.shejimoshi.iterator;

import java.util.ArrayList;

public class Waiter {
	private LunchMenu l;
	private SupperMenu s;
	private ArrayList<MenuItem> ls;
	private MenuItem[] ss;
	
	public Waiter(LunchMenu l,SupperMenu s) {
		this.l = l;
		this.s = s ;
		this.ls = l.getLunchMenu();
		this.ss = s.getSupperMenu();
	}

	public void printAllMenuItem(){
		for(MenuItem mi :ls){
			System.out.println(mi.getName()+"---"+mi.getPrice()+"---"+mi.isVege());
		}
		
		System.out.println(ss.length);
		for(int i =0;i<s.index;i++){
			MenuItem mi = ss[i];
			System.out.println(mi.getName()+"---"+mi.getPrice()+"---"+mi.isVege());
		}
		
	}
}
