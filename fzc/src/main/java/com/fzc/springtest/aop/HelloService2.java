package com.fzc.springtest.aop;

public class HelloService2 implements IHelloService {

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		System.out.println("say hello 2");
		return "say hello 2";
	}

	@Override
	public void sayByeBye() {
		// TODO Auto-generated method stub
		System.out.println("say bye bye 2");
	}

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("say hello 2 "+name);
		return  "rtn 2 "+name ;
	}

	@Override
	public void sayHello(String name, String age) {
		// TODO Auto-generated method stub

		System.out.println("say hello 2 "+name+"---"+ age);
	}

	@Override
	public void sayHelloException() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
