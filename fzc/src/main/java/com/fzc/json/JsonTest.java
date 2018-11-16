package com.fzc.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;

public class JsonTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		testFastJson();
//		testGson();
//		test();
//		String s = testGetNode(getTestString(),"name2");
//		System.out.println(s);
	}
	@SuppressWarnings("resource")
	private static String getTestString() throws IOException {
		// TODO Auto-generated method stub
		File f = new File("json.json");
		StringBuffer sb = new StringBuffer();
		BufferedReader bf = null;
		bf = new BufferedReader(new FileReader(f)); 
		String s = bf.readLine();
		while(s!=null){
			sb.append(s);
			s = bf.readLine();
		}
		String a = sb.toString();
		return a;				
	}
	private static String testGetNode(String s,String n) throws Exception {
		String rs = "";
		JsonElement je = new JsonParser().parse(s);
		if(je.isJsonNull()){
			System.out.println("isJsonNull");
		}else if(je.isJsonPrimitive()){
			System.out.println("isJsonPrimitive");
		}else if(je.isJsonObject()){
			System.out.println("isJsonObject");
			JsonObject jo = je.getAsJsonObject();
//			if(jo.has(n)){
//				JsonElement je1 = jo.get(n);
//				rs = new Gson().toJson(je1);
//			}else{
				Set<Entry<String, JsonElement>> set =jo.entrySet();
				for(Entry<String,JsonElement> e :set){
					if(n.equals(e.getKey())){
						rs = new Gson().toJson(e.getValue());
					}else{
						String s1 = new Gson().toJson(e.getValue());
						String s2 = testGetNode(s1, n);
						if(!"".equals(s2)){
							rs = s2;
							break;
						};
					}
				}
//			}
		}else if(je.isJsonArray()){
			System.out.println("isJsonArray");
			JsonArray jar = je.getAsJsonArray();
			for(JsonElement e :jar){
				String s1 = new Gson().toJson(e);
				String s2 = testGetNode(s1, n);
				if(!"".equals(s2)){
					rs = s2;
					break;
				};
			}
		}
		return rs;
	}
	
	//对于复杂类型的转换,对于重复的引用在转成json串后在json串中出现引用的字符,比如 $ref":"$[0].books[1]
	public static void test(){
		Student stu = new Student();
		Set books= new HashSet();
		Book book = new Book();
		book.setName("b");
		books.add(book);
		stu.setBooks(books);
		List list = new ArrayList();
		for(int i=0;i<5;i++)
		list.add(stu);
		String json = JSON.toJSONString(list,true);
		System.out.println(json);
		Gson gson = new Gson();
		String json2 = gson.toJson(list);
		System.out.println(json2);
	}
	
	public static void testFastJson(){
		Book b = new Book();
		b.setName("老村长");
		b.setPrice(15);
		b.setTime(new Date());
		String s1 = JSON.toJSONString(b,true);
		System.out.println("对象转JSON："+s1);
		String s11 = JSON.toJSONStringWithDateFormat(b, "yyyy-MM-dd HH:mm:ss");
		System.out.println("对象转JSON(时间格式化)："+s11);
		Book b1 = JSON.parseObject(s1, Book.class);
		System.out.println("JSON转对象："+b1.toString());
		List<Book> l = new ArrayList<Book>();
		l.add(b);
		l.add(b);
		String s2 = JSON.toJSONString(l,true);
		System.out.println("List转JSON(格式化)："+s2);
		List<Book> l2 = JSON.parseObject(s2, new TypeReference<List<Book>>(){});
		System.out.println("JSON转List："+l2);
		Map<String,Book> m = new HashMap<String,Book>();
		m.put("语文", b);
		m.put("英语", b);
		String s3 = JSON.toJSONString(m,true);
		System.out.println("Map转JSON："+s3);
		Map<String,Book> m2 = JSON.parseObject(s3, new TypeReference<HashMap<String,Book>>(){});
		System.out.println("JSON转Map："+m2);
		//uid
		JSONObject obj1 = JSON.parseObject(s1);
		if(obj1.containsKey("name")){
			obj1.put("name", "老干部");
			obj1.put("price1", 25);
			obj1.remove("price");
		}
		System.out.println(obj1);
	}
	
	public static void testGson(){
		Gson gson = new Gson();
		Book b = new Book();
		b.setName("老村长");
		b.setPrice(15);
		b.setTime(new Date());
		String s1 = gson.toJson(b);
		System.out.println("对象转JSON："+s1);
		Book b1 = gson.fromJson(s1, Book.class);
		System.out.println("JSON转对象："+b1.toString());
		List<Book> l = new ArrayList<Book>();
		l.add(b);
		l.add(b);
		String s2 = gson.toJson(l);
		System.out.println("List转JSON："+s2);
		List<Book> l2 = gson.fromJson(s2, new TypeToken<List<Book>>(){}.getType());
		System.out.println("JSON转List："+l2);
		Map<String,Book> m = new HashMap<String,Book>();
		m.put("语文", b);
		m.put("英语", b);
		String s3 = gson.toJson(m);
		System.out.println("Map转JSON："+s3);
		Map<String,Book> m2 = gson.fromJson(s3, new TypeToken<HashMap<String,Book>>(){}.getType());
		System.out.println("JSON转Map："+m2);
		
		//格式化 日期格式化
		Gson gson2 = new GsonBuilder()
		//.excludeFieldsWithoutExposeAnnotation() //不导出实体中没有用@Expose注解的属性
        .enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式
        .serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss")//时间转化为特定格式  
        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)//会把字段首字母大写,注:对于实体上使用了@SerializedName注解的不会生效.
        .setPrettyPrinting() //对json结果格式化.
        .setVersion(1.0)    //有的字段不是一开始就有的,会随着版本的升级添加进来,那么在进行序列化和返序列化的时候就会根据版本号来选择是否要序列化.
        					//@Since(版本号)能完美地实现这个功能.还的字段可能,随着版本的升级而删除,那么
        					//@Until(版本号)也能实现这个功能,GsonBuilder.setVersion(double)方法需要调用.
        .create();
		String s4 = gson2.toJson(m);
		System.out.println(s4);
		
		/*Gson类：解析json的最基础的工具类
		JsonParser类：解析器来解析JSON到JsonElements的解析树
		JsonElement类：一个类代表的JSON元素
		JsonObject类：JSON对象类型
		JsonArray类：JsonObject数组
		TypeToken类：用于创建type，比如泛型List<?>*/
		
		JsonElement je = gson2.toJsonTree(m);
		JsonObject jo = je.getAsJsonObject();
		JsonElement je1 = jo.get("语文");
		String sje2 = gson2.toJson(je1);
		System.out.println(sje2);

		JsonObject jo2 = gson2.fromJson(s3, JsonObject.class);
		if(jo2.has("语文")){
			jo2.addProperty("name", "hhh");
			jo2.add("化学", jo2.get("语文"));
			jo2.remove("语文");
		}

		String sje3 = gson2.toJson(jo2);
		System.out.println(sje3);
		
		JsonElement je2 = new JsonParser().parse(s2);
		if(je.isJsonArray()){
			JsonArray arr = je2.getAsJsonArray();
			for(JsonElement e :arr){
				Book bb = gson.fromJson(e, Book.class);
				System.out.println(bb);
			}
		}
	}	

}
