package com.fzc.activemq.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSReceiver {
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String BROKERURL = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	public static void main(String[] args){
		ConnectionFactory cf ;
		Connection c;
		Session s ;
		Destination d ;
		MessageConsumer mc ;
		cf = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKERURL);
		try {
			c = cf.createConnection();
			c.start();
			s = c.createSession(false, Session.AUTO_ACKNOWLEDGE);
			d = s.createQueue("fzc");
			mc = s.createConsumer(d);
			
			while(true){
				TextMessage tm = (TextMessage) mc.receive();
				System.out.println(tm.getText());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
