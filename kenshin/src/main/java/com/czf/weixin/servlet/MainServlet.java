package com.czf.weixin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.czf.weixin.service.MainService;
import com.czf.weixin.util.SignUtil;
/**
 * ����ڣ�΢�Ź��ںŽ��룬��Ϣ����
 * @author FENGZHI
 * @date 2016��8��31��
 */
@WebServlet(name="main",urlPatterns="/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(MainServlet.class);
//	@Resource
//	private BookServiceImpl bookServiceImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("I'm in get MainServlet!");
		//΢�ż���ǩ��
		String signature = request.getParameter("signature");
		//ʱ���
		String timestamp = request.getParameter("timestamp");
		//�����
		String nonce = request.getParameter("nonce");
		//����ַ���
		String echostr = request.getParameter("echostr");
		
		logger.info(signature+",\n"+timestamp+",\n"+nonce+",\n"+echostr+"\n");
		
		PrintWriter out = response.getWriter();
		if(SignUtil.checkSignature(signature,timestamp,nonce)){
			out.print(echostr);
		}
		out.close();
		out = null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("I'm in post MainServlet!");
		
		// ��������Ӧ�ı��������ΪUTF-8����ֹ�������룩
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String respMsg = MainService.processRequest(request);
		
		PrintWriter pw = response.getWriter();
		pw.print(respMsg);
		pw.close();
		
		
	}
	 
}
