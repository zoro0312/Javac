package com.akito.tools.javac.comp;

import java.util.List;

public class JVarRef {
	
	private int name;
	
	/** ucUsage = 下面三个宏之一：VAR_REFER（引用变量）、VAR_MODIFY（修改变量）、
	 * VAR_USE（使用变量，这用于类的对象，表示既可能只是引用，也可能做了修改）；
	 */
	private char useage;
	
	private List<JLine> lineList;
	
	private int next;

}
