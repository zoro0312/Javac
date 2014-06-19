package com.akito.util;

import java.util.ArrayList;
import java.util.List;

import javax.tools.FileObject;


/**
 * 
 * @author akito
 * Get token's info include row col
 */
public class JInfo {
	private static JInfo instance = null;
	
	private FileObject object;
	private List<JTokenInfo> info;
	
	private JInfo() {
		info = new ArrayList<JTokenInfo>();
	}
	
	public static JInfo getInstance() {
		if(instance == null) {
			instance =  new JInfo();
		}
		return instance;
	}
	
	public void add(JTokenInfo j) {
		info.add(j);
	}
	
	public void setFileObject(FileObject object) {
		this.object = object;
	}
	
	public FileObject getFileObject() {
		return object;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(object.getName() + "\n");
		for(int i = 0; i < info.size();i ++) {
			builder.append(info.get(i).toString() + "\n");
		}
		return builder.toString();
	}
}
