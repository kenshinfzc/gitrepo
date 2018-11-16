package com.fzc.javatest.shejimoshi.command.device;

public class Light {
	private String name;
	public Light(String name) {
		this.name = name;
	}
	
	public void lightOn(){
		System.out.println(name+": lightOn;");
	}
	public void lightOff(){
		System.out.println(name+": lightOff;");
	}
}
