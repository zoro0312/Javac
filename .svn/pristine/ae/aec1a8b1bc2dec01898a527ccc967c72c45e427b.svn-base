package com.akito.tools.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @author THINK
 *将源文件全路径名及静态文件名写入DBS目录里的ISA_KEEP.LST文件
 *ISA_KEEP.LST文件用来保存各个被分析的源文件名及其对用的数据库文件的名字
 *文档结构是：头部一个int型，指出有多少个struct eg_dbs_namerec结构。后面按顺序列出多个
 *eg_dbs_namerec结构体
 */
public class DbsDocStuct implements Serializable{

	private static final long serialVersionUID = 4132297205355811148L;

	/** 头部
	 */
	private int dbsNum;
	
	private File file;
	private List<Namerec> namerecList;
	
	
	public DbsDocStuct(File file) {
		this.file = file;
		namerecList = new ArrayList<>();
	}

	public void addNamerec(String srcName, String tmpName) {
		namerecList.add(new Namerec(srcName, tmpName));
	}

	protected class Namerec implements Serializable{
		
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 5711309846117741640L;

		/**原文件名（带全路径）
		 */
		private String srcName;
		
		/**数据库文件名
		 */
		private String tmpName;

		public Namerec(String srcName, String tmpName) {
			this.srcName = srcName;
			this.tmpName = tmpName;
		}
		
		@Override
		public String toString() {
			return srcName + " " + tmpName	;
		}
		
	}
	
	/** 写入文件
	 * @throws IOException 
	 */
	public void writeObject() throws IOException {
		dbsNum = namerecList.size();
		ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
		oout.writeInt(dbsNum);
		oout.writeObject(namerecList);
		oout.close();
	}
	
	@SuppressWarnings("unchecked")
	public void readObject() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
		dbsNum  = oin.readInt();
		namerecList = (List<Namerec>) oin.readObject();
		oin.close();
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(dbsNum + " ");
		for (Namerec n : namerecList) {
			result.append(n.toString());
		}
		return result.toString();
	}
	
}
