package com.czf.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectJAdviceTest {
	
	public AspectJAdviceTest() {
		// TODO Auto-generated constructor stub
	}
	//只在目标方法执行之前植入增强，不理会目标方法执行，也无法获取目标方法结果
	@Before("execution(* service.impl.*.*(..))")
	public void authority(JoinPoint jp){
		System.out.println("AspectJAdviceTest.authority(),被植入的 目标方法是："+jp.getSignature().getName());
	}
	
	//只在目标方法完成后植入增强
	@AfterReturning(returning="rtn",pointcut="execution(* service.impl.*.*(..))")
	public void testAfterReturning(Object rtn,JoinPoint jp){
		System.out.println("AspectJAdviceTest.testAfterReturning(),被植入的 目标方法是："+jp.getSignature().getName()+",目标方法返回参数："+rtn);
	}
	
	//不管目标方法执行如何结束（包括成功完成和异常终止）。都植入
	@After("execution(* service.impl.*.*(..))")
	public void testAfter(JoinPoint jp){
		System.out.println("AspectJAdviceTest.testAfter(),被植入的 目标方法是："+jp.getSignature().getName());
	}
	

}
