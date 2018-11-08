package com.czf;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.czf.manager.CompletionManager;
import com.czf.util.SpringContextUtil;

@WebServlet(urlPatterns="/init",loadOnStartup=1)
public class InitServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("InitServlet init lalala!");
		CompletionManager cm = (CompletionManager)SpringContextUtil.getInstance().getBean("completionManager");
		cm.print();
		cm.start(3);
	}
}
