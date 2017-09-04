package com.example.phuongnt.myappdemo.Spell;

import com.example.phuongnt.myappdemo.Spell.Vietnamese.VietNameseWordRules.ConsonantCandQUandKRule;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.VietNameseWordRules.ConsonantGandGHRule;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.VietNameseWordRules.ConsonantNGHandNGRule;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.VietNameseWordRules.ConsonantNRule;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.VietNameseWordRules.ConsonantRandGIRule;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.VietNameseWordRules.ConsonantSRule;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.VietNameseWordRules.ConsonantTRRule;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.VietNameseWordRules.IandYRule;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.VietNameseWordRules.LimitedToneRule;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.VietNameseWordRules.SpecialUWCase;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.VietNameseWordRules.ToneNumberRule;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.VietNameseWordRules.TonePositionRule;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.VietNameseWordRules.ValidCharacterRule;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.VietNameseWordRules.ValidConsonantRule;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.VietNameseWordRules.ValidVowelRule;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.WordAnalyzer;

import java.util.ArrayList;

public enum Language implements RuleLoader {
	
	
	VIETNAMESE(){
		
		@Override
		public void loadRules(Spell spell) {
			ArrayList<Rule> rules = spell.getRules();
			rules.clear();
			WordAnalyzer.get_instance();
			rules.add(new ValidCharacterRule(0));
			rules.add(new ToneNumberRule(1));
			rules.add(new ValidConsonantRule(2)); 
			rules.add(new ValidVowelRule(3));
			rules.add(new TonePositionRule(4));
			rules.add(new LimitedToneRule(5));
			rules.add(new IandYRule(6));
			rules.add(new ConsonantNRule(7));
			rules.add(new ConsonantTRRule(8));
			rules.add(new ConsonantSRule(9));
			rules.add(new ConsonantRandGIRule(10));	
			rules.add(new ConsonantCandQUandKRule(11));
			rules.add(new ConsonantGandGHRule(12));
			rules.add(new ConsonantNGHandNGRule(13));
			rules.add(new SpecialUWCase(14));
		}
	};

	

}
