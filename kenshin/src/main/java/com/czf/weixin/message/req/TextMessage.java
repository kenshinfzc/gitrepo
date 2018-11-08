package com.czf.weixin.message.req;

/**
 * 文本消息
 * @author FENGZHI
 * @date 2016年8月28日
 */
public class TextMessage extends BaseMessage {
	//消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
	

}
