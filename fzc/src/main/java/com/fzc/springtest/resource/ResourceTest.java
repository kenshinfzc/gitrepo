package com.fzc.springtest.resource;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

public class ResourceTest {

	public static void main(String[] args) throws IOException {
		ResourceTest rt = new ResourceTest();
		rt.byteArrayResourceTest();
	}
	
	public void byteArrayResourceTest() throws IOException{
		Resource r = new ByteArrayResource("SB".getBytes());
		System.out.println(r.exists());
		System.out.println(r.isOpen());
		System.out.println(r.isReadable());
		if(r.exists()){
			
		}
	}
	
	public void handleResource(Resource r){
		InputStream is = null;
		try {
			is = r.getInputStream();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}
