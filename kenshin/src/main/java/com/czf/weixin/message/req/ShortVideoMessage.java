package com.czf.weixin.message.req;

/**
 * ��Ƶ��Ϣ
 * @author FENGZHI
 * @date 2016��8��28��
 */
public class ShortVideoMessage extends BaseMessage {
	//��Ƶ��Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ� 
	private String MediaId;
	//��Ƶ��Ϣ����ͼ��ý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ� 
	private String ThumbMediaId ;
	
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
}
