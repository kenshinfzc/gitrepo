package com.fzc.javatest.shejimoshi.iterator.iterator;

import com.fzc.javatest.shejimoshi.iterator.MenuItem;

public class SupperMenu {
	MenuItem[] supperMenu ;
	int index = 0;
	int max = 5;
	public SupperMenu() {
		supperMenu = new MenuItem[max];
		addMenuItem("supper Menu 1",11,true);
		addMenuItem("supper Menu 2",22,true);
		addMenuItem("supper Menu 3",33,false);
	}
	private void addMenuItem(String name, int price, boolean vege) {
		// TODO Auto-generated method stub
		MenuItem m = new MenuItem(name, price, vege);
		if(index<5){
			supperMenu[index] = m;
			index++;
		}else{
			System.out.println("index too large;");
		}
	}
	
	public Iterator getSupperIterator(){
		return new SupperIterator();
	}
	
	class SupperIterator implements Iterator{
		int i = 0 ;
		@Override
		public boolean haveNext() {
			// TODO Auto-generated method stub
			if(i<index){
				return true ;
			}else{
				return false;
			}
		}

		@Override
		public Object next() {
			MenuItem m = supperMenu[i];
			i++;
			return m;
		}
		
	}
}
