package com.fzc.springtest.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;

public class test1 {

	public test1() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] arg){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
//		JdbcTemplateClient c = ctx.getBean("jdbcTemplateClient",JdbcTemplateClient.class);
//		c.getJdbcTemplateClient();
		/*
		//����
		c.execute("create table book (book_id int(4),book_name varchar(100),book_desc varchar(100))");
		//��ɾ�Ĳ�
		c.update("insert into book(book_id,book_name,book_desc) values (1,'book1','book1d')");
		c.batchUpdate(new String[]{"insert into book(book_id,book_name,book_desc) values (2,'book2','book2d')","insert into book(book_id,book_name,book_desc) values (3,'book3','book3d')","insert into book(book_id,book_name,book_desc) values (4,'book4','book4d')"});
		c.update("update book set book_name = 'book22' where book_id = 2");
		c.update("delete from book where book_id = 3;");
		c.queryForList("select * from book");
		*/
		/*
		//Ԥ����
		c.preparedStatementCreator();
		//��ֵ ���� 
		c.preparedStatementSetter();
		c.queryForList("select * from book where book_id = 2");
		//���������
		c.rowMapper();
		c.rowCallBackHandler();
		c.resultSetExtractor();
		*/
		
//		c.call();
//		c.test();
//		c.insertKey();
	}
}
 