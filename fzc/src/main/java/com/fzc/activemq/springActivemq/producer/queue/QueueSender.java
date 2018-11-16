package com.fzc.activemq.springActivemq.producer.queue;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component("queueSender1")
public class QueueSender {
	@Autowired
	@Qualifier("jmsQueueTemplate")
	private JmsTemplate jqt;
	
	public void queueSend(String destination ,final String msg){
		jqt.send(destination, new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createTextMessage(msg);
			}
		});;
		
	}

}
