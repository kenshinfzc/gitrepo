package com.czf.weixin.util;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.czf.weixin.message.resp.Article;
import com.czf.weixin.message.resp.ImageMessage;
import com.czf.weixin.message.resp.MusicMessage;
import com.czf.weixin.message.resp.NewsMessage;
import com.czf.weixin.message.resp.TextMessage;
import com.czf.weixin.message.resp.VideoMessage;
import com.czf.weixin.message.resp.VioceMessage;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * 消息工具类，请求消息解析，返回消息封装
 * @author FENGZHI
 * @date 2016年8月29日
 */
public class MessageUtil {
	//请求消息类型：文本
	public static final String REQ_MSG_TEXT = "text";
	//请求消息类型：图片
	public static final String REQ_MSG_IMAGE = "image";
	//请求消息类型：链接
	public static final String REQ_MSG_LINK = "link";
	//请求消息类型：位置
	public static final String REQ_MSG_LOCATION = "location";
	//请求消息类型：视频
	public static final String REQ_MSG_VIDEO = "video";
	//请求消息类型：小视频
	public static final String REQ_MSG_SHORTVIDEO = "shortvideo";
	//请求消息类型：语音
	public static final String REQ_MSG_VOICE = "voice";
	
	//返回消息类型：文本
	public static final String RESP_MSG_TEXT = "text";
	//返回消息类型：图片
	public static final String RESP_MSG_IMAGE = "image";
	//返回消息类型：音乐
	public static final String RESP_MSG_MUSIC = "music";
	//返回消息类型：视频
	public static final String RESP_MSG_VIDEO = "video";
	//返回消息类型：语音
	public static final String RESP_MSG_VOICE = "voice";
	//返回消息类型：图文
	public static final String RESP_MSG_NEWS = "news";
	
	//请求消息类型：事件推送
	public static final String REQ_MSG_EVENT = "event";
	//事件类型：订阅
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
	//事件类型：取消订阅
	public static final String EVNET_TYPE_UNSUBSCRIBE = "unsubscribe";
	//事件类型：自定义菜单点击
	public static final String EVNET_TYPE_CLICK = "CLICK";
	//事件类型：扫码
	public static final String EVENT_TYPE_SCAN = "SCAN";
	
		
	/**
	 * 解析微信发来的请求（XML）
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public static Map<String,String> parseXML(HttpServletRequest request) throws Exception{
		//将解析结果存储在HashMap中
		Map<String,String> map = new HashMap<String, String>();
		// 从request中取得输入流  
		InputStream is = request.getInputStream();
		// 读取输入流  
		SAXReader reader = new SAXReader();
		// 得到xml文档 
		Document document = reader.read(is);
		// 得到xml根元素  
		Element root = document.getRootElement();
		// 得到根元素的所有子节点List  
		List<Element> eList = root.elements();
		//遍历所有子节点  
		for(Element e:eList){
			map.put(e.getName(), e.getText());
		}
		is.close();
		is = null;
		
		return map;
	}
	
	/**
	 * 文本消息对象转换成xml
	 * @param textMessage
	 * @return
	 */
	public static String TestMessageToXML(TextMessage textMessage){
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}
	
	/**
	 * 图片消息对象转换成xml
	 * @param imageMessage
	 * @return
	 */
	public static String ImageMessageToXML(ImageMessage imageMessage){
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}
	
	/**
	 * 音乐消息对象转换成xml
	 * @param musicMessage
	 * @return
	 */
	public static String MusicMessageToXML(MusicMessage musicMessage){
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}
	
	/**
	 * 语音消息对象转换成xml
	 * @param vioceMessage
	 * @return
	 */
	public static String VioceMessageToXML(VioceMessage vioceMessage){
		xstream.alias("xml", vioceMessage.getClass());
		return xstream.toXML(vioceMessage);
	}
	
	/**
	 * 视频消息对象转换成xml
	 * @param videoMessage
	 * @return
	 */
	public static String VideoMessageToXML(VideoMessage videoMessage){
		xstream.alias("xml", videoMessage.getClass());
		return xstream.toXML(videoMessage);
	}
	
	/**
	 * 图文消息对象转换成xml
	 * @param newsMessage
	 * @return
	 */
	public static String NewsMessageToXML(NewsMessage newsMessage){
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(newsMessage);
	}
	
	/**
	 * 扩展xstream，使其支持CDATA块 
	 */
	private static XStream xstream = new XStream(new XppDriver() {  
	    public HierarchicalStreamWriter createWriter(Writer out) {  
	        return new PrettyPrintWriter(out) {  
	            // 对所有xml节点的转换都增加CDATA标记  
	            boolean cdata = true;  
	  
	            @SuppressWarnings("unchecked")  
	            public void startNode(String name, Class clazz) {  
	                super.startNode(name, clazz);  
	            }  
	  
	            protected void writeText(QuickWriter writer, String text) {  
	                if (cdata) {  
	                    writer.write("<![CDATA[");  
	                    writer.write(text);  
	                    writer.write("]]>");  
	                } else {  
	                    writer.write(text);  
	                }  
	            }  
	        };  
	    }  
	}); 
}
