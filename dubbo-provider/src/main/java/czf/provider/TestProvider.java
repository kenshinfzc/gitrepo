package czf.provider;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProvider {
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("provider.xml");
		ac.start();
		System.in.read();
	}
}
