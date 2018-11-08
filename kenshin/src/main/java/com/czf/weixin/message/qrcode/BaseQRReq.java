package com.czf.weixin.message.qrcode;

/**
 * 永久二维码
 * @author FENGZHI
 * @date 2016年10月5日
 */
public class BaseQRReq {
	//二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久,QR_LIMIT_STR_SCENE为永久的字符串参数值 
	private String action_name;
	//二维码详细信息 
	private QRScene action_info;
	public String getAction_name() {
		return action_name;
	}
	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}
	public QRScene getAction_info() {
		return action_info;
	}
	public void setAction_info(QRScene action_info) {
		this.action_info = action_info;
	}
	


}
