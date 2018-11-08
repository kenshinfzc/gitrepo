package czf.provider;

import czf.api.Provider;

/**
 * Hello world!
 *
 */
public class ProviderIml implements Provider
{
    @Override
    public String sayHello(){
    	System.out.println("Hello world!");
    	return "aaaaaaa";
    }
}
