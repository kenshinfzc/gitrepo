package com.czf.weixin.service;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.czf.weixin.message.resp.TextMessage;
import com.czf.weixin.util.MessageUtil;

/**
 * 主处理类，处理post请求
 * @author FENGZHI
 * @date 2016年8月31日
 */
public class MainService {
	private static Logger logger = LoggerFactory.getLogger(MainService.class);

	
	public static String processRequest(HttpServletRequest request){
		String respMsg = "";
		try {
			logger.info("request:"+request);
			Map<String,String> map = MessageUtil.parseXML(request);
			logger.info("map:"+map);
			String toUserName = map.get("ToUserName");
			String fromUserName = map.get("FromUserName");
			String createTime = map.get("CreateTime");
			String msgType = map.get("MsgType");
			String msgId = map.get("MsgId");
			
			TextMessage textMsg = new TextMessage();
			textMsg.setToUserName(fromUserName);
			textMsg.setFromUserName(toUserName);
			textMsg.setCreateTime(new Date().getTime());
			textMsg.setMsgType(MessageUtil.RESP_MSG_TEXT);
			textMsg.setFuncFlag(0);
			String respContent = "";
			
			if(msgType.equals(MessageUtil.REQ_MSG_TEXT)){
				respContent = "文本消息："+toUserName+","+fromUserName+","+createTime+","+msgType+","+msgId;
			}else if(msgType.equals(MessageUtil.REQ_MSG_IMAGE)){
				respContent = "图片消息："+toUserName+","+fromUserName+","+createTime+","+msgType+","+msgId;
			}else if(msgType.equals(MessageUtil.REQ_MSG_LINK)){
				respContent = "链接消息："+toUserName+","+fromUserName+","+createTime+","+msgType+","+msgId;
			}else if(msgType.equals(MessageUtil.REQ_MSG_LOCATION)){
				respContent = "位置消息："+toUserName+","+fromUserName+","+createTime+","+msgType+","+msgId;
			}else if(msgType.equals(MessageUtil.REQ_MSG_VIDEO)){
				respContent = "视频消息："+toUserName+","+fromUserName+","+createTime+","+msgType+","+msgId;
			}else if(msgType.equals(MessageUtil.REQ_MSG_SHORTVIDEO)){
				respContent = "小视频消息："+toUserName+","+fromUserName+","+createTime+","+msgType+","+msgId;
			}else if(msgType.equals(MessageUtil.REQ_MSG_VOICE)){
				respContent = "语音消息："+toUserName+","+fromUserName+","+createTime+","+msgType+","+msgId;
			}else if(msgType.equals(MessageUtil.REQ_MSG_EVENT)){
				String eventType = map.get("Event");
				if(eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)){
					respContent = "谢谢您的关注！";
				}else if(eventType.equals(MessageUtil.EVNET_TYPE_UNSUBSCRIBE)){
					respContent = "欢迎下次关注！";
				}else if(eventType.equals(MessageUtil.EVNET_TYPE_CLICK)){
					respContent = "自定义菜单点击事件！";
					String eventKey = map.get("EventKey");
					if("sb".equals(eventKey)){
						respContent = "SB你好，SB再见！";
					}
				}else if(eventType.equals(MessageUtil.EVENT_TYPE_SCAN)){
					respContent = "扫码事件！";
				}
				
			}
			
			textMsg.setContent(respContent);
			respMsg = MessageUtil.TestMessageToXML(textMsg);
			logger.info("respMsg:"+respMsg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return respMsg;
	}
}
