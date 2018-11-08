package com.czf.weixin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.czf.weixin.message.token.OAuthAccessToken;
import com.czf.weixin.message.userinfo.UserInfo;
import com.czf.weixin.util.WeiXinUtil;


@WebServlet(name="oauth",urlPatterns="/oauth")
public class OAuth2Servlet extends HttpServlet{
	private static Logger log = LoggerFactory.getLogger(OAuth2Servlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		log.info("I'm in post OAuth2Servlet");
		String code  = req.getParameter("code");
		String state = req.getParameter("state");
		log.info("code:{},state:{}\n",code,state);
		if(!"".equals(code) && null != code){
			OAuthAccessToken oAuthAccessToken = WeiXinUtil.getOAuthAccessToken(code);
			log.info("oAuthAccessToken:{}\n",JSONObject.toJSONString(oAuthAccessToken));
			if(null != oAuthAccessToken){
				UserInfo userInfo = WeiXinUtil.getUserInfo(oAuthAccessToken);
				log.info("useuInfo:{}\n",JSONObject.toJSONString(userInfo));
			}
		}else{
			log.error("ÓÃ»§½ûÖ¹ÊÚÈ¨£¡");
		}
	}
	
}
