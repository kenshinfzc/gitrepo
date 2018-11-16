package com.fzc.activemq.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSSender {
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String BTOKERURL = ActiveMQConnection.DEFAULT_BROKER_URL;
	private static final int NUM = 5;
	
	public static void main(String[] args){
		ConnectionFactory cf;
		Connection c;
		Session s;
		Destination d;
		MessageProducer mp;
		cf = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BTOKERURL);
		
		try {
			c = cf.createConnection();
			c.start();
			s = c.createSession(true, Session.AUTO_ACKNOWLEDGE);
			d = s.createQueue("fzc");
			mp = s.createProducer(d);
			for(int i=0;i<NUM;i++){
				TextMessage tm = s.createTextMessage("ActinveMQ 发送消息 queue:"+i);
				System.out.println(tm.toString());
				mp.send(tm);
			}
			s.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
