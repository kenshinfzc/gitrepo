package com.fzc.javatest.shejimoshi.observer.javaobserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.hibernate.dialect.H2Dialect;

/*
 java内置观察者模式：
	 使用场景：存在一对多的数据即时通信
	 数据提供方父类  Observable 已经实现了数据接收方的注册，删除，通知方法。
	 	优点：通用方法已经实现，不需要重复实现
	 	缺点：java单继承机制限制
	 数据接收方抽象接口  observer 定义数据更新方法
	 实现数据接收方与数据提供方的解耦，通过注册，所有的数据接收方都在数据提供方进行统一管理，统一数据通知
	 当需要扩展 添加新的数据接收方时，只需要实现observer接口，并注册到Observable的子类，就能够实现数据通知功能
特别注意：
	数据提供方数据变更通知接收方之前，需要先调用setChanged()方法，标识数据已经发生变更，可通过该方法来设置通知的场景限制，比如达到一定条件的修改才通知
数据传输方式： 
	 当数据量大的时候可以只通知数据发生变更，由接收方主动从提供方拉取数据
	 当数据量小的时候可以直接将数据推送至接受方
*/
public class WeatherDataSt extends Observable {
	private static WeatherDataSt w = null;
	private int temper;
	private int pressure;
	private int wet;
	
	private WeatherDataSt() {
		// TODO Auto-generated constructor stub
	}
	
	public static WeatherDataSt getInstance(){
		if(w==null){
			w = new WeatherDataSt();
		}
		return w ;
	}
	
	public Data getChange(){
		return new Data(getTemper(), getPressure(), getWet());
	}
	
	public void dataChange(){
		setChanged();
//		clearChanged();
		System.out.println("当前的观察者个数："+countObservers());
		notifyObservers();
//		notifyObservers(new Data(getTemper(), getPressure(), getWet()));
	}
	public void setData(int temper, int pressure, int wet){
		this.setTemper(temper);
		this.setPressure(pressure);
		this.setWet(wet);
		dataChange();
	}
	
	public int getTemper() {
		return temper;
	}
	public void setTemper(int temper) {
		this.temper = temper;
	}
	public int getPressure() {
		return pressure;
	}
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	public int getWet() {
		return wet;
	}
	public void setWet(int wet) {
		this.wet = wet;
	}

	public class Data{
		public int temper;
		public int pressure;
		public int wet;
		public Data(int temper,int pressure,int wet) {
			this.temper = temper;
			this.pressure = pressure;
			this.wet = wet;
		}
	}
}

