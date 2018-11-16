package com.fzc.javatest.shejimoshi.builder.builder;

import com.fzc.javatest.shejimoshi.builder.vacation.Vacation;

public abstract class AbsBuilder {
	public Vacation vacation;
	public AbsBuilder(String date) {
		// TODO Auto-generated constructor stub
		vacation = new Vacation(date);
	}
	public abstract void addDay();
	public abstract void addHotel(String hotel);
	public abstract void addTickets(String ticket);
	public abstract void addEvents(String event);
	public abstract void buildVacation();
	public Vacation getVacation(){
		return vacation;
	}
}
