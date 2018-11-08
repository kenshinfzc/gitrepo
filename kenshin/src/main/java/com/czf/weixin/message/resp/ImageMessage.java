package com.czf.weixin.message.resp;

/**
 * 图片消息
 * @author FENGZHI
 * @date 2016年8月28日
 */
public class ImageMessage extends BaseMessage {
	//图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	private Image Image;

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}
	
}
