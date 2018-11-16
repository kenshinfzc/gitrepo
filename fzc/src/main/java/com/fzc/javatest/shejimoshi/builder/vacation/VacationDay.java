package com.fzc.javatest.shejimoshi.builder.vacation;

import java.util.ArrayList;
import java.util.Date;

public class VacationDay {
	Date date;
	String hotel;
	ArrayList<String> tickets = new ArrayList<String>();
	ArrayList<String> events = new ArrayList<String>();
	
	public VacationDay(Date mStDate) {
		// TODO Auto-generated constructor stub
		this.date = mStDate;
	}
	
	public void addTicket(String ticket){
		tickets.add(ticket);
	}
	public void addEvent(String event){
		events.add(event);
	}
	public String showInfo(){
		StringBuilder stb = new StringBuilder();
		stb.append("Date:" + date.toString() + "\n");
		stb.append("Hotel:" + hotel + "\n");
		stb.append("Tickets:" + tickets.toString() + "\n");
		stb.append("Events" + events.toString() + "\n");

		return stb.toString();
		
	}
	
	/**
	 * @return the hotel
	 */
	public String getHotel() {
		return hotel;
	}
	/**
	 * @param hotel the hotel to set
	 */
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	
}
