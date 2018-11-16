package com.fzc.javatest.shejimoshi.observer.javaobserver;

import java.util.Observable;
import java.util.Observer;

import com.fzc.javatest.shejimoshi.observer.javaobserver.WeatherDataSt.Data;

public class Condition3 implements Observer {
	private int temper;
	private int pressure;
	private int wet;
	
	public void display(){
		System.out.println("Condition3 temper:"+temper);
		System.out.println("Condition3 pressure:"+pressure);
		System.out.println("Condition3 wet:"+wet);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(arg == null){
			Data d = WeatherDataSt.getInstance().getChange();
			this.temper = d.temper;
			this.pressure =d.pressure;
			this.wet = d.wet;
			System.out.println("主动拉取数据：");
			display();
		}else{
			System.out.println("推送数据：");
			this.temper = ((Data)arg).temper;
			this.pressure =((Data)arg).pressure;
			this.wet = ((Data)arg).wet;
			display();
		}
	}

}
