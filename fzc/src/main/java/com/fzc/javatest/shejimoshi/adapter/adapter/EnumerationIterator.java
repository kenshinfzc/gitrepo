package com.fzc.javatest.shejimoshi.adapter.adapter;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationIterator implements Iterator<Object>{
	private Enumeration<Object> enumeration;
	
	public EnumerationIterator(Enumeration<Object> enumeration) {
		this.enumeration = enumeration;
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return enumeration.hasMoreElements();
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return enumeration.nextElement();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
