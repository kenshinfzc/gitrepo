package com.fzc.activemq.springActivemq.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fzc.activemq.springActivemq.producer.queue.QueueSender;
import com.fzc.activemq.springActivemq.producer.topic.TopicSender;

@Controller
@RequestMapping("/activemq")
public class ActivemqController {
	@Resource(name="queueSender1")
	private QueueSender qs;
	@Resource(name="topicSender1")
	private TopicSender ts;
	
	@RequestMapping("queueSend")
	public String queueSend(@RequestParam(value="desti")String destination,@RequestParam(value="msg")String msg){
		String state = "";
		try {
			qs.queueSend(destination, msg);
			state = "suc";
		} catch (Exception e) {
			state = e.getCause().toString();
		}
		
		return state;
	}
	@ResponseBody
	@RequestMapping("topicSend")
	public String topicSend(@RequestParam(value="desti")String destination,@RequestParam(value="msg")String msg){
		String state = "";
		try {
			ts.topicSend(destination, msg);
			state = "suc";
		} catch (Exception e) {
			state = e.getCause().toString();
		}
		
		return state;
	}
}
