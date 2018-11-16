package com.fzc.javatest.shejimoshi.builder.builder;

import com.fzc.javatest.shejimoshi.builder.vacation.Vacation;

public class BuilderSelf {
	public Vacation vacation;
	public BuilderSelf(String date) {
		// TODO Auto-generated constructor stub
		vacation = new Vacation(date);
	}

	
	public BuilderSelf addDay() {
		// TODO Auto-generated method stub
		vacation.addDay();
		return this;
	}

	
	public BuilderSelf addHotel(String hotel) {
		// TODO Auto-generated method stub
		vacation.addHotel(hotel);
		return this;
	}

	
	public BuilderSelf addTickets(String ticket) {
		// TODO Auto-generated method stub
		vacation.addTicket(ticket);
		return this;
	}

	
	public BuilderSelf addEvents(String event) {
		// TODO Auto-generated method stub
		vacation.addEvent(event);
		return this;
	}

	public Vacation getVacation(){
		return vacation;
	}
}
