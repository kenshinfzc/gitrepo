package com.fzc.springtest.test1;

import org.springframework.stereotype.Component;

@Component
public class IronAxe implements Axe{

	public IronAxe() {
//		System.out.println("IronAxe construtor");
	}

	public void cut() {
		System.out.println("IronAxe cut");
	}

}
