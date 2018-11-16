package com.fzc.javatest.shejimoshi.observer.observer;

public class IntetnateWeather {
	public static void main(String[] args){
		WeatherDataSt w = new WeatherDataSt();
		Condition1 c = new Condition1();
		Condition1 c1 = new Condition1();
		Condition3 c3 = new Condition3();
		w.registerObserver(c);
		w.registerObserver(c1);
		w.registerObserver(c3);
		w.setData(30, 40, 50);
//		System.out.println("------------------");
//		w.removeObserver(c1);
//		w.setData(10, 20, 30);
	}
}
