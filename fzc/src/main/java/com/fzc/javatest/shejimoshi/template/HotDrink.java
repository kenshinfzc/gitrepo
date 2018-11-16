package com.fzc.javatest.shejimoshi.template;

public abstract class HotDrink {
	
	public final void steps(){
		boilWater();
		brew();
		pourInCup();
		if(wantCondiments()){
			addCondiments();
		}else{
			System.out.println("don't want condiments;");
		}
		
	} 
	public boolean wantCondiments() {
		return true;
	}
	public final void boilWater(){
		System.out.println("boilWater;");
	}
	
	public abstract void brew();
	
	public final void pourInCup(){
		System.out.println("pourInCup;");
	}

	public abstract void addCondiments();
	public boolean wantCondiment() {
		// TODO Auto-generated method stub
		return false;
	}
}
