package com.czf.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.czf.model.Orders;
import com.czf.util.SqlMapClientTemplateUtil;
import com.ibatis.sqlmap.client.SqlMapClient;

@Service
public class CompletionDao {

//	@Resource
//	private SqlMapClientTemplateUtil sqlMapClientTempalteUtil;
	@Resource
	private SqlMapClient sqlMapClient;
	@Resource
	private org.springframework.orm.ibatis.SqlMapClientTemplate sqlMapClientTempalte;

	public ArrayList<Orders> getOrders() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Orders> orders = new ArrayList<Orders>();
//		orders = (ArrayList<Orders>) sqlMapClientTempalteUtil.query("complete.getOrders", null);
//		orders = (ArrayList<Orders>) sqlMapClient.queryForList("complete.getOrders", null);
		orders = (ArrayList<Orders>) sqlMapClientTempalte.queryForList("complete.getOrders", null);
		return orders;
	}

	public void updateOrder(Map m) throws SQLException {
		// TODO Auto-generated method stub
//		sqlMapClientTempalteUtil.update("complete.updateOrder", m);
//		sqlMapClient.update("complete.updateOrder", m);
		sqlMapClientTempalte.update("complete.updateOrder", m);
	}
	
}
