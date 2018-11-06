package com.czf.manager;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.czf.bo.CompletionBo;
import com.czf.model.Orders;

public class MainThread extends Thread {
	private CompletionBo completionBo;
	private int cnt;
	private ArrayList<CompletionThread> completions;
	private ExecutorService es ;
	private BlockingQueue<Orders> queue;
	public MainThread(int cnt,CompletionBo completionBo) {
		// TODO Auto-generated constructor stub
		this.cnt = cnt;
		this.completionBo = completionBo;
		this.completions = new ArrayList<CompletionThread>();
		this.queue = new LinkedBlockingQueue<Orders>();
		for(int i=0;i<cnt;i++){
			completions.add(new CompletionThread(queue,completionBo));
		}
		es = Executors.newFixedThreadPool(cnt+1);
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("主线程启动；");
		//先启动数据获取线程
		DataGetterThread dgt = new DataGetterThread(queue,completionBo);
		es.execute(dgt);
		for(CompletionThread ct : completions){
			es.execute(ct);
		}
	}

}
