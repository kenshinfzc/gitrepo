package com.czf.weixin.message.resp;
/**
 * ��ƵVideo
 * @author FENGZHI
 * @date 2016��8��29��
 */
public class Video {
	//ͨ���زĹ���ӿ��ϴ���ý���ļ����õ���id��
	private String MediaId;
	//��Ƶ��Ϣ�ı���
	private String Title;
	//��Ƶ��Ϣ������
	private String Description;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
}
