package czf.consumer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import czf.api.Provider;

/**
 * Servlet implementation class TestServlet
 */
public class TestDubboServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor. 
     */
    public TestDubboServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Consumer TestDubboServlet");
//		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/*.xml");
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		Provider provi = (Provider) ac.getBean("p1");
		String aa = provi.sayHello();
		System.out.println(aa);

		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		Test t = (Test) context.getBean("test");
		System.out.println(t.getAa());
		
	}

}
