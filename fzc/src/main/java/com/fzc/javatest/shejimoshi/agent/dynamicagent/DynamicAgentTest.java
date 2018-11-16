package com.fzc.javatest.shejimoshi.agent.dynamicagent;

import java.lang.reflect.Proxy;

/*
 动态代理：
 	动态生成对象的代理对象，动态实现权限控制等功能
 */
public class DynamicAgentTest {
	
	public static void main(String[] args) {
		PersonBean person = initPerson();
		PersonBean OwnerProxy = getOwnerProxyInstance(person);
		System.out.println("Name is " + OwnerProxy.getName());
		System.out.println("Interests is " + OwnerProxy.getInterests());

		OwnerProxy.setInterests("Bowling");
		System.out.println("Interests are " + OwnerProxy.getInterests());
		OwnerProxy.setHotOrNotRating(50);
		System.out.println("Rating is " + OwnerProxy.getHotOrNotRating());
		OwnerProxy.setHotOrNotRating(40);
		System.out.println("Rating is " + OwnerProxy.getHotOrNotRating());

		System.out.println("**************");

		PersonBean nonOwnerProxy = getNonOwnerProxyInstance(person);
		System.out.println("Name is " + nonOwnerProxy.getName());
		System.out.println("Interests are " + nonOwnerProxy.getInterests());
		nonOwnerProxy.setInterests("haha");
		System.out.println("Interests are " + nonOwnerProxy.getInterests());
		nonOwnerProxy.setHotOrNotRating(60);
		System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());		
		
		
	}
	
	public static PersonBean getOwnerProxyInstance(PersonBean person){
		return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), new OwnerInvocationHandler(person));
	}
	
	public static PersonBean getNonOwnerProxyInstance(PersonBean person){
		return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), new NonOwnerInvocationHandler(person));
	}


	public static PersonBean initPerson() {
		// TODO Auto-generated constructor stub
		PersonBean person = new PersonBeanImpl();
		person.setName("zhangsan");
		person.setGender("male");
		person.setInterests("11");
		return person;
	}

}
