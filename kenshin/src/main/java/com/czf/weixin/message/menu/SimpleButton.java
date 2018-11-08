package com.czf.weixin.message.menu;

/**
 * 单一按钮
 * @author FENGZHI
 * @date 2016年8月30日
 */
public class SimpleButton extends Button {
	//菜单的响应动作类型
	private String type;
	//菜单KEY值，用于消息接口推送，不超过128字节 
	private String key;
	//网页链接，用户点击菜单可打开链接，不超过1024字节 
	private String url;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
