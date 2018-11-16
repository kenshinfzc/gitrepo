package com.fzc.springtest.aop;

public interface IHelloService {
	public String sayHello();
	public String sayHello(String name);
	public void sayHello(String name,String age);
	public void sayByeBye();
	public void sayHelloException() throws Exception;
}
