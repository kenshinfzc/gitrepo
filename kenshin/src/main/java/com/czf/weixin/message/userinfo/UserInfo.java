package com.czf.weixin.message.userinfo;

import com.alibaba.fastjson.JSONArray;

public class UserInfo {
	//�û���Ψһ��ʶ
	private String openid;
	//�û��ǳ�
	private String nickname;
	// �û����Ա�ֵΪ1ʱ�����ԣ�ֵΪ2ʱ��Ů�ԣ�ֵΪ0ʱ��δ֪ 
	private String sex;
	//�û�����������д��ʡ��
	private String province; 
	//��ͨ�û�����������д�ĳ���
	private String city;
	// ���ң����й�ΪCN 
	private String country;
	// �û�ͷ�����һ����ֵ����������ͷ���С����0��46��64��96��132��ֵ��ѡ��0����640*640������ͷ�񣩣��û�û��ͷ��ʱ����Ϊ�ա����û�����ͷ��ԭ��ͷ��URL��ʧЧ�� 
	private String headimgurl;
	//ֻ�����û������ںŰ󶨵�΢�ſ���ƽ̨�ʺź󣬲Ż���ָ��ֶΡ��������ȡ�û�������Ϣ��UnionID���ƣ�
	private String unionid;
	// �û���Ȩ��Ϣ��json ���飬��΢���ֿ��û�Ϊ��chinaunicom�� 
	private JSONArray privilege;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public JSONArray getPrivilege() {
		return privilege;
	}

	public void setPrivilege(JSONArray privilege) {
		this.privilege = privilege;
	}
	
}
