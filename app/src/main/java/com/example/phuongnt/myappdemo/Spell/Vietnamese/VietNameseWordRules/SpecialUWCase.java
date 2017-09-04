package com.example.phuongnt.myappdemo.Spell.Vietnamese.VietNameseWordRules;

import com.example.phuongnt.myappdemo.Spell.Rule;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.WordAnalyzer;
import com.example.phuongnt.myappdemo.Spell.Vietnamese.WordComponents;

public class SpecialUWCase extends Rule {

	private String[] cons = new String[]{"QU", "H", "TH"};
	
	public SpecialUWCase(int id) {
		super(id);
		this.msg = new String("Sai chinh ta nguyen am U\\OW\\");
	}
	
	@Override
	public boolean checkValid(String x) {
		WordComponents comp = WordAnalyzer.get_instance().analyze(x);
		
		String cons_str = comp.consonant;
		String vowel = comp.vowel;
		
		if(vowel.length() >= 2){
			String diph = vowel.substring(0, 2);
			if(diph.equals("UƠ")){
				for(String i : cons){
					if(i.equals(cons_str))
						return true;
				}
				return false;
			}
			
		}
		
		return true;
	}

}
