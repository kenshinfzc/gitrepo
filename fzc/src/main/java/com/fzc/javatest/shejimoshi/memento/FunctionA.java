package com.fzc.javatest.shejimoshi.memento;

import java.util.HashMap;
import java.util.Map;


public class FunctionA {
	private Map<String,String> state;
	public FunctionA() {
		// TODO Auto-generated constructor stub
		state = new HashMap<String, String>();
	}
	
	public void testState1(){
		state.put("blood", "1000");
		state.put("magic", "100");
		state.put("position", "gate1");
	}
	public void testState2(){
		state.put("blood", "11000");
		state.put("magic", "1100");
		state.put("position", "gate11");
	}
	
	public void saveState(){
		MementoCaretaker.saveMemento("functiona", new MementoA(state));
	}
	
	public void restoreMemento(MementoIf memento) {
		state = ((MementoA) memento).getState();
	}
	
	public void showState(){
		System.out.println(state.toString());
	}
	
	private class MementoA implements MementoIf{
		private Map<String,String> state ;
		private Map<String,String> state1 ;
		private MementoA(Map<String,String> state) {
			// TODO Auto-generated constructor stub
			this.state1 = state;
			this.state = new HashMap<String,String>(state);
		}
		private Map<String,String> getState() {
			return state;
		}
		private void setState(Map<String,String> state) {
			this.state = state;
		}
	} 
}
