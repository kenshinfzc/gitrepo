package com.fzc.javatest.shejimoshi.mediator;

import java.util.HashMap;
import java.util.Map;

public class ConcreteMediator implements Mediator {
	Map<String,Colleague> colleagueMap = new HashMap<String, Colleague>();
	Map<String,String> interMap = new HashMap<String, String>();
	@Override
	public void register(String name, Colleague colleague) {
		// TODO Auto-generated method stub
		colleagueMap.put(name, colleague);
		if(colleague instanceof Alarm){
			interMap.put("Alarm", name);
		}else if(colleague instanceof Coffee){
			interMap.put("Coffee", name);
		}else if(colleague instanceof TV){
			interMap.put("TV", name);
		}
	}

	@Override
	public void getMessage(int state, Colleague colleague) {
		// TODO Auto-generated method stub
		if(colleague instanceof Alarm){
			if(state==1){
				((Coffee) colleagueMap.get(interMap.get("Coffee"))).startCoffee();
			}else{
				((Coffee) colleagueMap.get(interMap.get("Coffee"))).stopCoffee();
			}
		}else if(colleague instanceof Coffee){
			((TV)colleagueMap.get(interMap.get("TV"))).tvOn();
		}
	}

	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub

	}

}
