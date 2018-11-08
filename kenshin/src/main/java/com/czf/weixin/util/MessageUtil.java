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
 * ��Ϣ�����࣬������Ϣ������������Ϣ��װ
 * @author FENGZHI
 * @date 2016��8��29��
 */
public class MessageUtil {
	//������Ϣ���ͣ��ı�
	public static final String REQ_MSG_TEXT = "text";
	//������Ϣ���ͣ�ͼƬ
	public static final String REQ_MSG_IMAGE = "image";
	//������Ϣ���ͣ�����
	public static final String REQ_MSG_LINK = "link";
	//������Ϣ���ͣ�λ��
	public static final String REQ_MSG_LOCATION = "location";
	//������Ϣ���ͣ���Ƶ
	public static final String REQ_MSG_VIDEO = "video";
	//������Ϣ���ͣ�С��Ƶ
	public static final String REQ_MSG_SHORTVIDEO = "shortvideo";
	//������Ϣ���ͣ�����
	public static final String REQ_MSG_VOICE = "voice";
	
	//������Ϣ���ͣ��ı�
	public static final String RESP_MSG_TEXT = "text";
	//������Ϣ���ͣ�ͼƬ
	public static final String RESP_MSG_IMAGE = "image";
	//������Ϣ���ͣ�����
	public static final String RESP_MSG_MUSIC = "music";
	//������Ϣ���ͣ���Ƶ
	public static final String RESP_MSG_VIDEO = "video";
	//������Ϣ���ͣ�����
	public static final String RESP_MSG_VOICE = "voice";
	//������Ϣ���ͣ�ͼ��
	public static final String RESP_MSG_NEWS = "news";
	
	//������Ϣ���ͣ��¼�����
	public static final String REQ_MSG_EVENT = "event";
	//�¼����ͣ�����
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
	//�¼����ͣ�ȡ������
	public static final String EVNET_TYPE_UNSUBSCRIBE = "unsubscribe";
	//�¼����ͣ��Զ���˵����
	public static final String EVNET_TYPE_CLICK = "CLICK";
	//�¼����ͣ�ɨ��
	public static final String EVENT_TYPE_SCAN = "SCAN";
	
		
	/**
	 * ����΢�ŷ���������XML��
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public static Map<String,String> parseXML(HttpServletRequest request) throws Exception{
		//����������洢��HashMap��
		Map<String,String> map = new HashMap<String, String>();
		// ��request��ȡ��������  
		InputStream is = request.getInputStream();
		// ��ȡ������  
		SAXReader reader = new SAXReader();
		// �õ�xml�ĵ� 
		Document document = reader.read(is);
		// �õ�xml��Ԫ��  
		Element root = document.getRootElement();
		// �õ���Ԫ�ص������ӽڵ�List  
		List<Element> eList = root.elements();
		//���������ӽڵ�  
		for(Element e:eList){
			map.put(e.getName(), e.getText());
		}
		is.close();
		is = null;
		
		return map;
	}
	
	/**
	 * �ı���Ϣ����ת����xml
	 * @param textMessage
	 * @return
	 */
	public static String TestMessageToXML(TextMessage textMessage){
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}
	
	/**
	 * ͼƬ��Ϣ����ת����xml
	 * @param imageMessage
	 * @return
	 */
	public static String ImageMessageToXML(ImageMessage imageMessage){
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}
	
	/**
	 * ������Ϣ����ת����xml
	 * @param musicMessage
	 * @return
	 */
	public static String MusicMessageToXML(MusicMessage musicMessage){
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}
	
	/**
	 * ������Ϣ����ת����xml
	 * @param vioceMessage
	 * @return
	 */
	public static String VioceMessageToXML(VioceMessage vioceMessage){
		xstream.alias("xml", vioceMessage.getClass());
		return xstream.toXML(vioceMessage);
	}
	
	/**
	 * ��Ƶ��Ϣ����ת����xml
	 * @param videoMessage
	 * @return
	 */
	public static String VideoMessageToXML(VideoMessage videoMessage){
		xstream.alias("xml", videoMessage.getClass());
		return xstream.toXML(videoMessage);
	}
	
	/**
	 * ͼ����Ϣ����ת����xml
	 * @param newsMessage
	 * @return
	 */
	public static String NewsMessageToXML(NewsMessage newsMessage){
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(newsMessage);
	}
	
	/**
	 * ��չxstream��ʹ��֧��CDATA�� 
	 */
	private static XStream xstream = new XStream(new XppDriver() {  
	    public HierarchicalStreamWriter createWriter(Writer out) {  
	        return new PrettyPrintWriter(out) {  
	            // ������xml�ڵ��ת��������CDATA���  
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
