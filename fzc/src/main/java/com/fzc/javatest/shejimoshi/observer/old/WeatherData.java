package com.fzc.javatest.shejimoshi.observer.old;

/*
             缺点：耦合度搞，添加新的对象时需要修改原逻辑，不符合开闭原则
   	建议：采用观察者模式
 */
public class WeatherData {
	private int temper;
	private int pressure;
	private int wet;
	private Condition1 c;
	private Condition2 c1;
	
	public WeatherData(Condition1 c,Condition2 c1){
		this.c = c;
		this.c1 = c1;
	}
	public void dataChange(){
		c.update(getTemper(), getPressure(), getWet());
		c1.update(getTemper(), getPressure(), getWet());
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

}
