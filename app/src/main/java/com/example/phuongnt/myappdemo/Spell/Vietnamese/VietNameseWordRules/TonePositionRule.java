package com.example.phuongnt.myappdemo.Spell.Vietnamese.VietNameseWordRules;

import com.example.phuongnt.myappdemo.Spell.Rule;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.Tone;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.Vowel;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.WordAnalyzer;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.WordComponents;

public class TonePositionRule extends Rule {

	public TonePositionRule(int id) {
		super(id);
		this.msg = new String("Vi tri dau thanh khong hop le");
	}
	
	@Override
	public boolean checkValid(String x) {
		
		WordComponents comp = WordAnalyzer.get_instance().analyze(x);

		Vowel vowel = WordAnalyzer.get_instance().vowel_table.get(comp.vowel);
		if(x.equalsIgnoreCase("QUỆT"))
			return true;
		
		return (vowel != null && vowel.check_tone_pos(comp.tone_pos) || comp.tone == Tone.UNMARK) ? true : false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
