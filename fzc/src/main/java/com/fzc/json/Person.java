package com.fzc.json;

import java.util.Date;

public class Person {
	private String name;
	private int age;
	private Date time;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person [name="+name+",age="+age+",time="+time+"]";
	}
}
