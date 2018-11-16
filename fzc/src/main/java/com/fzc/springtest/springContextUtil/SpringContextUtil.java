package com.fzc.springtest.springContextUtil;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.annotations.Since;
@Component
@Lazy(value=false)
public class SpringContextUtil implements ApplicationContextAware {
	private static ApplicationContext applicationContext;
	 
	@Override
	public void setApplicationContext(ApplicationContext applicationContext){
		System.out.println("-----SpringContextUtil-------");
		this.applicationContext = applicationContext;
	}
 
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}
 
	public static Object getBean(String name) throws BeansException{
		return applicationContext.getBean(name);
	}


}
