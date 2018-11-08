package czf.provider;

import czf.api.Provider;

public class ProviderIml1 implements Provider {
	@Override
	public String sayHello(){
		System.out.println("Hello");
		return "bbbbbbbb";
	}
}
