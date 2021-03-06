package com.czf.weixin.message.resp;

/**
 * 图片消息
 * @author FENGZHI
 * @date 2016年8月28日
 */
public class ImageMessage1 extends BaseMessage {
	//图片链接
	private String PicUrl;
	//图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
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
