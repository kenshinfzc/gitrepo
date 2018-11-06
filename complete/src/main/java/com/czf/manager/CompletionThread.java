package com.czf.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import javax.annotation.Resource;

import com.czf.bo.CompletionBo;
import com.czf.model.Orders;

public class CompletionThread extends Thread {
	private CompletionBo bo;
	private BlockingQueue<Orders> queue ;
	public CompletionThread(BlockingQueue<Orders> queue,CompletionBo bo) {
		this.queue = queue;
		this.bo = bo;
		this.setName("CompletionThread");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		for(int i=0;i<50;i++){
//			System.out.println(Thread.currentThread().getName()+"--------"+i);
//		}
		
		while(true){
			System.out.println("进入竣工处理线程；");
			if(queue.isEmpty()){
				System.out.println("取数队列为空，线程睡眠5秒");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				Orders o;
				try {
					System.out.println("当前线程："+Thread.currentThread().getName()+"获取取数队列");
					o = queue.take();
					Map m = new HashMap();
					m.put("staff", "储大胖");
					m.put("orderId", o.getOrderId());
					bo.updateOrder(m);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
