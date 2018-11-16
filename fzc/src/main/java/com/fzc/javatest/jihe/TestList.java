package com.fzc.javatest.jihe;

import java.util.ArrayList;

public class TestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b = new Book();
		ArrayList<Book> l = new ArrayList<Book>();
		l.add(b);
		System.out.println(l);
		b.setName("book");
		b.setWriter("胖胖胖");
		b.setPrice(22);
		System.out.println(l);
	}

}
