package com.czf.weixin.message.token;

/**
 * ΢�Žӿ�ƾ֤
 * @author FENGZHI
 * @date 2016��8��30��
 */
public class AccessToken {
	//��ȡ����ƾ֤
	private String access_token ;
	//ƾ֤��Чʱ�䣬��λ����
	private String expires_in;
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}
}
