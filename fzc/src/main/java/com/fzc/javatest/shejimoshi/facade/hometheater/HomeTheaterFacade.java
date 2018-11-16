package com.fzc.javatest.shejimoshi.facade.hometheater;

public class HomeTheaterFacade {
	Light l;
	AirConditon ac ;
	TV t ;
	Stereo s ;
	public HomeTheaterFacade(Light l,AirConditon ac,TV t,Stereo s) {
		this.l = l;
		this.ac = ac;
		this.t = t ;
		this.s = s ;
	}
	
	public void theaterOn(){
		l.lightOn();
		ac.airConditionOn();
		t.tvOn();
		s.stereoOn();
	}
	
	public void theaterOff(){
		s.stereoOff();
		t.tvOff();
		ac.airConditionOff();
		l.lightOff();
	}

}
