package com.fzc.javatest.shejimoshi.iterator.javaiterator;

import java.util.HashMap;
import java.util.Iterator;

import com.fzc.javatest.shejimoshi.iterator.MenuItem;

public class CafeMenu {
	private HashMap<String, MenuItem> cafeMenu = new HashMap<String,MenuItem>();
	
	public CafeMenu() {
		addMenuItem("cafe menu 1", 1, true);
		addMenuItem("cafe menu 2", 2, false);
		addMenuItem("cafe menu 3", 3, true);
	}
	
	public void addMenuItem(String name,int price,boolean vege){
		MenuItem m = new MenuItem(name, price, vege);
		cafeMenu.put(name, m);
	}
	
	public Iterator getCafeIterator(){
		return cafeMenu.values().iterator();
	}
	public Iterator getCafeNameIterator(){
		return cafeMenu.keySet().iterator();
	}
}
