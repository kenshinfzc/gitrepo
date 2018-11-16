package com.fzc.springtest.aop;

public class HelloService implements IHelloService {

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		System.out.println("say hello");
		return "fuck off";
	}

	@Override
	public void sayByeBye() {
		// TODO Auto-generated method stub
		System.out.println("say bye bye");
	}

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("say hello "+name);
		return  "rtn "+name ;
	}

	@Override
	public void sayHello(String name, String age) {
		// TODO Auto-generated method stub
		System.out.println("say hello "+name+"---"+ age);
	}

	@Override
	public void sayHelloException() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("say hello exception");
		throw new Exception("sayHelloException");
	}

}
