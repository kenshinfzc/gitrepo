package com.fzc.javatest.shejimoshi.observer.javaobserver;

public class IntetnateWeather {
	public static void main(String[] args){
		WeatherDataSt w = WeatherDataSt.getInstance();
		Condition1 c = new Condition1();
		Condition2 c1 = new Condition2();
		Condition3 c3 = new Condition3();
		w.addObserver(c3);
		w.addObserver(c1);
		w.addObserver(c);
		w.setData(30, 40, 50);
//		System.out.println("------------------");
//		w.removeObserver(c1);
//		w.setData(10, 20, 30);
	}
}
