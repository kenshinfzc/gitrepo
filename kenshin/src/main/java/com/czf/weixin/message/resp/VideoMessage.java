package com.czf.weixin.message.resp;

/**
 * 视频消息
 * @author FENGZHI
 * @date 2016年8月28日
 */
public class VideoMessage extends BaseMessage {
	//视频Video
	private Video Video;

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		Video = video;
	}
	
	

}
