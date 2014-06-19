package com.akito.test;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.akito.tools.file.DbsDocStuct;
import com.sun.org.apache.bcel.internal.generic.DDIV;

public class TestDbsDocStruct {
	
	@Test
	public void test () {
		DbsDocStuct dds = new DbsDocStuct(new File("keep.LST"));
		dds.addNamerec("Main.java", "pa_1");
		dds.addNamerec("Test.java", "pa_2");
		try {
			dds.writeObject();
			dds = new DbsDocStuct(new File("keep.LST"));
			dds.readObject();
			System.out.println(dds.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
