package com.czf.weixin.message.qrcode;

/**
 * 微信二维码ticket返回
 * @author FENGZHI
 * @date 2016年10月5日
 */
public class QRResp {
	//获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
	private String ticket;
	//该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）。
	private Long expire_seconds;
	//二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片 
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
