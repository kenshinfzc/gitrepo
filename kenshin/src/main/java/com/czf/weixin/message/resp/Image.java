package com.czf.weixin.message.resp;
/**
 * 图片Image
 * @author FENGZHI
 * @date 2016年8月29日
 */
public class Image {
	//通过素材管理接口上传多媒体文件，得到的id。
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	
}
