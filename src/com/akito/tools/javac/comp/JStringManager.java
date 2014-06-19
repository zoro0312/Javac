package com.akito.tools.javac.comp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class JStringManager {
	
	
	private static JStringManager instance = null;
	
	private HashMap<Object, Integer> map;
	
	private int index;
	
	JStringManager() {
		map = new HashMap<>();
		index = 1;
	}
	
	public static JStringManager instance(){
		if(instance == null) {
			instance = new JStringManager();
		}
		return instance;
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}
	
	public int size() {
		return map.size();
	}
	
	public int add(String s) {
		if(map.containsKey(s)) {
			return map.get(s);
		}else {
			map.put(s, index);
		}
		index ++;
		return index - 1;
	}
	
	public int getIndex(String s) {
		return map.get(s);
	}
	
	public void clear() {
		map.clear();
	}

	public Iterator<Object> keySet() {
		return map.keySet().iterator();
	}
	
	public Iterator<Entry<Object, Integer>> entrySet() {
		return map.entrySet().iterator();
	}
	
}
