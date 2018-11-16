package com.fzc.activemq.springActivemq.consumer.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component(value="topicReceiver1")
public class TopicReceiver1 implements MessageListener{

	public void onMessage(Message msg) {
		// TODO Auto-generated method stub
		try {
			System.out.println("TopicReceiver1收到消息:"+((TextMessage) msg).getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
