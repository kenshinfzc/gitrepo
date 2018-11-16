package com.fzc.javatest.shejimoshi.iterator.javaiterator;

import java.util.ArrayList;
import java.util.Iterator;

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
			while(it.hasNext()){
				Object o = it.next() ; 
				if(o.getClass() ==MenuItem.class){
					MenuItem mi = (MenuItem)o;
					System.out.println(mi.getName()+"---"+mi.getPrice()+"---"+mi.isVege());
				}else{
					System.out.println(o.toString());
				}
			}
		}
		
	}
}
