package com.akito.tools.javac.comp;

import java.util.List;

public class JFuncDef {
	
	
	/** used for writing to database
	 */
	private int id;
	
	/**ucType = 函数的类型。函数类型是以下八类或相互组合：宏函数、非类成员函数、类成员函数、虚函数、内联(inline)函数、
	 * 重载(overloading)函数、静态(static)函数和纯虚函数等。有八个宏对应与这八种类型，
	 * ucType的可取值就是这八个宏之一或它们的“或”组合，这八个宏是：
	 * MACRO_FUNCTION、NON_MEMBER_FUNCTION、MEMBER_FUNCTION、VIRTUAL_FUNCTION、
	 * INLINE_FUNCTION、OVERLOADING_FUNCTION、STATIC_FUNCTION、PURE_VIRTUAL_FUNCTIOIN。
	 */
	private char type;
	
	
	/** 函数名称的索引
	 */
	private int name;
	
	/** 函数返回类型的名称索引
	 */
	private int returnName;
	
	/** 函数定义所在文件名称的索引
	 */
	private int hostFile;
	
	/** 头文件  置为0
	 */
	private int includedFile = 0;
	
	/** 函数的第一个程序块对应的记录点(Record Point）在DD文件里保存的所有记录点中的序号。
	 *  若函数没有在DD文件中对应的记录，
	 *  则把该域置为-1，可用宏NO_DDREC代替-1。有关Block与Record Point的概念另行描述。
	 */
	private long baseDDIndex;
	
	/** 函数定义的起始行号
	 */
	private long firstLineNo; 
	
	/** 函数定义的结束行号
	 */
	private long lastLineNo;
	
	/** 注释行号（包括半注释行号）
	 */
	private short commentLines;
	
	/** 半注释行号
	 */
	private short partialLines;
	
	/** 空行数
	 */
	private short blankLines;
	
	/** Cyclomatic complexity(with case)(参见Panorama user’s manual第S-13页)。
	 * 计算方法是：每一个函数的基本复杂度为1。函数中的每个判断或循环语句（比如if, for, while语句）都使复杂度加1
	 * 。每个N个分支的分支语句(比如switch语句)对复杂度加N-1。
	 */
	private short wComplexity = 1;
	
	/**Cyclomatic complexity(without case)(参见Panorama user’s manual第S-13页)。
	 * 计算方法是：每一个函数的基本复杂度为1。函数中的每个判断或循环语句（比如if, for, while语句）都使复杂度加1。
	 * 每个N个分支的分支语句(比如switch语句)对复杂度加2。
	 */
	private short oComplexity = 1;
	
	/** 函数里可见程序段的数目。可见程序段的意思另行描述。
	 */
	private short visibleSegmentsNumber;  
	
	/** 函数里0号不可见程序段的数目。0号不可见程序段的意思另行描述。
	 */
	private short invisibleSegments0Number;
	
	/** 函数里1号不可见程序段的数目。1号不可见程序段的意思另行描述
	 */
	private short invisibleSegments1Number;
	
	/** 函数里2号不可见程序段的数目。2号不可见程序段的意思另行描述
	 */
	private short invisibleSegments2Number;
	
	/** 函数里的条件表达式数目。对于if (a && (b || c)){…}; 这样一个语句，
	 * Panorama把圆括号里的整个表达式a && (b || c)叫做一个判断(Decision)，
	 * 其中的每一个子表达式叫做一个条件(Condition)，在这个例子中，条件有5个，分别是：a、b、c、b||c、a&&(b||c)。
	 * 条件表达式数目的计算可参见eg-cond.c文件第130行compute_cond_num函数。
	 */
	private short conditionNumber;
	
	/** 函数分支数
	 */
	private short branchNumber; 
	
	/**  如果定义的函数是模板函数，则把该域置1；否则，置0
	 */
	private int isTemplate;
	
	/**创建一个JCalleeList对象，把其地址赋给该域。这个CCalleeList链表对象（由pCalleeList所指向）
	 * 记录了函数对其它函数的调用信息。每一个CCallee节点记录一个其它函数的调用信息，也就是说，
	 * 如果对同一个其它函数调用了多次，
	 * 在这个链里仍旧只有一个JCallee节点，多次调用的信息由CCallee::pLineList域来给出。
	 */
	private List<JCallee> calleeList;
	
	/**这个carRefList链表对象（由carRefList所指向）记录了函数对全局变量的调用信息。
	 * 每一个JVarRef节点记录对一个全局变量的一种调用形式（对全局变量的调用形式有三种：引用、修改、使用）的信息。
	 * 也就是说，如果对同一个全局变量以一种调用形式调用了多次，在这个链里仍旧只有一个JVarRef节点，
	 * 多次调用的信息由CVarRef::pLineList域来给出；如果对同一个全局变量以引用形式调用了一次，以修改形式也调用了一次，
	 * 就需要生成两个JVarRef节点，一个记录引用形式的调用，另一个记录修改形式的调用。
	 */
	private List<JVarRef> carRefList;
	
	/** 创建一个CLabelList对象，把其地址赋给该域。这个CLabelList链表对象（由pLabelList所指向）
	 * 记录了函数里定义的标号以及对该标号的调用信息，
	 * 每一个CLabel节点记录一个标号的定义以及调用信息。
	 */
	private List<JLabel> labelList;
	
	/** Used in DBS file to record 
	 *	the ID of next CFuncDef.
	 */
	private int next;
	
	/** firstBlock
	 */
	
	/** lastBlock
	 */
}
