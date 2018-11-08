package czf.consumer;

import czf.api.Provider;

public class Test1 {
	public Provider p;
	public String aa;
	
	public String getAa() {
		return aa;
	}

	public void setAa(String aa) {
		this.aa = aa;
	}

	public Provider getP() {
		return p;
	}

	public void setP(Provider p) {
		this.p = p;
	}

	public String sayYes(){
		System.out.println("Test1:"+aa);
		return "sayYes";
	}
}
