package com.czf.weixin.message.qrcode;

/**
 * ��ʱ��ά��
 * @author FENGZHI
 * @date 2016��10��5��
 */
public class TempQRReq extends BaseQRReq {
	//�ö�ά����Чʱ�䣬����Ϊ��λ�� ��󲻳���2592000����30�죩�����ֶ���������Ĭ����Ч��Ϊ30�롣
	private Long expire_seconds;

	public Long getExpire_seconds() {
		return expire_seconds;
	}

	public void setExpire_seconds(Long expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

	

}
