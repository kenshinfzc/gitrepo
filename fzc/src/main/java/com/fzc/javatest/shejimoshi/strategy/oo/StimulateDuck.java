package com.fzc.javatest.shejimoshi.strategy.oo;

import com.fzc.javatest.shejimoshi.strategy.oo.GreenHeadDuck;
import com.fzc.javatest.shejimoshi.strategy.oo.RedHeadDuck;

public class StimulateDuck {

	/**
	
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GreenHeadDuck d = new GreenHeadDuck();
		d.display();
		d.fly();
		d.swim();
		d.quack();
		RedHeadDuck r = new RedHeadDuck();
		r.display();
		r.fly();
		r.swim();
		r.quack();
	}

}
