package com.czf.weixin.message.resp;

import java.util.List;

/**
 * ͼ����Ϣ
 * @author FENGZHI
 * @date 2016��8��29��
 */
public class NewsMessage {
	//ͼ����Ϣ����������Ϊ10������ 
	private String ActicleCount;
	//����ͼ����Ϣ��Ϣ��Ĭ�ϵ�һ��itemΪ��ͼ,ע�⣬���ͼ��������10���򽫻�����Ӧ 
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
