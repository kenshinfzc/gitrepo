package com.czf.weixin.message.resp;

/**
 * ͼƬ��Ϣ
 * @author FENGZHI
 * @date 2016��8��28��
 */
public class ImageMessage1 extends BaseMessage {
	//ͼƬ����
	private String PicUrl;
	//ͼƬ��Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ�
	private String MediaId;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	
	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
