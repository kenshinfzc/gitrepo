package com.czf.weixin.message.resp;

/**
 * ͼƬ��Ϣ
 * @author FENGZHI
 * @date 2016��8��28��
 */
public class ImageMessage extends BaseMessage {
	//ͼƬ��Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ�
	private Image Image;

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}
	
}
