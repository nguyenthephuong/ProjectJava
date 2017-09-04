package com.example.phuongnt.myappdemo.Spell.Vietnamese.VietNameseWordRules;

import com.example.phuongnt.myappdemo.Spell.Rule;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.Tone;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.ToneVowel;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.WordAnalyzer;

public class ToneNumberRule extends Rule {
	
	public ToneNumberRule(int id) {
		super(id);
		this.msg = new String("So dau thanh khong hop le");
	}
	
	@Override
	public boolean checkValid(String x) {
		String upper = x.toUpperCase();
		int tone_count = 0;
		for(int i = 0; i < x.length(); i++){
			ToneVowel vw = WordAnalyzer.get_instance().tone_table.get(upper.charAt(i));
			tone_count += (vw != null && vw.tone != Tone.UNMARK) ? 1 : 0;
			if(tone_count > 1)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
