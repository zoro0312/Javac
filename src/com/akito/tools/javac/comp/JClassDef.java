package com.akito.tools.javac.comp;

import java.util.List;

/**
 * @author THINK
 *
 */
public class JClassDef {
	
	/** 写入数据库
	 */
	private int id;
	
	/** 类名索引号
	 */
	private int name;
	
	/** 类定义起始行号
	 */
	private long firstLineNo;
	
	/** 类定义结束行号
	 */
	private long lastLineNo;
	
	/** 类定义所在文件的索引号
	 */
	private int hostFile;
	
	/** 类定义
	 */
	private int includeFile = 0;
	
	/**
	 * 如果类是定义在一个函数体内，该域的值为该函数的CFuncDef对象的地址，
	 * 实际上就是m_FileNode.pFuncDefList链的链头节点的地址。
	 * 相反，如果类不定义在函数体内，该域值为0。
	 */
	private JFuncDef hostFuncDef;
	
	/** 如果类是定义在另一个类内，该域的值为另一个类的CClassDef对象的地址，
	 * 实际上就是m_FileNode.pClassDefList链的链头节点的地址。
	 * 相反，如果类不定义在其它类内，该域值为0。
	 */
	private JClassDef hostClassDef;
	
	/** 创建一个CBaseClassList对象，把其地址赋给该域。这个CBaseClassList链表对象（由pBaseClassList所指向）
	 * 用来记录类的基类信息，每一个CBaseClass节点记录一个基类的信息。
	 */
	private List<JBaseClass> baseClassList;
	
	/** 有元类，不考虑
	 */
	private int friendClassList = 0;
	
	/** 创建一个JMemberData对象，把其地址赋给该域。
	 * 这个JMemberData链表对象（由pPrivateMemberDataList所指向）用来记录类的私有成员变量的信息，
	 * 每一个JMemberData节点记录一个私有成员变量的信息。
	 */
	private List<JMemberData> privateMemberDataList;
	
	
	private List<JMemberData> publicMemberDataList;
	
	private List<JMemberData> protectedMemberDataList; 
	
	/** 创建一个CMemberFuncList对象，把其地址赋给该域。
	 * 这个CMemberFuncList链表对象（由pPrivateMemberFuncList所指向）用来记录类的私有成员函数的信息，
	 * 每一个CMemberFunc节点记录一个私有成员函数的信息。
	 */ 
	private List<JMemberFunc> privateMemberFuncList;
	
	private List<JMemberFunc> publicMemberFuncList;
	
	private List<JMemberFunc> protectedMemberFuncList;
	
	/** 构造函数
	 */
	private List<JMemberFunc> constructorMemberFuncList;
	
	/** 析构函数
	 */
	private List<JMemberFunc> destructorMemberFuncList; 
	
	/** 友元函数 不考虑
	 */
	private List<JMemberFunc> friendFuncRefList; 
	
	/** 不考虑
	 */
	private int friendMemberFuncRefList = 0;
	
	/** 类定义体的第一个程序块的CBlock对象的地址
	 */
	private int firstBlock; 
	
	/** 如果类是模板，则该域置1；反之，置0。
	 */
	private int isTemplate;
	
	/** 类定义体的最后一个程序块的CBlock对象的地址
	 */
	private int lastBlock;
	
	/**注释行数
	 */
	private short commentLines;
	
	/** 半行注释行数
	 */
	private short partialLines;
	
	/**空行
	 */
	private short blankLines;
	
	/**
	 */
	private int next;
	
}
