package com.fzc.javatest.shejimoshi.memento;

import java.util.HashMap;
import java.util.Map;

public class FunctionB {
	private Map<String,String> state = new HashMap<String, String>();
	
	public void saveState(){
		state.put("blood", "2000");
		state.put("magic", "200");
		state.put("position", "gate2");
		MementoCaretaker.saveMemento("functionb", new MementoB(state));
	}
	
	public void queryState(String name){
		MementoB memento = (MementoB) MementoCaretaker.queryMemento(name);
		System.out.println(memento.getState().toString());
	}
	
	public class MementoB implements MementoIf{
		private Map<String,String> state ;
		public MementoB(Map<String,String> state) {
			// TODO Auto-generated constructor stub
			this.setState(state);
		}
		public Map<String,String> getState() {
			return state;
		}
		public void setState(Map<String,String> state) {
			this.state = state;
		}
	} 
}
