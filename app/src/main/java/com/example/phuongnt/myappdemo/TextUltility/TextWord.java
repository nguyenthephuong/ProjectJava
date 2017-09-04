package com.example.phuongnt.myappdemo.TextUltility;

public class TextWord {

	public Text parent_text;
	public int begin;
	public int end;
	
	public String getString(){
		return parent_text.content.substring(begin, end);
	}
	
	public TextWord(Text text, int begin, int offset) {
		this.parent_text = text;
		this.begin = begin;
		this.end = offset;
	}
	
}
