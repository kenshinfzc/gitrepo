package czf.provider;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProvider1 {
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring-provider.xml");
		ProviderIml1 p1 = (ProviderIml1)ac.getBean("p1");
		p1.sayHello();
	}
}
