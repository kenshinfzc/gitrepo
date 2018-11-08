package com.czf.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.czf.weixin.message.token.AccessToken;

public class czftest {
	private static Logger log = LoggerFactory.getLogger(czftest.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccessToken at = new AccessToken();
		System.out.println(at == null);
		System.out.println("".equals(at));
		System.out.println(at);
		
		AccessToken at1 = null;
		System.out.println(at1 == null);
		System.out.println("".equals(at1));
		System.out.println(at1);
		
	}

}
