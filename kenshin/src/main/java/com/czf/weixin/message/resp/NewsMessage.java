package com.czf.weixin.message.resp;

import java.util.List;

/**
 * 图文消息
 * @author FENGZHI
 * @date 2016年8月29日
 */
public class NewsMessage {
	//图文消息个数，限制为10条以内 
	private String ActicleCount;
	//多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应 
	private List<Article> Articles;
	
	public String getActicleCount() {
		return ActicleCount;
	}
	public void setActicleCount(String acticleCount) {
		ActicleCount = acticleCount;
	}
	public List<Article> getArticles() {
		return Articles;
	}
	public void setArticles(List<Article> articles) {
		Articles = articles;
	}
	
	
}
