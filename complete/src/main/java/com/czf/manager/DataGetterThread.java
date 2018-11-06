package com.czf.manager;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czf.bo.CompletionBo;
import com.czf.model.Orders;

public class DataGetterThread extends Thread {
	private CompletionBo bo ;
	private BlockingQueue<Orders> queue;
	public DataGetterThread(BlockingQueue<Orders> queue,CompletionBo bo) {
		// TODO Auto-generated constructor stub
		this.queue = queue;
		this.bo = bo;
		this.setName("DataGetterThread");
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		/*for(int i=0;i<50;i++){
			System.out.println(Thread.currentThread().getName()+i);
		}*/
		while(true){
			System.out.println("取数线程开始启动：");
			ArrayList<Orders> orders = new ArrayList<Orders>();
			orders = bo.getOrders();
			if(!orders.isEmpty()){
				for(Orders o :orders){
					queue.add(o);
				}
			}
			System.out.println("取数完成，队列数据条数："+queue.size());
			try {
				System.out.println("取数线程休眠5秒");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
