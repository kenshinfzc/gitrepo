package com.czf.weixin.message.qrcode;

/**
 * ���ö�ά��
 * @author FENGZHI
 * @date 2016��10��5��
 */
public class BaseQRReq {
	//��ά�����ͣ�QR_SCENEΪ��ʱ,QR_LIMIT_SCENEΪ����,QR_LIMIT_STR_SCENEΪ���õ��ַ�������ֵ 
	private String action_name;
	//��ά����ϸ��Ϣ 
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
