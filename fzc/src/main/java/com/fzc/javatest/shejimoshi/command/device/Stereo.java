package com.fzc.javatest.shejimoshi.command.device;

public class Stereo {
	private String name ;
	public Stereo(String name) {
		this.name = name;
	}
	
	public void stereoOn(){
		System.out.println(name+": stereoOn;");
	}
	
	public void stereoOff(){
		System.out.println(name+": stereoOff;");
	}
	
}
