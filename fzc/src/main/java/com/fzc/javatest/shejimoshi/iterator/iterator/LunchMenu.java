package com.fzc.javatest.shejimoshi.iterator.iterator;

import java.util.ArrayList;

import com.fzc.javatest.shejimoshi.iterator.MenuItem;

public class LunchMenu {
	private ArrayList<MenuItem> lunchMenu = new ArrayList<MenuItem>();
	
	public LunchMenu() {
		addMenuItem("lunch menu 1", 1, true);
		addMenuItem("lunch menu 2", 2, false);
		addMenuItem("lunch menu 3", 3, true);
	}
	
	public void addMenuItem(String name,int price,boolean vege){
		MenuItem m = new MenuItem(name, price, vege);
		lunchMenu.add(m);
	}
	
	public Iterator getLunchIterator(){
		return new LunchIterator();
	}
	
	class LunchIterator implements Iterator{
		int index = 0;
		@Override
		public boolean haveNext() {
			// TODO Auto-generated method stub
			if(index<lunchMenu.size()){
				return true;
			}else{
				return false;
			}
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			MenuItem m = lunchMenu.get(index);
			index++;
			return m;
		}
		
	}
}
