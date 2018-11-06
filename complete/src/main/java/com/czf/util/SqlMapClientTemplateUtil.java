package com.czf.util;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class SqlMapClientTemplateUtil extends SqlMapClientDaoSupport{
	public List query(String sql,Map m){
		return getSqlMapClientTemplate().queryForList(sql, m);
	}
	
	public void update(String sql, Map m){
		getSqlMapClientTemplate().update(sql, m);
	}
	
}
