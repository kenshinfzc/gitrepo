package com.fzc.springtest.orm.hibernate;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;


public class HibernateTemplateTest {
	
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SessionFactory sessionFactory =  ctx.getBean("sessionFactotry",SessionFactory.class);
		HibernateTemplate ht = new HibernateTemplate(sessionFactory);
		Book b = new Book();
		b.setBook_id("11");
		b.setBook_name("book11");
		b.setBook_desc("book11d");
		ht.save(b);
	}

}
