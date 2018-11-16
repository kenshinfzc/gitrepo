package com.fzc.springtest.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleResultSet;
import oracle.sql.CLOB;

public class jdbc {

	public jdbc() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Connection conn = null ;
		PreparedStatement psmt = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
//			String url = "";
//			String sql = "";
//			sql = "select * from book";
//			sql = "insert into book(book_id,book_name,book_desc) values(1,'book1','book1D')";
			/*
			Class.forName("com.mysql.jdbc.Driver");
			url = "jdbc:mysql://localhost:3306/test?user=root&password=root&useUnicode=true&characterEncoding=GBK";
			conn = DriverManager.getConnection(url);
			*/
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@134.64.110.38:1521:sidt", "crm20_ins", "crm20_ins"); 
			conn.setAutoCommit(false);
			String sql = "insert into TB_PTY_CERTIF_ID_VAR_INFO(identity,photo) values ('123123123123',EMPTY_CLOB())";  
			psmt = conn.prepareStatement(sql);
			psmt.executeUpdate();  
			sql = "select PHOTO from TB_PTY_CERTIF_ID_VAR_INFO where identity='123123123123'";  
			psmt =  conn.prepareStatement(sql); 
			rs = psmt.executeQuery();  
			if(rs.next()){  
			    CLOB c = ((OracleResultSet)rs).getCLOB("photo"); 
			    String photo = "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAB2AGADASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD3OCdZgeMMOoNQhftN0dxwIuMDvReI0YM8I+cDB+lSWe1rdXHJbqcUARyRG1kM0WdpPzIO/vS3NwPJURuFLjhuwqw5UI244XHJ6cV5L4t8Ufabh7C1kxawtgFT98+/tTSuB2V34x0TTla3R3uHxz5QGM/UkA/hmsGL4lJbSsn2HMROVJm5H6V5vJM0jZJPP6GonRmTr+dOyEesW3xB0y8n33MUsQXopOVHvkc/pW5Hr+nagElgnVZBwCW/p1/MCvEVQhR2NWIpJEA+Yj3BpWA9++1qbUSqCSeg7mi3gKkyycyt1PtXlvhDxW8GoLa6hNm3XhGY/cP+Br1iORZYw6MCpHBBzQ1YEQWoMMjwY+Vfuk96fPcFW8qMbpD29KivnMTxMoy2eFHU1NbQ+WpY8sxySev0pDJJl3QupOMqaqaWxEBj6hDgE1eIyMGs6zJhu54mOVJytAGH481k6dpH2eM4lucr9FHX884rxhg8t0c9z1rrvHOoteeIpVBJWIBApPHvisK1tJJLyMbOG9qG0kNRuVI7ZsnKn2yKbNGwUgrxn0rvbfR1MartyfUgHFF34ft0jzs+brnHWsvbI19izjYrGd0B2kL1BqU2hRctwfWu4XTE8sDaAMVmappoEWVXGBSVVtlOikjj442R3Pf2FeofD3VZLmCW1lkyYwCuTyRz/wDWrzfyiqE1teEr57HXomCqyvlSGJx+n/163Tuc7VtD1i4Yy6jCg48skn3rRrIs5vtmoO4G0IM+ufxHFa9IArPm2RalDgkGQc+9X1YMoYHINUr2MySRhSFYc5oA8s8W2WfFtyiLtJZSABwQQOlXLezEDwF1GB1NSzTjWPFk1z5YVfKBHOemAPxxV26tvOaOIPtHrWM3zOx0U1ZX6l63jwAR09RS3eFhJ25qlHZsV3JeyqOm0HAqwQZFFv5hZsZyanlS0NLt6k6phBx2qpdxB4mLdMGnykzJtDvHt4+U81Sk04u21rqViecMeP8AH9aFFMG2Y0+kb7IEDDEVV8KxD/hJrWOQAkSEEEegNdPHCwj8osWC+vWuenRdP8UWsoJUMwb5Rz1x/jWkG07MxnG6uj1PSUQwmZOr8GtGqtgFFogQcVPLII0LdT2GetaGJBbOUdoH4I+4PalmJ+1RccYNFzEeJY8B16n2psMgupBKvCrxQBwFja/ZfEN/Gx5J4GMcAn/61X5LRbuZ1ZmAH90kfyqfWrQ2msNcov31znHqef60+wdJSZlIKv0rFp3OuOqMhdJS31F3iZxlem44+oGcZq5b4N8WU5CjafrVu9Uonn4yEOTjqaq2mX3Oi8Nz06VLuxpW0I2GZpIQSGwSG9KpW+kpNfTXLM4bGwLvOB7jnircz+Vc56O/yrxWhHGYoxkfMRzTVw5buxUtIfIklUsW46k5NY1/aC91u1XtnCn8RWxdzCCQbeWk4xU2maZ9o1WFgDsi+ZvbnOPzGKpJpilZLU62x4tgMYwentSMPtNyBjMacgj1qN5vLuZEUfvHHy56Vat4RDHjueT9a1OQl6is+3UW95MRnY5yfQVYDtCWVzkAZU0QoJEZ26P29KAKeuIjabIW6qQR/L+RNcxp5MOI2wP7tdRdf6Sn2Jvvk9T3HeueuLZ7aYxPwy9D6jsaiWmp0UH0Jrpg0XlPwr8E1QgR4mZPNOF4UYHT1pZZZJCWQZ2jgN0zVG5+0484Tqrj+HGB/Pmsr3ZstXcsvAZrrEkhZY8OrccH0yK1A26NWbnI5rFtftUKkArKG5O7PH41cSV1HlHh35HpimnqK9mRXR33CydFj7etdhpMSw6bExwGcbyT7/8A1sVzlpYfbJlgXIjHLn0Hp+NdEkjXJ8hRtjThj6itYmFaWthLJTLeTXDAjPCqe1aLMFUsTgDrUEp8udCCF3feNRqWu5T1EAOMdMmqMCedA8Dg46VDZOVgWN/vDofWmzyNGixvxlsA+opt9cQ21uGdsEdAOtJtJajSbegSRGa7EyHBjGD71zXjnU5NOsbG+jRSgmMcqEckEEj+Rqlr3i+403TzLaptlmYAMQCFyCR19ga881fxBqGrlBdTs6Kc7O2cYzj1pL3h6x1O/s7pJI1lQhlkAOe2DVuRIp2WIrnIyTXnWk62bFDFLl4DyPVT7V1Om33mRkxXStu5HIOB71lKLTOiM00bpZUjY4wV7Vm3V/HaRtcO3I/QVkalrS28oLz7wOykf0rmNT1aS+OCdsQ+6opxg27ilUSO/wDBOqXepavqUoLeS0aoinoOTj8cZP4131nGLbMAyf4iT6mvBdC1y+0SdpbWZlJxuTscdOPzr1HRPFy6xbo23yrl22SHsuO/61s2kYavU6K6LXU6BeIYzl29a0UChBt6Y4qCWNIrRlUYAoQmVUUEhMcn1oEc5feIRcjyoYxgjIYnkelZ8166p5suWye/48dM45P5YqQsySPLCURkHAJCqw75Azx271RWQzyFP3e3J3oh3AY5/L/P18ytOTaTeh3wjFLawuqaUL/TXikU70HykAEsOoPbn/6+a88udFvbXfKYWeLJG9BkD6+nTvXpcwkiARmPlscqynBHfsO/61K4jjtGlgl2zDoU6k5ycgdce3pVUq7g+6ZNSCkjxs/fA7CnuxA+U816aunaZeRM93a288hGW2jY/J74AJ9OtZo8L6VKzFoLm3ByUJJIx+tdaxEWrmDoTTscLxsPNRp8x56Dp713KeFtNE4JkZ4Qf4iRnH0Hf61ffQ9OtWVbS3tpZeRl1L4/PI4qXioLQXsJHD2GlXuqXAis4S2ThnPCp9T0rvtJ0tdEsiq4lcZMsmMgf/r4GPzq88cI08JHNiNegjXYp/znp7UlkxuYwZPliyQBzz9B+Hfnmsa1XnXkbU6XKtdbmvY6s7BLe4VvK2ZY9wME857dBW5Z3ULw4WVSM8AHn8q462aW5LW9v8oH326454/H/P0tF106cwgbjtDbjnP16e49qIV3FWZFSmnL3SnmRblZIxF5cvHzrlgc/l3qw1n5Ukk7SAkEZIjAP4YxRRXO/e3Oi+iRVtrwXrXJkX5oSVz+fPv369c9qbLn+0VUcEHK49x+lFFSlqyluhHInkVI8oV53HByMdP8/nUjMJiLdSyMFOCuQOx9aKKtEy6iTXhK+Xlt27aCcccAelLA/kK4LSFh1IYcn16UUU1qncS3RHbEyyt5gBCjKgHj3/PFEjLBqPl4wncqBnkZ49OtFFQviLhsaMcJtcPbzuilRhSAR+PfP41E6z3F4HlkRt3yY2cDj3+tFFQ5OzMr6n//2Q==/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAB2AGADASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD3OCdZgeMMOoNQhftN0dxwIuMDvReI0YM8I+cDB+lSWe1rdXHJbqcUARyRG1kM0WdpPzIO/vS3NwPJURuFLjhuwqw5UI244XHJ6cV5L4t8Ufabh7C1kxawtgFT98+/tTSuB2V34x0TTla3R3uHxz5QGM/UkA/hmsGL4lJbSsn2HMROVJm5H6V5vJM0jZJPP6GonRmTr+dOyEesW3xB0y8n33MUsQXopOVHvkc/pW5Hr+nagElgnVZBwCW/p1/MCvEVQhR2NWIpJEA+Yj3BpWA9++1qbUSqCSeg7mi3gKkyycyt1PtXlvhDxW8GoLa6hNm3XhGY/cP+Br1iORZYw6MCpHBBzQ1YEQWoMMjwY+Vfuk96fPcFW8qMbpD29KivnMTxMoy2eFHU1NbQ+WpY8sxySev0pDJJl3QupOMqaqaWxEBj6hDgE1eIyMGs6zJhu54mOVJytAGH481k6dpH2eM4lucr9FHX884rxhg8t0c9z1rrvHOoteeIpVBJWIBApPHvisK1tJJLyMbOG9qG0kNRuVI7ZsnKn2yKbNGwUgrxn0rvbfR1MartyfUgHFF34ft0jzs+brnHWsvbI19izjYrGd0B2kL1BqU2hRctwfWu4XTE8sDaAMVmappoEWVXGBSVVtlOikjj442R3Pf2FeofD3VZLmCW1lkyYwCuTyRz/wDWrzfyiqE1teEr57HXomCqyvlSGJx+n/163Tuc7VtD1i4Yy6jCg48skn3rRrIs5vtmoO4G0IM+ufxHFa9IArPm2RalDgkGQc+9X1YMoYHINUr2MySRhSFYc5oA8s8W2WfFtyiLtJZSABwQQOlXLezEDwF1GB1NSzTjWPFk1z5YVfKBHOemAPxxV26tvOaOIPtHrWM3zOx0U1ZX6l63jwAR09RS3eFhJ25qlHZsV3JeyqOm0HAqwQZFFv5hZsZyanlS0NLt6k6phBx2qpdxB4mLdMGnykzJtDvHt4+U81Sk04u21rqViecMeP8AH9aFFMG2Y0+kb7IEDDEVV8KxD/hJrWOQAkSEEEegNdPHCwj8osWC+vWuenRdP8UWsoJUMwb5Rz1x/jWkG07MxnG6uj1PSUQwmZOr8GtGqtgFFogQcVPLII0LdT2GetaGJBbOUdoH4I+4PalmJ+1RccYNFzEeJY8B16n2psMgupBKvCrxQBwFja/ZfEN/Gx5J4GMcAn/61X5LRbuZ1ZmAH90kfyqfWrQ2msNcov31znHqef60+wdJSZlIKv0rFp3OuOqMhdJS31F3iZxlem44+oGcZq5b4N8WU5CjafrVu9Uonn4yEOTjqaq2mX3Oi8Nz06VLuxpW0I2GZpIQSGwSG9KpW+kpNfTXLM4bGwLvOB7jnircz+Vc56O/yrxWhHGYoxkfMRzTVw5buxUtIfIklUsW46k5NY1/aC91u1XtnCn8RWxdzCCQbeWk4xU2maZ9o1WFgDsi+ZvbnOPzGKpJpilZLU62x4tgMYwentSMPtNyBjMacgj1qN5vLuZEUfvHHy56Vat4RDHjueT9a1OQl6is+3UW95MRnY5yfQVYDtCWVzkAZU0QoJEZ26P29KAKeuIjabIW6qQR/L+RNcxp5MOI2wP7tdRdf6Sn2Jvvk9T3HeueuLZ7aYxPwy9D6jsaiWmp0UH0Jrpg0XlPwr8E1QgR4mZPNOF4UYHT1pZZZJCWQZ2jgN0zVG5+0484Tqrj+HGB/Pmsr3ZstXcsvAZrrEkhZY8OrccH0yK1A26NWbnI5rFtftUKkArKG5O7PH41cSV1HlHh35HpimnqK9mRXR33CydFj7etdhpMSw6bExwGcbyT7/8A1sVzlpYfbJlgXIjHLn0Hp+NdEkjXJ8hRtjThj6itYmFaWthLJTLeTXDAjPCqe1aLMFUsTgDrUEp8udCCF3feNRqWu5T1EAOMdMmqMCedA8Dg46VDZOVgWN/vDofWmzyNGixvxlsA+opt9cQ21uGdsEdAOtJtJajSbegSRGa7EyHBjGD71zXjnU5NOsbG+jRSgmMcqEckEEj+Rqlr3i+403TzLaptlmYAMQCFyCR19ga881fxBqGrlBdTs6Kc7O2cYzj1pL3h6x1O/s7pJI1lQhlkAOe2DVuRIp2WIrnIyTXnWk62bFDFLl4DyPVT7V1Om33mRkxXStu5HIOB71lKLTOiM00bpZUjY4wV7Vm3V/HaRtcO3I/QVkalrS28oLz7wOykf0rmNT1aS+OCdsQ+6opxg27ilUSO/wDBOqXepavqUoLeS0aoinoOTj8cZP4131nGLbMAyf4iT6mvBdC1y+0SdpbWZlJxuTscdOPzr1HRPFy6xbo23yrl22SHsuO/61s2kYavU6K6LXU6BeIYzl29a0UChBt6Y4qCWNIrRlUYAoQmVUUEhMcn1oEc5feIRcjyoYxgjIYnkelZ8166p5suWye/48dM45P5YqQsySPLCURkHAJCqw75Azx271RWQzyFP3e3J3oh3AY5/L/P18ytOTaTeh3wjFLawuqaUL/TXikU70HykAEsOoPbn/6+a88udFvbXfKYWeLJG9BkD6+nTvXpcwkiARmPlscqynBHfsO/61K4jjtGlgl2zDoU6k5ycgdce3pVUq7g+6ZNSCkjxs/fA7CnuxA+U816aunaZeRM93a288hGW2jY/J74AJ9OtZo8L6VKzFoLm3ByUJJIx+tdaxEWrmDoTTscLxsPNRp8x56Dp713KeFtNE4JkZ4Qf4iRnH0Hf61ffQ9OtWVbS3tpZeRl1L4/PI4qXioLQXsJHD2GlXuqXAis4S2ThnPCp9T0rvtJ0tdEsiq4lcZMsmMgf/r4GPzq88cI08JHNiNegjXYp/znp7UlkxuYwZPliyQBzz9B+Hfnmsa1XnXkbU6XKtdbmvY6s7BLe4VvK2ZY9wME857dBW5Z3ULw4WVSM8AHn8q462aW5LW9v8oH326454/H/P0tF106cwgbjtDbjnP16e49qIV3FWZFSmnL3SnmRblZIxF5cvHzrlgc/l3qw1n5Ukk7SAkEZIjAP4YxRRXO/e3Oi+iRVtrwXrXJkX5oSVz+fPv369c9qbLn+0VUcEHK49x+lFFSlqyluhHInkVI8oV53HByMdP8/nUjMJiLdSyMFOCuQOx9aKKtEy6iTXhK+Xlt27aCcccAelLA/kK4LSFh1IYcn16UUU1qncS3RHbEyyt5gBCjKgHj3/PFEjLBqPl4wncqBnkZ49OtFFQviLhsaMcJtcPbzuilRhSAR+PfP41E6z3F4HlkRt3yY2cDj3+tFFQ5OzMr6n//2Q==";
			    c.putString(1, photo);  
			    sql = "update TB_PTY_CERTIF_ID_VAR_INFO set photo=? where identity='123123123123'";  
			    psmt = conn.prepareStatement(sql);  
			    psmt.setClob(1, c);  
			    psmt.executeUpdate();  
			}  
			conn.commit(); 
			
			/*psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1)+"--"+rs.getString(2)+"--"+rs.getString(3));
				System.out.println(rs.getString("book_id")+"--"+rs.getString("book_desc")+"--"+rs.getString("book_name"));
			}*/
			
			//�洢���� ������
			/*cs = conn.prepareCall("{call testfzc(?,?)}");
			cs.setString(1, "2");
			cs.registerOutParameter(2, java.sql.Types.VARCHAR);
			cs.executeQuery();
			System.out.println(cs.getString(2));*/
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e1) {
			
		} finally {
			try {
				rs.close();
				psmt.close();
//				cs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
