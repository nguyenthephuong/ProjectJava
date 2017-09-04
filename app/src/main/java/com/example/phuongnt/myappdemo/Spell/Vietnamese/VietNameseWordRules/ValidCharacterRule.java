package com.example.phuongnt.myappdemo.Spell.Vietnamese.VietNameseWordRules;

import com.example.phuongnt.myappdemo.Spell.Rule;

import java.util.regex.Pattern;

public class ValidCharacterRule extends Rule {
	
	private String vietnamese_characters = "ẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐÐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ";
	
	public ValidCharacterRule(int id) {
		super(id);
		this.msg = new String("Ky tu ko ton tai trong Tieng Viet");
	}

	@Override
	public boolean checkValid(String x) {
//		Pattern vn_word_pattern = Pattern.compile("(?:[" + vietnamese_characters +"]|[A-Z&&[^WFJZ]])++",Pattern.CANON_EQ|Pattern.UNICODE_CASE|Pattern.CASE_INSENSITIVE);
		Pattern vn_word_pattern = Pattern.compile("(?:[" + vietnamese_characters +"]|[A-Z&&[^WFJZ]])++",Pattern.UNICODE_CASE|Pattern.CASE_INSENSITIVE);
		return vn_word_pattern.matcher(x).matches();
	}

}
