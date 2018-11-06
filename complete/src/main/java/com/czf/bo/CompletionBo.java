package com.czf.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.czf.dao.CompletionDao;
import com.czf.model.Orders;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.sun.tools.javac.util.List;
@Service("completionBo")
public class CompletionBo {
	@Resource
	private CompletionDao completionDao;
	
	public ArrayList<Orders> getOrders() {
		ArrayList<Orders> orders = new ArrayList<Orders>();
		try {
			orders = completionDao.getOrders();
//			orders = (ArrayList<Orders>) sqlMapClient.queryForList("complete.getOrders", null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}
	
	public void updateOrder(Map m){
		try {
			completionDao.updateOrder(m);
//			sqlMapClient.update("complete.updateOprder", m);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
