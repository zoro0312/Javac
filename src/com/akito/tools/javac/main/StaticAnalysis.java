package com.akito.tools.javac.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Scanner;

import javax.tools.FileObject;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;

import com.akito.tools.javac.comp.DbsIndexManager;
import com.akito.tools.javac.comp.JFileNode;
import com.akito.tools.javac.comp.JStringManager;
import com.sun.corba.se.impl.ior.ByteBuffer;
import com.sun.tools.javac.file.JavacFileManager;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.Options;
import com.sun.tools.javac.util.Position.LineMap;

/**
 * Created by Administrator on 2014/4/16.
 */
public class StaticAnalysis {
	
	private static StaticAnalysis instance = null;
	
	private StaticAnalysis(JavaFileObject fileObject, Options options) {
		fileNode = new JFileNode();
		manager = JStringManager.instance();
		this.options = options;
		this.fileObject = fileObject;
	}
	
	
	public static StaticAnalysis instance (JavaFileObject fileObject, Options options) {
		if(instance == null) {
			instance = new StaticAnalysis(fileObject, options);
		}
		return instance;
	}

	/** 创建JFileNode
	 */
	private JFileNode fileNode;
	
	private JStringManager manager;
	
	private String fileName = "F:\\Javac\\Javac1.7\\testCase\\Main.java";
	
	private String path = "F:/Javac/Javac1.7/testCase";
	
	private Options options;
	
	private JavaFileObject fileObject;
	
	private CharSequence buf;
	
	public void analysis(JCTree.JCCompilationUnit t) {
		createDirectory();
		setTotalLines(t.lineMap);
	}
	
	/**从待分析的源文件全路径名称中提取出该源文件所在的目录，
	 * 并在该目录下创建静态数据库存放目录（\dbs）和动态数据库存放目录(\ddfile)；
	 */
	public void createDirectory() {
		File dbs = new File(path + "/dbs");
		File ddfile = new File(path + "/ddfile");
		if(dbs.exists()) 
			dbs.mkdir();
		if(ddfile.exists())
			ddfile.mkdir();
		
	}
	
	/** 设置原文件名（包括路径）
	 */
	public void setName() {
		manager.add(fileName);
		fileNode.setName(fileName);
	}
	
	/** 设置数据库文件名
	 *  数据库文件名的编码规则为：pa_XX.dbs，XX从1开始顺序编号；
　　 *　数据库文件保存在\dbs目录下。
	 */
	public void setDbsName() {
		String dataFileName = path + "/dbs" + "/pa_" + DbsIndexManager.index() + ".dbs";
		manager.add(dataFileName);
		fileNode.setDbsName(dataFileName);
	}
	
	/**DD、DDH、DDC、DS等文件存放的路径这些文件保存在数据库文件保存在\ddfile目录下
	 */
	public void setDDFilePath() {
		String ddFilePath = path + "/ddFile";
		manager.add(ddFilePath);
		fileNode.setDdPath(ddFilePath);
	}
	
	/** 对于Java这类没有包含关系的语言来说，把该域清0即可
	 */
	public void setIncludingFileRefList () {
		fileNode.setIncludingFileRefList(0);
	}
	
	/** 全局变量清零
	 */
	public void setGlobalVarDefList() {
		fileNode.setGlobalVarDefList(0);
	}
	
	/** 静态变量清零
	 */
	public void setStaticVarDefList() {
		fileNode.setStaticVarDefList(0);
	}
	
	/** 获取最后修改时间
	 */
	public void setLastMTime() {
		File file = new File(fileName);
		fileNode.setLastMTime(file.lastModified());
	}
	
	/** 总行数
	 */
	public void setTotalLines(LineMap lineMap) {
		readResource();
		fileNode.setTotalLines(lineMap.getLineNumber(buf.length()-1));
	}
	
	/** Try to open input stream with given name.
     *  Report an error if this fails.
	 * @throws FileNotFoundException 
	 */
	public void readResource() {
		try {
			buf = fileObject.getCharContent(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	
