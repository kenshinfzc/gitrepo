package com.czf.weixin.message.qrcode;

/**
 * ��ά�볡��
 * @author FENGZHI
 * @date 2016��10��5��
 */
public class QRScene {
	//����ֵID����ʱ��ά��ʱΪ32λ��0���ͣ����ö�ά��ʱ���ֵΪ100000��Ŀǰ����ֻ֧��1--100000��
	private String sceneId;
	//����ֵID���ַ�����ʽ��ID�����ַ������ͣ���������Ϊ1��64�������ö�ά��֧�ִ��ֶ� 
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
