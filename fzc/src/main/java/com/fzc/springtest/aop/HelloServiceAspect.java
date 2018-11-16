package com.fzc.springtest.aop;

public class HelloServiceAspect {
	public void beforeAdvice(){
		System.out.println("before advice");
	}
	
	public void afterAdvice(){
		System.out.println("after advice");
	}
	
	public void afterAdvice(String param){
		System.out.println("after advice "+param);
	}

	public void afterReturningAdvice(String param){
		System.out.println("after returning advice "+param);
	}
	
	public void afterThrowingAdvice(Exception ex1){
		System.out.println("after returning advice "+ex1);
	}
	
	public void afterAdvice(String name,String age){
		System.out.println("after advice "+name+"---"+ age);
	}
}
