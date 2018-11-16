package com.fzc.javatest.shejimoshi.observer.observer;

import java.util.ArrayList;

/*
 观察者模式：
 	 对象之间多对一依赖的一种设计方案，被依赖的对象为Subject，依赖的对象为Observer，Subject通知Observer变化
	 数据提供方抽象接口  subject 定义数据接收方的注册，删除，通知方法
	 数据接收方抽象接口  observer 定义数据更新方法
	 实现数据接收方与数据提供方的解耦，通过注册，所有的数据接收方都在数据提供方进行统一管理，统一数据通知
	 当需要扩展 添加新的数据接收方时，只需要实现observer接口，并注册到subject的实现类，就能够实现数据通知功能
使用场景：
	存在一对多的数据即时通信
数据传输方式： 
	 当数据量大的时候可以只通知数据发生变更，由接收方主动从提供方拉取数据
	 当数据量小的时候可以直接将数据推送至接受方
*/
public class WeatherDataSt implements Subject {
	private int temper;
	private int pressure;
	private int wet;
	private ArrayList<Observer> l = new ArrayList<Observer>();
	
	public void dataChange(Observer o){
		o.update(getTemper(), getPressure(), getWet());
	}
	public void setData(int temper, int pressure, int wet){
		this.setTemper(temper);
		this.setPressure(pressure);
		this.setWet(wet);
		noticeObserver();
	}
	
	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		l.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		if(l.contains(o)){
			l.remove(o);
		}
	}

	@Override
	public void noticeObserver() {
		// TODO Auto-generated method stub
		for(Observer o : l){
			dataChange(o);
		}
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
}
