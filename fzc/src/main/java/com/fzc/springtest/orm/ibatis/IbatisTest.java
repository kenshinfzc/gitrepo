package com.fzc.springtest.orm.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ibatis.sqlmap.client.SqlMapSession;
/**
 * 1、sqlMapClient  事务
 * 2、SqlMapClientTemplate
 * 3、spring集成      SqlMapClientDaoSupport
 * 4、ibatis标签
 * 5、批量插入、删除、更新
 * 
 * @author FENGZHI
 * @date 2018年9月11日
 */
public class IbatisTest {
	private static SqlMapClient sqlMapClient;

	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:beans.xml");
		sqlMapClient = ctx.getBean(SqlMapClient.class);
//		deleteCupAll();
		
//		createTable();
//		insertCup();
//		updateCup();
//		deleteCup();
//		selectCup();
		
//		insertCupTransaction();
//		sqlMapClientTemplate();
		
//		SqlMapClientTemplateUtil smct = ctx.getBean(SqlMapClientTemplateUtil.class);
//		smct.insertCup();
//		smct.selectCup();
//		smct.updateCup();
//		smct.selectCup();
//		smct.deleteCup();
//		smct.selectCup();
//		批量
//		insertCupBatch();
		updateCupBatch();
		selectCup();
	}
	
	public static void insertCupBatch() throws SQLException{
		List<Map> l = new ArrayList<Map>();
		Map m = new HashMap();
		m.put("id", "1");
		m.put("name", "cup1");
		l.add(m);
		Map m1 = new HashMap();
		m1.put("id", "11");
		m1.put("name", "cup11");
		l.add(m1);
		
		/*List<Cup> l = new ArrayList<Cup>();
		Cup c = new Cup();
		c.setId("1");
		c.setName("cup1");
		l.add(c);
		Cup c1 = new Cup();
		c1.setId("11");
		c1.setName("cup11");
		l.add(c1);*/
		System.out.println("l:"+l);
		sqlMapClient.insert("userSql.insertCupBatch", l);
	}
	
	public static void updateCupBatch() throws SQLException{
		List<Map> l = new ArrayList<Map>();
		Map m = new HashMap();
		m.put("id", "1");
		m.put("name", "cup2");
		l.add(m);
		Map m1 = new HashMap();
		m1.put("id", "11");
		m1.put("name", "cup22");
		l.add(m1);
		
		/*List<Cup> l = new ArrayList<Cup>();
		Cup c = new Cup();
		c.setId("1");
		c.setName("cup1");
		l.add(c);
		Cup c1 = new Cup();
		c1.setId("11");
		c1.setName("cup11");
		l.add(c1);*/

		System.out.println("l:"+l);
		sqlMapClient.update("userSql.updateCupBatch", l);
	}
	
	public static void insertCupTransaction() throws SQLException{
		Cup c = new Cup();
		c.setId(5);
		c.setName("cup5");
		SqlMapSession session = null;
		try {
			session = sqlMapClient.openSession();
			session.startTransaction();
			session.insert("userSql.insertCup",c);
			session.commitTransaction();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if(session!=null){
				session.endTransaction();
			}
			e.printStackTrace();
		} finally{
			session.close();
		}
		
		
	}
	
	public static void sqlMapClientTemplate(){
		SqlMapClientTemplate smct = new SqlMapClientTemplate(sqlMapClient);
		smct.execute(new SqlMapClientCallback() {
			
			@Override
			public Object doInSqlMapClient(SqlMapExecutor session) throws SQLException {
				// TODO Auto-generated method stub
				List<Cup> l = session.queryForList("userSql.selectCup");
				System.out.println(l);
				return null;
			}
		});
	}

	public static void createTable() throws SQLException{
		sqlMapClient.update("userSql.createTable");
	}
	
	public static void dropTable() throws SQLException{
		sqlMapClient.update("userSql.dropTable");
	}
	
	public static void insertCup() throws SQLException{
		Cup c = new Cup();
		c.setId(1);
		c.setName("cup1");
		sqlMapClient.insert("userSql.insertCup", c);
	}
	
	public static void selectCup() throws SQLException{
		List<Cup> l = sqlMapClient.queryForList("userSql.selectCup");
		System.out.println(l);
	}
	
	public static void updateCup() throws SQLException {
		Map m = new HashMap();
		m.put("id", "1");
		m.put("name", "cup2");
		sqlMapClient.update("userSql.updateCup",m);
	}

	public static void deleteCup() throws SQLException{
		Map m = new HashMap();
		m.put("id", "2");
		sqlMapClient.update("userSql.deleteCup",m);
	}

	public static void deleteCupAll() throws SQLException{
		sqlMapClient.update("userSql.deleteCupAll");
	}

}
