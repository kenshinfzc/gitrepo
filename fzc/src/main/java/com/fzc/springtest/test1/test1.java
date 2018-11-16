package com.fzc.springtest.test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class test1 {

	public test1() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] arg){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Person c = ctx.getBean("chinese",Person.class);
		c.useAxe();
		
//		Person p = ctx.getBean("china",Person.class);
//		p.useAxe();
		
//		ApplicationContext ctx = new FileSystemXmlApplicationContext("file:D:/beans.xml");
//		Person c = ctx.getBean("chinese", Person.class);
//		c.useAxe();
		
//		Chinese c = new Chinese();	
//		IronAxe axe = new IronAxe();
//		c.setAxe(axe);
//		c.useAxe();
	}

}
 