package com.fzc.javatest.shejimoshi.flyweight;

import java.util.ArrayList;

public class TreeTest {
	private ArrayList<Tree> trees = new ArrayList<Tree>();

	public TreeTest() {
		// TODO Auto-generated constructor stub
		for(int i=0;i<10000000;i++){
			trees.add(new Tree((int)Math.random()*100, (int)Math.random()*100, (int)Math.random()*100));
		}
	}
	
	public void display(){
		for(Tree t :trees){
			t.display();
		}
	}

}
