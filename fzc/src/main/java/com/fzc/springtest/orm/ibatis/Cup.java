package com.fzc.springtest.orm.ibatis;

public class Cup {
	
	public int id;
	public String name;
	public int price;
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPpp() {
		return ppp;
	}
	public void setPpp(String ppp) {
		this.ppp = ppp;
	}
	public String ppp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
