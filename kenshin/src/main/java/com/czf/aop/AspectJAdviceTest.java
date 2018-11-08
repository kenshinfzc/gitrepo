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
	//ֻ��Ŀ�귽��ִ��֮ǰֲ����ǿ�������Ŀ�귽��ִ�У�Ҳ�޷���ȡĿ�귽�����
	@Before("execution(* service.impl.*.*(..))")
	public void authority(JoinPoint jp){
		System.out.println("AspectJAdviceTest.authority(),��ֲ��� Ŀ�귽���ǣ�"+jp.getSignature().getName());
	}
	
	//ֻ��Ŀ�귽����ɺ�ֲ����ǿ
	@AfterReturning(returning="rtn",pointcut="execution(* service.impl.*.*(..))")
	public void testAfterReturning(Object rtn,JoinPoint jp){
		System.out.println("AspectJAdviceTest.testAfterReturning(),��ֲ��� Ŀ�귽���ǣ�"+jp.getSignature().getName()+",Ŀ�귽�����ز�����"+rtn);
	}
	
	//����Ŀ�귽��ִ����ν����������ɹ���ɺ��쳣��ֹ������ֲ��
	@After("execution(* service.impl.*.*(..))")
	public void testAfter(JoinPoint jp){
		System.out.println("AspectJAdviceTest.testAfter(),��ֲ��� Ŀ�귽���ǣ�"+jp.getSignature().getName());
	}
	

}
