package com.czf.weixin.service;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.czf.weixin.message.resp.TextMessage;
import com.czf.weixin.util.MessageUtil;

/**
 * �������࣬����post����
 * @author FENGZHI
 * @date 2016��8��31��
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
				respContent = "�ı���Ϣ��"+toUserName+","+fromUserName+","+createTime+","+msgType+","+msgId;
			}else if(msgType.equals(MessageUtil.REQ_MSG_IMAGE)){
				respContent = "ͼƬ��Ϣ��"+toUserName+","+fromUserName+","+createTime+","+msgType+","+msgId;
			}else if(msgType.equals(MessageUtil.REQ_MSG_LINK)){
				respContent = "������Ϣ��"+toUserName+","+fromUserName+","+createTime+","+msgType+","+msgId;
			}else if(msgType.equals(MessageUtil.REQ_MSG_LOCATION)){
				respContent = "λ����Ϣ��"+toUserName+","+fromUserName+","+createTime+","+msgType+","+msgId;
			}else if(msgType.equals(MessageUtil.REQ_MSG_VIDEO)){
				respContent = "��Ƶ��Ϣ��"+toUserName+","+fromUserName+","+createTime+","+msgType+","+msgId;
			}else if(msgType.equals(MessageUtil.REQ_MSG_SHORTVIDEO)){
				respContent = "С��Ƶ��Ϣ��"+toUserName+","+fromUserName+","+createTime+","+msgType+","+msgId;
			}else if(msgType.equals(MessageUtil.REQ_MSG_VOICE)){
				respContent = "������Ϣ��"+toUserName+","+fromUserName+","+createTime+","+msgType+","+msgId;
			}else if(msgType.equals(MessageUtil.REQ_MSG_EVENT)){
				String eventType = map.get("Event");
				if(eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)){
					respContent = "лл���Ĺ�ע��";
				}else if(eventType.equals(MessageUtil.EVNET_TYPE_UNSUBSCRIBE)){
					respContent = "��ӭ�´ι�ע��";
				}else if(eventType.equals(MessageUtil.EVNET_TYPE_CLICK)){
					respContent = "�Զ���˵�����¼���";
					String eventKey = map.get("EventKey");
					if("sb".equals(eventKey)){
						respContent = "SB��ã�SB�ټ���";
					}
				}else if(eventType.equals(MessageUtil.EVENT_TYPE_SCAN)){
					respContent = "ɨ���¼���";
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
