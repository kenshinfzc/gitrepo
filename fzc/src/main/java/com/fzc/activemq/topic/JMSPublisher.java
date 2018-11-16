package com.fzc.activemq.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSPublisher {
	private static final String USER = ActiveMQConnection.DEFAULT_USER;
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String BTOKERURL =ActiveMQConnection.DEFAULT_BROKER_URL;
	private static final int NUM = 5; 

	public JMSPublisher() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionFactory cf ;
		Connection c;
		Session s;
		Destination d;
		MessageProducer mp;
		cf = new ActiveMQConnectionFactory(USER, PASSWORD, BTOKERURL);
		
		try {
			c = cf.createConnection();
			c.start();
			s = c.createSession(false, Session.AUTO_ACKNOWLEDGE);
			d = s.createTopic("fzcTopic");
			mp = s.createProducer(d);
			
			for(int i=0;i<NUM;i++){
				TextMessage tm = s.createTextMessage("JMS 发送消息 topic:"+i);
				System.out.println(tm.getText());
				mp.send(tm);
			}
			s.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
