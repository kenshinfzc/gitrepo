package com.fzc.javatest.shejimoshi.builder.builder;

public class Builder2Days extends AbsBuilder {

	public Builder2Days(String date) {
		super(date);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addDay() {
		// TODO Auto-generated method stub
		vacation.addDay();
	}

	@Override
	public void addHotel(String hotel) {
		// TODO Auto-generated method stub
		vacation.addHotel(hotel);
	}

	@Override
	public void addTickets(String ticket) {
		// TODO Auto-generated method stub
		vacation.addTicket(ticket);
	}

	@Override
	public void addEvents(String event) {
		// TODO Auto-generated method stub
		vacation.addEvent(event);
	}

	@Override
	public void buildVacation() {
		// TODO Auto-generated method stub
		addTickets("fly to hefei;");
		addTickets("bus ticket");
		addEvents("visit baogongci ;");
		addEvents("visit baogongmu ;");
		addHotel("home inn");
		
		addDay();
		addTickets("fly to wuhan;");
		addTickets("bus ticket");
		addEvents("just walk ;");
	}

}
