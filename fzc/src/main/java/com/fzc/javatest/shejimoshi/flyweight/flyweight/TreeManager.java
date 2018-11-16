package com.fzc.javatest.shejimoshi.flyweight.flyweight;

public class TreeManager {
	private int length= 10000000;
	private int[] xx = new int[length];
	private int[] yy= new int[length];
	private int[] prices= new int[length];
	private TreeFlyWeight tfw;
	
	public TreeManager() {
		// TODO Auto-generated constructor stub
		tfw = new TreeFlyWeight();
		for(int i=0;i<10000000;i++){
			xx[i] = (int)Math.random()*100;
			yy[i] = (int)Math.random()*100;
			prices[i] = (int)Math.random()*100;
		}
	}
	
	public void display(){
		for(int i=0;i<10000000;i++){
			tfw.display(xx[i], yy[i], prices[i]);
		}
	}

}
