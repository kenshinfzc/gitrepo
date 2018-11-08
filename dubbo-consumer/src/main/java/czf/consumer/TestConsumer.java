package czf.consumer;

import javax.servlet.ServletConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import czf.api.Provider;


public class TestConsumer {
	public static void main(String[] args){
//		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("consumer.xml");

		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/*.xml");
		Provider privi = ac.getBean(Provider.class);
		String aa = privi.sayHello();
		System.out.println("TestConsumer:"+aa);
	}
}
