package com.fzc.javatest.shejimoshi.iterator.iterator;

import java.util.ArrayList;

import com.fzc.javatest.shejimoshi.iterator.MenuItem;

public class Waiter {
	private ArrayList<Iterator> list ;
	private LunchMenu l;
	private SupperMenu s;
	
	public Waiter(LunchMenu l,SupperMenu s) {
		this.l = l;
		this.s = s ;
		list = new ArrayList<Iterator>();
	}
	
	public void addIterator(Iterator it){
		list.add(it);
	}

	public void printAllMenuItem(){
		for(Iterator it : list){
			while(it.haveNext()){
				MenuItem mi = (MenuItem)it.next();
				System.out.println(mi.getName()+"---"+mi.getPrice()+"---"+mi.isVege());
			}
		}
		
	}
}
