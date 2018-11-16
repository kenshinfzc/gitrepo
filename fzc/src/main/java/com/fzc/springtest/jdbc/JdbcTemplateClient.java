package com.fzc.springtest.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

@SuppressWarnings("deprecation")
public class JdbcTemplateClient extends JdbcDaoSupport {
	public JdbcTemplate jdbcTemplate;
	
	/*private String url = "jdbc:mysql://localhost:3306/test?user=root&password=root&useUnicode=true&characterEncoding=GBK";
	private String username = "root";
	private String password = "root";
	private String classname = "com.mysql.jdbc.Driver";
	private String url;
	private String username;
	private String password;
	private String classname;
	public JdbcTemplateClient() {
		url = "jdbc:oracle:thin:@134.64.110.38:1521:sidt";
		username = "crm20_ins";
		password = "crm20_ins";
		classname = "oracle.jdbc.driver.OracleDriver";
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
		dataSource.setDriverClassName(classname);
		jdbcTemplate = new JdbcTemplate(dataSource);
	}*/
	
	public void execute(String sql){
		jdbcTemplate = getJdbcTemplate();
		jdbcTemplate.execute(sql);
	}
	
	public void queryForList(String sql){
		jdbcTemplate = getJdbcTemplate();
		List l = jdbcTemplate.queryForList(sql);
		System.out.println("queryForList"+l);
	}
	
	public void update(String sql){
		jdbcTemplate = getJdbcTemplate();
		int i = jdbcTemplate.update(sql);
		System.out.println("update:"+i);
	}
	
	public void batchUpdate(String[] sql){
		jdbcTemplate = getJdbcTemplate();
		int[] i = jdbcTemplate.batchUpdate(sql);
		System.out.println("batchUpdate"+i);
	}

	private String rtn = "";
	public void preparedStatementCreator(){
		jdbcTemplate = getJdbcTemplate();
		jdbcTemplate.execute(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement psmt = con.prepareStatement("select * from book");
				return psmt;
			}
		}, new PreparedStatementCallback() {

			public Integer doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				ResultSet rs = ps.executeQuery();
				int i = 0;
				while(rs.next()){
					String temp =  rs.getString(1)+rs.getString(2)+rs.getString(3);
					rtn +=temp+"--";
				}
				rs.close();
				ps.close();
				return null;
			}
		});
		System.out.println(rtn);
	}
	
	public void preparedStatementSetter(){
		jdbcTemplate = getJdbcTemplate();
		jdbcTemplate.update("update book set book_name = ? where book_id = 2", new PreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setObject(1, "book22");
			}
		});
		jdbcTemplate.update("update book set book_desc = ? where book_id = 2", new Object[]{"book22d"});
	}
	
	public void rowMapper(){
		jdbcTemplate = getJdbcTemplate();
		List l = jdbcTemplate.query("select * from book", new RowMapper() {

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map m = new HashMap();
				m.put(rs.getObject(1), rs.getObject(2));
				List l = new ArrayList();
				l.add(rs.getString(1)+rs.getString(2)+rs.getString(3));
				return m;
			}
		});
		System.out.println("rowMapper"+l);
	}
	
	public void rowCallBackHandler(){
		jdbcTemplate = getJdbcTemplate();
		final List l = new ArrayList();
		final Map m = new HashMap();
		jdbcTemplate.query("select * from book", new RowCallbackHandler() {
			
			public void processRow(ResultSet rs) throws SQLException {
				l.add(rs.getString(1)+rs.getString(2)+rs.getString(3));
				m.put(rs.getObject(1), rs.getObject(2));
			}
		});
		System.out.println("rowCallBackHandler"+l);
		System.out.println("rowCallBackHandler"+m);
	}
	
	public void resultSetExtractor(){
		jdbcTemplate = getJdbcTemplate();
		List l = (List)jdbcTemplate.query("select * from book", new ResultSetExtractor() {

			public List extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				List l = new ArrayList();
				while(rs.next()){
					l.add(rs.getString(1)+rs.getString(2)+rs.getString(3));
				}
				return l;
			}
		});
		System.out.println("resultSetExtractor"+l);
	}
	
	@SuppressWarnings("deprecation")
	public void test(){
		jdbcTemplate = getJdbcTemplate();
		int i = jdbcTemplate.queryForInt("select book_id from book where book_name = ?",new Object[]{"book1"});
		System.out.println(i);
		List l = jdbcTemplate.queryForList("select book_name from book where book_id > ?",new Object[]{1}, String.class);
		System.out.println(l);
		l = jdbcTemplate.queryForList("select * from book");
		System.out.println(l);
		l = jdbcTemplate.queryForList("select * from book where book_id >?", new Object[]{1});
		System.out.println(l);
		Map m = jdbcTemplate.queryForMap("select * from book where book_id = ?", new Object[]{1});
		System.out.println(m);
		SqlRowSet rs = jdbcTemplate.queryForRowSet("select * from book where book_id >?", new Object[]{1});
		
	}
	
	public void insertKey(){
		jdbcTemplate = getJdbcTemplate();
		KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {

				return con.prepareStatement("insert into book (book_name,book_desc) values('book6','book6d')", new String[]{"BOOK_ID"});
			}
		}, generatedKeyHolder);
	}
	
	/*public void call(){
		List param = new ArrayList();
		param.add(new SqlParameter(Types.VARCHAR));
		param.add(new SqlReturnResultSet("result", new ResultSetExtractor<List>() {

			public List extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				List l = new ArrayList();
				while(rs.next()){
					l.add(rs.getString(1)+rs.getString(2)+rs.getString(3));
				}
				return l;
			}
		}));
		
		Map m = jdbcTemplate.call(new CallableStatementCreator() {
			
			public CallableStatement createCallableStatement(Connection con)
					throws SQLException {
				CallableStatement cs = con.prepareCall("{call czf.czf3(?,?)}");
				cs.setString(1, "2");
//				cs.registerOutParameter(2, OracleTypes.CURSOR);
				cs.registerOutParameter(2, OracleTypes.VARCHAR);
				return cs;
			}
		}, param);
		System.out.println(m.get("result"));
	}*/

}
