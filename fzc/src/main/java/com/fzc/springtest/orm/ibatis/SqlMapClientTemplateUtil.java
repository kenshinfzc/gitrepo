package com.fzc.springtest.orm.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class SqlMapClientTemplateUtil extends SqlMapClientDaoSupport {
	
	public  void createTable() throws SQLException{
		getSqlMapClientTemplate().update("userSql.createTable",null);
	}
	
	public  void dropTable() throws SQLException{
		getSqlMapClientTemplate().update("userSql.dropTable",null);
	}
	
	public  void insertCup1() throws SQLException{
		Cup c = new Cup();
		c.setId(11);
		c.setName("cup11");
		c.setPpp("ppp");
		getSqlMapClientTemplate().insert("userSql.insertCup1", c);
	}
	
	public  void selectCup() throws SQLException{
		List<Cup> l = getSqlMapClientTemplate().queryForList("userSql.selectCup",null);
		System.out.println(l);
	}
	
	public  void updateCup() throws SQLException {
		Map m = new HashMap();
		m.put("id", "11");
		m.put("name", "cup22");
		getSqlMapClientTemplate().update("userSql.updateCup",m);
	}
	
	public  void deleteCup() throws SQLException{
		Map m = new HashMap();
		m.put("id", "11");
		getSqlMapClientTemplate().update("userSql.deleteCup",m);
	}
}
