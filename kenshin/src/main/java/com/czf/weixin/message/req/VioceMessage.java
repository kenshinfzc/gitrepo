package com.czf.weixin.message.req;

/**
 * ������Ϣ
 * @author FENGZHI
 * @date 2016��8��28��
 */
public class VioceMessage extends BaseMessage {
	//������Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ�
	private String MediaId;
	//������ʽ����amr��speex�� 
	private String Format;
	
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}


}
