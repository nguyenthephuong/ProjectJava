package com.example.phuongnt.myappdemo.Spell.Vietnamese.VietNameseWordRules;

import com.example.phuongnt.myappdemo.Spell.Rule;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.WordAnalyzer;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.WordComponents;

public class IandYRule extends Rule {
	
	private String[] pre_cons_y = new String[]{"H", "K", "L", "M", "S", "T", "V", ""};
	
	public IandYRule(int id) {
		super(id);
		this.msg = new String("Sai cach dung I va Y");
	}
	
	@Override
	public boolean checkValid(String x) {
		
		WordComponents comp = WordAnalyzer.get_instance().analyze(x);
		
		String cons = comp.consonant;
		String vowel = comp.vowel;
		int length = vowel.length();
		
		if(length > 2){
			String diphthong = vowel.substring(0, 2);
			if(diphthong.equals("IÊ") && comp.consonant.equals(""))
				return false;
			
			if(diphthong.equals("YÊ") && !comp.consonant.equals(""))
				return false;
		}
		else if(length == 1){
			if(vowel.equals("Y")){
				for(String i : pre_cons_y)
					if(i.equals(cons))
						return true;
				return false;
			}
		}
		
			
		return true;
	}

}
