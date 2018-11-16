package com.fzc.springtest.orm.ibatis;

import java.io.IOException;
import java.sql.SQLException;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.fzc.springtest.jdbc.JdbcTemplateClient;
import com.fzc.springtest.orm.ibatis.IbatisTest;
import com.fzc.springtest.orm.ibatis.SqlMapClientTemplateUtil;
import com.fzc.springtest.springContextUtil.SpringContextUtil;

@WebServlet(urlPatterns="/testIbatisSqlPrint")
public class TestIbatisSqlPrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TestIbatisSqlPrintServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("TestServlet");
		ApplicationContext context = SpringContextUtil.getApplicationContext();

//		JdbcTemplateClient jtc = context.getBean(JdbcTemplateClient.class);
//		jtc.execute("insert into book1(book_id,book_name,book_desc) values (2,'book2','book2d')");

		SqlMapClientTemplateUtil smct = context.getBean(SqlMapClientTemplateUtil.class);
		try {
			smct.insertCup1();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}