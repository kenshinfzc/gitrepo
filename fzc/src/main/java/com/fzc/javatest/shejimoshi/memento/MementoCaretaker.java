package com.fzc.javatest.shejimoshi.memento;

import java.util.HashMap;
import java.util.Map;

public class MementoCaretaker {
	private static Map<String,MementoIf> mementoMap = new HashMap<String, MementoIf>();
	public static void saveMemento(String name,MementoIf memento){
		mementoMap.put(name, memento);
	}

	public static MementoIf queryMemento(String name){
		return mementoMap.containsKey(name)?mementoMap.get(name):null;
	}
}
