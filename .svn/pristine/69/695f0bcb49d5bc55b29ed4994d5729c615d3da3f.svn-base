package com.akito.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Test;

import com.akito.tools.javac.comp.JFileNode;


public class TestFileNode {
	
	@Test
	public void testConmmentLines() {
		File file = new java.io.File("testCase\\Main.java");
		try {
			FileReader fr = new FileReader(file);
			char buf[] = new char[500];
			fr.read(buf);
			JFileNode node = new JFileNode();
			node.setCommentLines(buf, buf.length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
