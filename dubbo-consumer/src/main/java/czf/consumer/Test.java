package czf.consumer;

import czf.api.Provider;

public class Test {
	public String aa;
	
	public String getAa() {
		return aa;
	}

	public void setAa(String aa) {
		this.aa = aa;
	}

	public String sayYes(){
		System.out.println("Test1:"+aa);
		return "sayYes";
	}
}
