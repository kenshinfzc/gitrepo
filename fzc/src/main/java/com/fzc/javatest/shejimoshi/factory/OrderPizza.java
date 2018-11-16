package com.fzc.javatest.shejimoshi.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.fzc.javatest.shejimoshi.factory.pizza.AmericaPizza;
import com.fzc.javatest.shejimoshi.factory.pizza.ChinesePizza;
import com.fzc.javatest.shejimoshi.factory.pizza.Pizza;

public class OrderPizza {
	
	/**
	 * 对象创建逻辑与主程序耦合度高，修改对象创建逻辑需要直接修改主程序，
	 * 采用简单工厂模式，见创建对象的逻辑提取出来，主程序只调用工厂，不直接参与对象创建，实现逻辑分离   
	 * 详见 SimpleFactory
	 */
	
	public OrderPizza() {
		// TODO Auto-generated method stub
		Pizza pizza = null;
		do {
			try {
				String type = getType();
				if("exit".equals(type)){
					break;
				}else if("chinese".equals(type)){
					pizza = new ChinesePizza();
				}else if("america".equals(type)){
					pizza = new AmericaPizza();
				}else{
					pizza = null;
				}
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
