package com.czf.weixin.message.qrcode;

/**
 * ΢�Ŷ�ά��ticket����
 * @author FENGZHI
 * @date 2016��10��5��
 */
public class QRResp {
	//��ȡ�Ķ�ά��ticket��ƾ���ticket��������Чʱ���ڻ�ȡ��ά�롣
	private String ticket;
	//�ö�ά����Чʱ�䣬����Ϊ��λ�� ��󲻳���2592000����30�죩��
	private Long expire_seconds;
	//��ά��ͼƬ������ĵ�ַ�������߿ɸ��ݸõ�ַ����������Ҫ�Ķ�ά��ͼƬ 
	private String url;
	
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public Long getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(Long expire_seconds) {
		this.expire_seconds = expire_seconds;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
