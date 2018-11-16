package com.fzc.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieTest extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.service(arg0, arg1);
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		Cookie[] cookies = req.getCookies();
		if(cookies!=null){
			for(Cookie c :cookies){
				System.out.println(c.getName()+":"+c.getValue());
			}
		}
		
		Cookie cookie = new Cookie("username", "fzc");
		//cookie.setDomain("/cookieTest/");
		cookie.setMaxAge(5000);
		resp.addCookie(cookie);
		req.getRequestDispatcher("/cookieTest.jsp").forward(req, resp);
	}

}
