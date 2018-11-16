package com.fzc.activemq.springActivemq.producer.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component("topicSender1")
public class TopicSender {
	@Autowired
	@Qualifier("jmsTopicTemplate")
	private JmsTemplate jtt;
	
	public void topicSend(String destination,final String msg){
		jtt.send(destination, new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createTextMessage(msg);
			}
		});;
	}
	

}
