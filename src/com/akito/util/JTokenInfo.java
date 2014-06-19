package com.akito.util;

import com.sun.tools.javac.parser.Token;

public class JTokenInfo {
	
	private Token token;
	private int row;
	private int col;
	
	
	public JTokenInfo(Token token, int row, int col) {
		super();
		this.token = token;
		this.row = row;
		this.col = col;
	}
	
	public Token getToken() {
		return token;
	}
	
	public void setToken(Token token) {
		this.token = token;
	}
	
	public int getRow() {
		return row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setCol(int col) {
		this.col = col;
	}
	
	@Override
	public String toString() {
		return token.toString() + ": " + "row = " + row + " col = " + col;
	}

}
