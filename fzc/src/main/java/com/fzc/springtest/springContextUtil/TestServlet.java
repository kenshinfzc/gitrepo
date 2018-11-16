package com.fzc.springtest.springContextUtil;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.fzc.springtest.jdbc.JdbcTemplateClient;
import com.fzc.springtest.orm.ibatis.IbatisTest;
import com.fzc.springtest.orm.ibatis.SqlMapClientTemplateUtil;


public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TestServlet.class);

    public TestServlet() {
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("TestServlet");
//		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		ApplicationContext context = SpringContextUtil.getApplicationContext();
		Test1 t = (Test1) context.getBean("test1");
		String aa = t.sayYes();
		log.info("log:"+aa);
	}

}