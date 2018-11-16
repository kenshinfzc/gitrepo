package com.fzc.javatest.shejimoshi.decorator.cofferbar;

public abstract class Drink {
	private String description;
	private int price=0;
	
	public String getDescription() {
		return description+"--"+price;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public abstract int cost();

}
