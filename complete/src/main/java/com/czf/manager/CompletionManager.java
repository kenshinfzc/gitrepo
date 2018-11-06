package com.czf.manager;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.czf.bo.CompletionBo;

@Service
public class CompletionManager{

	@Resource
	private CompletionBo completionBo;
	public void print(){
		System.out.println("CompletionManager");
	}
	
	public void start(int cnt){
		System.out.println(completionBo);
		MainThread mt = new MainThread(cnt,completionBo);
		mt.start();
	}
}
