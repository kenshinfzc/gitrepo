package com.czf.weixin.message.menu;

/**
 * ��һ��ť
 * @author FENGZHI
 * @date 2016��8��30��
 */
public class SimpleButton extends Button {
	//�˵�����Ӧ��������
	private String type;
	//�˵�KEYֵ��������Ϣ�ӿ����ͣ�������128�ֽ� 
	private String key;
	//��ҳ���ӣ��û�����˵��ɴ����ӣ�������1024�ֽ� 
	private String url;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
