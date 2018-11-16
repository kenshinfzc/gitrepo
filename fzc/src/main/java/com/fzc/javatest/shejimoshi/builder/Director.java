package com.fzc.javatest.shejimoshi.builder;

import com.fzc.javatest.shejimoshi.builder.builder.AbsBuilder;
import com.fzc.javatest.shejimoshi.builder.vacation.Vacation;

public class Director {
	AbsBuilder ab ;
	public Director(AbsBuilder ab ) {
		// TODO Auto-generated constructor stub
		this.ab = ab;
	}
	
	public Vacation constructVacation(){
		ab.buildVacation();
		return ab.getVacation();
	}
}
