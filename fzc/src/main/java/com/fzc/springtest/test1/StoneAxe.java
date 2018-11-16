package com.fzc.springtest.test1;

import org.springframework.stereotype.Component;

@Component
public class StoneAxe implements Axe{

	public StoneAxe() {
//		System.out.println("StoneAxe constructor");
	}

	public void cut() {
		System.out.println("StoneAxe cut");
	}

}
