package com.fzc.springtest.test1;

public class China implements Person {

	private StoneAxe ironAxe;
	
	public China() {
//		System.out.println("China constructor");
	}

	public StoneAxe getIronAxe() {
		return ironAxe;
	}

	public void setStoneAxe(StoneAxe ironAxe) {
		this.ironAxe = ironAxe;
	}
	
	public void useAxe(){
		System.out.println("China useAxe");
		ironAxe.cut();
	}

}
