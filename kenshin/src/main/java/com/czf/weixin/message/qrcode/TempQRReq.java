package com.czf.weixin.message.qrcode;

/**
 * 临时二维码
 * @author FENGZHI
 * @date 2016年10月5日
 */
public class TempQRReq extends BaseQRReq {
	//该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
	private Long expire_seconds;

	public Long getExpire_seconds() {
		return expire_seconds;
	}

	public void setExpire_seconds(Long expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

	

}
