package com.czf.weixin.message.token;

/**
 * ��ҳ��Ȩ�ӿڵ���ƾ֤token,ע�⣺��access_token�����֧�ֵ�access_token��ͬ 
 * @author FENGZHI
 * @date 2016��9��4��
 */
public class OAuthAccessToken extends AccessToken{
	//�û�ˢ��access_token
	private String refresh_token;
	//�û�Ψһ��ʶ����ע�⣬��δ��ע���ں�ʱ���û����ʹ��ںŵ���ҳ��Ҳ�����һ���û��͹��ں�Ψһ��OpenID 
	private String openid ;
	//�û���Ȩ��������ʹ�ö��ţ�,���ָ� 
	private String scope;
	
	
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
}
