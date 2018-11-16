package com.fzc.javatest.shejimoshi.iterator;

import java.util.ArrayList;

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
	
	public ArrayList<MenuItem> getLunchMenu(){
		return lunchMenu;
	}
}
