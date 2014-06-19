package com.akito.test;

import java.util.Iterator;
import java.util.Map.Entry;

import org.junit.Test;

import com.akito.tools.javac.comp.JStringManager;

public class TestJStringManager {
	
	@Test
	public void test() {
		JStringManager manager= JStringManager.instance();
		System.out.println(manager.add("index"));
		System.out.println(manager.add("hello123"));
		System.out.println(manager.add("index11"));
		
		System.out.println(manager.add("nihao"));
		
		System.out.println(manager.getIndex("nihao"));
		
		Iterator<Object> e = manager.keySet();
		while(e.hasNext()) {
			System.out.println(e.next());
		}
		Iterator<Entry<Object, Integer>> k = manager.entrySet();
		while(k.hasNext()) {
			System.out.println(k.next().getKey());
			System.out.println(k.next().getValue());
		}
	}

}
