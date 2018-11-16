package com.fzc.activemq.springActivemq.consumer.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component(value="queueReceiver2")
public class QueueReceiver2 implements MessageListener{

	public void onMessage(Message msg) {
		// TODO Auto-generated method stub
		try {
			System.out.println("QueueReceiver2收到消息:"+((TextMessage) msg).getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
