package com.fzc.springtest.test1;


import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class Chinese implements Person {
//	@Resource(name="stoneAxe")
	private Axe axe;
	private static String ss;
	
	public Axe getAxe() {
		return axe;
	}

	public void setAxe(Axe axe) {
		this.axe = axe;
	}

	public Chinese() {
//		System.out.println("Chinese constructor");
		System.out.println(ss);
	}
	
	public void useAxe() {
		System.out.println("Chinese useAxe "+ss);
		axe.cut();
	}

	public String getSs() {
		return ss;
	}

	public void setSs(String ss) {
		this.ss = ss;
	}

}
