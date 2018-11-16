package com.fzc.javatest.shejimoshi.factory.pizza;

public abstract class Pizza {
	protected String name ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void prepare();
	
	public void bake(){
		System.out.println(name+": bake;");
	}
	
	public void cut(){
		System.out.println(name+": cut;");
	}
}
