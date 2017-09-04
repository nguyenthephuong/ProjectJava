package com.example.phuongnt.myappdemo.Spell.Vietnamese;

import java.util.HashMap;

public class VowelTable extends HashMap<String, Vowel> {

	public VowelTable(){
		load();
	}

	private void load(){

		//monophthong
		this.put("A", new Vowel("A", new int[]{0}));
		this.put("E", new Vowel("E", new int[]{0}));
		this.put("I", new Vowel("I", new int[]{0}));
		this.put("O", new Vowel("O", new int[]{0}));
		this.put("Ô", new Vowel("Ô", new int[]{0}));
		this.put("Ơ", new Vowel("Ơ", new int[]{0}));
		this.put("U", new Vowel("U", new int[]{0}));
		this.put("Ư", new Vowel("Ư", new int[]{0}));
		this.put("Y", new Vowel("Y", new int[]{0}));
		this.put("Ê", new Vowel("Ê", new int[]{0}));

		//diphthongs
		this.put("OA", new Vowel("OA", new int[]{0,1}));
		this.put("OE", new Vowel("OE", new int[]{0,1}));
		this.put("UY", new Vowel("UY", new int[]{0,1}));
		this.put("UÊ", new Vowel("UÊ", new int[]{1}));
		this.put("UƠ", new Vowel("UƠ", new int[]{1}));
		this.put("IA", new Vowel("IA", new int[]{0}));
		this.put("UA", new Vowel("UA", new int[]{0}));
		this.put("ƯA", new Vowel("ƯA", new int[]{0}));
		this.put("AI", new Vowel("AI", new int[]{0}));
		this.put("OI", new Vowel("OI", new int[]{0}));
		this.put("ÔI", new Vowel("ÔI", new int[]{0}));
		this.put("ƠI", new Vowel("ƠI", new int[]{0}));
		this.put("UI", new Vowel("UI", new int[]{0}));
		this.put("ƯI", new Vowel("ƯI", new int[]{0}));
		this.put("AO", new Vowel("AO", new int[]{0}));
		this.put("EO", new Vowel("EO", new int[]{0}));
		this.put("AU", new Vowel("AU", new int[]{0}));
		this.put("ÂU", new Vowel("ÂU", new int[]{0}));
		this.put("ÊU", new Vowel("ÊU", new int[]{0}));
		this.put("IU", new Vowel("IU", new int[]{0}));
		this.put("ƯU", new Vowel("ƯU", new int[]{0}));
		this.put("AY", new Vowel("AY", new int[]{0}));
		this.put("ÂY", new Vowel("ÂY", new int[]{0}));

		//triphthongs
		this.put("UYA", new Vowel("UYA", new int[]{1}));
		this.put("OAI", new Vowel("OAI", new int[]{1}));
		this.put("UÔI", new Vowel("UÔI", new int[]{1}));
		this.put("ƯƠI", new Vowel("ƯƠI", new int[]{1}));
		this.put("OAO", new Vowel("OAO", new int[]{1}));
		this.put("OEO", new Vowel("OEO", new int[]{1}));
		this.put("IÊU", new Vowel("IÊU", new int[]{1}));
		this.put("UYU", new Vowel("UYU", new int[]{1}));
		this.put("ƯƠU", new Vowel("ƯƠU", new int[]{1}));
		this.put("YÊU", new Vowel("YÊU", new int[]{1}));
		this.put("OAY", new Vowel("OAY", new int[]{1}));
		this.put("UÂY", new Vowel("UÂY", new int[]{1}));

		// with consonant 'c'
		this.put("AC", new Vowel("AC", new int[]{0}));
		this.put("ĂC", new Vowel("ĂC", new int[]{0}));
		this.put("ÂC", new Vowel("ÂC", new int[]{0}));
		this.put("EC", new Vowel("EC", new int[]{0}));
		this.put("IÊC", new Vowel("IÊC", new int[]{1}));
		this.put("OC", new Vowel("OC", new int[]{0}));
		this.put("OAC", new Vowel("OAC", new int[]{1}));
		this.put("OĂC", new Vowel("OĂC", new int[]{1}));
		this.put("OOC", new Vowel("OOC", new int[]{1}));
		this.put("ÔC", new Vowel("ÔC", new int[]{0}));
		this.put("UC", new Vowel("UC", new int[]{0}));
		this.put("UÔC", new Vowel("UÔC", new int[]{1}));
		this.put("ƯC", new Vowel("ƯC", new int[]{0}));
		this.put("ƯƠC", new Vowel("ƯƠC", new int[]{1}));

		//with consonant 'ch'
		this.put("ACH", new Vowel("ACH", new int[]{0}));
		this.put("ÊCH", new Vowel("ÊCH", new int[]{0}));
		this.put("ICH", new Vowel("ICH", new int[]{0}));
		this.put("OACH", new Vowel("OACH", new int[]{1}));
		this.put("UÊCH", new Vowel("UÊCH", new int[]{1}));
		this.put("UYCH", new Vowel("UYCH", new int[]{1}));

		//with consonant 'm'
		this.put("AM", new Vowel("AM", new int[]{0}));
		this.put("ĂM", new Vowel("ĂM", new int[]{0}));
		this.put("ÂM", new Vowel("ÂM", new int[]{0}));
		this.put("EM", new Vowel("EM", new int[]{0}));
		this.put("ÊM", new Vowel("ÊM", new int[]{0}));
		this.put("IM", new Vowel("IM", new int[]{0}));
		this.put("IÊM", new Vowel("IÊM", new int[]{1}));
		this.put("OM", new Vowel("OM", new int[]{0}));
		this.put("OAM", new Vowel("OAM", new int[]{1}));
		this.put("OĂM", new Vowel("OĂM", new int[]{1}));
		this.put("OEM", new Vowel("OEM", new int[]{1}));
		this.put("ÔM", new Vowel("ÔM", new int[]{0}));
		this.put("ƠM", new Vowel("ƠM", new int[]{0}));
		this.put("UM", new Vowel("UM", new int[]{0}));
		this.put("UÔM", new Vowel("UÔM", new int[]{1}));
		this.put("ƯM", new Vowel("ƯM", new int[]{0}));
		this.put("ƯƠM", new Vowel("ƯƠM", new int[]{1}));
		this.put("YÊM", new Vowel("YÊM", new int[]{1}));

		//with consonant 'n'
		this.put("AN", new Vowel("AN", new int[]{0}));
		this.put("ĂN", new Vowel("ĂN", new int[]{0}));
		this.put("ÂN", new Vowel("ÂN", new int[]{0}));
		this.put("EN", new Vowel("EN", new int[]{0}));
		this.put("ÊN", new Vowel("ÊN", new int[]{0}));
		this.put("IN", new Vowel("IN", new int[]{0}));
		this.put("IÊN", new Vowel("IÊN", new int[]{1}));
		this.put("ON", new Vowel("ON", new int[]{0}));
		this.put("OAN", new Vowel("OAN", new int[]{1}));
		this.put("OĂN", new Vowel("OĂN", new int[]{1}));
		this.put("OEN", new Vowel("OEN", new int[]{1}));
		this.put("ÔN", new Vowel("ÔN", new int[]{0}));
		this.put("ƠN", new Vowel("ƠN", new int[]{0}));
		this.put("UN", new Vowel("UN", new int[]{0}));
		this.put("UÂN", new Vowel("UÂN", new int[]{1}));
		this.put("UÔN", new Vowel("UÔN", new int[]{1}));
		this.put("UYN", new Vowel("UYN", new int[]{1}));
		this.put("UYÊN", new Vowel("UYÊN", new int[]{2}));
		this.put("ƯN", new Vowel("ƯN", new int[]{0}));
		this.put("ƯƠN", new Vowel("ƯƠN", new int[]{1}));
		this.put("YÊN", new Vowel("YÊN", new int[]{1}));

		//with consonant 'ng'
		this.put("ANG", new Vowel("ANG", new int[]{0}));
		this.put("ĂNG", new Vowel("ĂNG", new int[]{0}));
		this.put("ÂNG", new Vowel("ÂNG", new int[]{0}));
		this.put("ENG", new Vowel("ENG", new int[]{0}));
		this.put("IÊNG", new Vowel("IÊNG", new int[]{1}));
		this.put("ONG", new Vowel("ONG", new int[]{0}));
		this.put("OANG", new Vowel("OANG", new int[]{1}));
		this.put("OĂNG", new Vowel("OĂNG", new int[]{1}));
		this.put("OONG", new Vowel("OONG", new int[]{1}));
		this.put("ÔNG", new Vowel("ÔNG", new int[]{0}));
		this.put("UNG", new Vowel("UNG", new int[]{0}));
		this.put("UÂNG", new Vowel("UÂNG", new int[]{1}));
		this.put("UÔNG", new Vowel("UÔNG", new int[]{1}));
		this.put("ƯNG", new Vowel("ƯNG", new int[]{0}));
		this.put("ƯƠNG", new Vowel("ƯƠNG", new int[]{1}));
		this.put("YÊNG", new Vowel("YÊNG", new int[]{1}));

		//with consonant 'nh'
		this.put("ANH", new Vowel("ANH", new int[]{0}));
		this.put("ÊNH", new Vowel("ÊNH", new int[]{0}));
		this.put("INH", new Vowel("INH", new int[]{0}));
		this.put("OANH", new Vowel("OANH", new int[]{1}));
		this.put("UÊNH", new Vowel("UÊNH", new int[]{1}));
		this.put("UYNH", new Vowel("UYNH", new int[]{1}));

		//with consonant 'p'
		this.put("AP", new Vowel("AP", new int[]{0}));
		this.put("ĂP", new Vowel("ĂP", new int[]{0}));
		this.put("ÂP", new Vowel("ÂP", new int[]{0}));
		this.put("EP", new Vowel("EP", new int[]{0}));
		this.put("ÊP", new Vowel("ÊP", new int[]{0}));
		this.put("IP", new Vowel("IP", new int[]{0}));
		this.put("IÊP", new Vowel("IÊP", new int[]{1}));
		this.put("OP", new Vowel("OP", new int[]{0}));
		this.put("OAP", new Vowel("OAP", new int[]{1}));
		this.put("OĂP", new Vowel("OĂP", new int[]{1}));
		this.put("ÔP", new Vowel("ÔP", new int[]{0}));
		this.put("ƠP", new Vowel("ƠP", new int[]{0}));
		this.put("UP", new Vowel("UP", new int[]{0}));
		this.put("UÔP", new Vowel("UÔP", new int[]{1}));
		this.put("ƯƠP", new Vowel("ƯƠP", new int[]{1}));

		//with consonant 't'
		this.put("AT", new Vowel("AT", new int[]{0}));
		this.put("ĂT", new Vowel("ĂT", new int[]{0}));
		this.put("ÂT", new Vowel("ÂT", new int[]{0}));
		this.put("ET", new Vowel("ET", new int[]{0}));
		this.put("ÊT", new Vowel("ÊT", new int[]{0}));
		this.put("IT", new Vowel("IT", new int[]{0}));
		this.put("IÊT", new Vowel("IÊT", new int[]{1}));
		this.put("OT", new Vowel("OT", new int[]{0}));
		this.put("OAT", new Vowel("OAT", new int[]{1}));
		this.put("OĂT", new Vowel("OĂT", new int[]{1}));
		this.put("OET", new Vowel("OET", new int[]{1}));
		this.put("ÔT", new Vowel("ÔT", new int[]{0}));
		this.put("ƠT", new Vowel("ƠT", new int[]{0}));
		this.put("UT", new Vowel("UT", new int[]{0}));
		this.put("UÂT", new Vowel("UÂT", new int[]{1}));
		this.put("UÔT", new Vowel("UÔT", new int[]{1}));
		this.put("UYT", new Vowel("UYT", new int[]{1}));
		this.put("UYÊT", new Vowel("UYÊT", new int[]{2}));
		this.put("ƯT", new Vowel("ƯT", new int[]{0}));
		this.put("ƯƠT", new Vowel("ƯƠT", new int[]{1}));
		this.put("YÊT", new Vowel("YÊT", new int[]{1}));

	}
	
	public static void main(String[] args){
		VowelTable table = new VowelTable();
		System.out.println(table.get("UY�N") != null);
	}
}
