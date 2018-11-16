package com.fzc.javatest.shejimoshi.template;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TeaWithHook extends HotDrink {

	@Override
	public void brew() {
		// TODO Auto-generated method stub
		System.out.println("tea brew;");
	}

	@Override
	public void addCondiments() {
		// TODO Auto-generated method stub
		System.out.println("add sugar;");
	}
	@Override
	public boolean wantCondiments(){
		System.out.println("want condiments:y/n");
		BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
		try {
			String a = is.readLine();
			if("y".equals(a)){
				return true;
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
