package com.czf.weixin.message.qrcode;

/**
 * 二维码场景
 * @author FENGZHI
 * @date 2016年10月5日
 */
public class QRScene {
	//场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	private String sceneId;
	//场景值ID（字符串形式的ID），字符串类型，长度限制为1到64，仅永久二维码支持此字段 
	private String sceneStr;
	public String getSceneId() {
		return sceneId;
	}
	public void setSceneId(String sceneId) {
		this.sceneId = sceneId;
	}
	public String getSceneStr() {
		return sceneStr;
	}
	public void setSceneStr(String sceneStr) {
		this.sceneStr = sceneStr;
	}
	

}
