package com.fzc.javatest.shejimoshi.factory.absfactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.fzc.javatest.shejimoshi.factory.pizza.AmericaPizza;
import com.fzc.javatest.shejimoshi.factory.pizza.ChinesePizza;
import com.fzc.javatest.shejimoshi.factory.pizza.Pizza;

public class OrderPizza {
	private AbsFactory absFactory;
	
	public AbsFactory getAbsFactory() {
		return absFactory;
	}

	public void setAbsFactory(AbsFactory absFactory) {
		this.absFactory = absFactory;
	}

	public void orderPizza() {
		// TODO Auto-generated method stub
		Pizza pizza = null;
		do {
			try {
				String type = getType();
				if("exit".equals(type)){
					break;
				}
				pizza = absFactory.getPizza(type);
				if(pizza != null){
					pizza.prepare();
					pizza.bake();
					pizza.cut();
				}else{
					System.out.println("wrong type!");
					continue;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (true);
	}

	private static String getType() throws IOException {
		String type = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("input Pizza type:");
		type = br.readLine();
		return type;
	}

}
