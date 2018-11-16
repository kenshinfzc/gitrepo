package com.fzc.javatest.shejimoshi.iterator;

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
	
	public MenuItem[] getSupperMenu(){
		return supperMenu;
	}
	
}
