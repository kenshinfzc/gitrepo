package com.fzc.javatest.shejimoshi.iterator;

public class MenuItem {
	
	private String name;
	private int price;
	private boolean vege;
	
	public MenuItem(String name,int price,boolean vege) {
		this.name = name ;
		this.price = price;
		this.vege = vege;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the vege
	 */
	public boolean isVege() {
		return vege;
	}

	/**
	 * @param vege the vege to set
	 */
	public void setVege(boolean vege) {
		this.vege = vege;
	}

}
