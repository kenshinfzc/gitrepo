package com.fzc.activemq.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSSubscriber {
	private static final String USER = ActiveMQConnection.DEFAULT_USER;
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String BTOKERURL =ActiveMQConnection.DEFAULT_BROKER_URL;
	
	public JMSSubscriber() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionFactory cf ;
		Connection c ;
		Session s ;
		Destination d ;
		MessageConsumer mc ;
		MessageConsumer mc1;
		cf = new ActiveMQConnectionFactory(USER, PASSWORD, BTOKERURL);
		try {
			c = cf.createConnection();
			s = c.createSession(true, Session.AUTO_ACKNOWLEDGE);
			d = s.createTopic("fzcTopic");
			mc = s.createConsumer(d);
			
			mc.setMessageListener(new MessageListener() {
				
				public void onMessage(Message tm) {
					try {
						System.out.println(((TextMessage) tm).getText());
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			});
			
			mc1 = s.createConsumer(d);
			mc1.setMessageListener(new MessageListener() {
				
				public void onMessage(Message tm) {
					// TODO Auto-generated method stub
					try {
						System.out.println(((TextMessage) tm).getText());
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
			});
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
