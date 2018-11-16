package com.fzc.javatest.shejimoshi.observer.old;

public class IntetnateWeather {
	public static void main(String[] args){
		Condition1 c = new Condition1();
		Condition2 c1 = new Condition2();
		WeatherData w = new WeatherData(c,c1);
		w.setData(30, 40, 50);
	}
}
