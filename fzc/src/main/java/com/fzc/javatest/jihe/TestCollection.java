package com.fzc.javatest.jihe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class TestCollection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testCollection();

	}
	/*public void testSet(){
		Set s = new HashSet();
		
	}*/
	
	public static void testCollection(){
		Collection c = new ArrayList();
		c.add("111");
		c.add("222");/*
		c.add("333");
		c.add("11");
		c.add("22");
		c.add("33");*/
		
		System.out.println(c);
		
		/*Collection h = new HashSet();
		h.add("111");
		h.add("222");
		System.out.println(c);
		
		Collection h1  = new HashSet();
		h1.add("111");
		
		h.addAll(h1);
		System.out.println(h);*/
		
		Iterator it = c.iterator();
//		System.out.println(c.size());
		while(it.hasNext()){
			String temp = it.next().toString();
			temp = "121";
			System.out.println(temp);
			System.out.println(it.next());
			return;
//			it.remove();
		}
//		System.out.println(c.size());
		/*
		Iterator it1 = h.iterator();
		while(it1.hasNext()){
			System.out.println(it1.next());
			
		}*/
	}

}
