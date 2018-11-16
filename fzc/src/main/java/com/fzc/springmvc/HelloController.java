package com.fzc.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello")
	public ModelAndView hello(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView mv = new ModelAndView();
		String aa = req.getParameter("aa");
		mv.addObject("aa", aa);
		mv.addObject("bb", "bb");
		mv.setViewName("mqTest");
		return mv;
	}

}
