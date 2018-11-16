package com.fzc.springtest.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:beans.xml");
		IHelloService hello = (IHelloService) ctx.getBean("HelloService");
//		hello.sayHello();
//		hello.sayByeBye();
//		hello.sayHello("胖胖胖");
//		hello.sayHello("胖胖胖","是猪");
//		String rtn = hello.sayHello("胖胖胖");
//		String rtn = hello.sayHello();
//		System.out.println(rtn);
//		hello.sayHelloException();
		
//		IHelloService hello2 = (IHelloService) ctx.getBean("HelloService2");
//		hello2.sayHello();
//		hello2.sayByeBye();
		
	}
}
