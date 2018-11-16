package com.fzc.springtest.springContextUtil;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Test1 {
	public String aa;
	
	public String getAa() {
		return aa;
	}
	@Value("aaaa")
	public void setAa(String aa) {
		this.aa = aa;
	}

	public String sayYes(){
		System.out.println("Test1:"+aa);
		return "sayYes";
	}
}
