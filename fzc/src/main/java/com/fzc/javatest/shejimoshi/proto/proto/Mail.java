package com.fzc.javatest.shejimoshi.proto.proto;


import java.util.ArrayList;

import com.fzc.javatest.shejimoshi.proto.EventTemplate;

public class Mail implements Cloneable{
	private String receiver;
	private String subject;
	private String content;
	private String tail;
	private ArrayList<String> arr;

	public Mail(EventTemplate et) {
		this.tail = et.geteventContent();
		this.subject = et.geteventSubject();
		this.arr = new ArrayList<String>();
	}

	@Override
	protected Object clone() {
		// TODO Auto-generated method stub
		Mail mail = null;
		try {
			mail = (Mail) super.clone();
			mail.arr = (ArrayList<String>) this.arr.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mail;
	}
	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public String getTail() {
		return tail;
	}

	public void setTail(String tail) {
		this.tail = tail;
	}
	/**
	 * @return the arr
	 */
	public ArrayList<String> getArr() {
		return arr;
	}

	/**
	 * @param arr the arr to set
	 */
	public void setArr(ArrayList<String> arr) {
		this.arr = arr;
	}

}
