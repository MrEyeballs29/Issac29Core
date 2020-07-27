package com.mreyeballs29.itnc.api;

public class Symbol {

	public static final Symbol NONE = new Symbol(""); //$NON-NLS-1$
	
	private char[] characters = new char[3];
	private int quanity;
	
	public Symbol(String str, int quanity) {
		if (str.length() > 3) throw new IllegalArgumentException("Cannot have symbols greater than 3"); //$NON-NLS-1$
		char[] charray = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			char char1 = str.charAt(i);
			if (!Character.isLetter(char1) && char1 > 127) throw new IllegalStateException("Cannot have a non-letter symbol."); //$NON-NLS-1$
			if (i == 0) {
				char1 = Character.toUpperCase(char1);
			} else {
				char1 = Character.toLowerCase(char1);
			}
			charray[i] = char1;
		}
		this.characters = charray;
		this.quanity = quanity;
	}
	
	public Symbol(String str) {
		this(str, 0);
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}
	
	@Override
	public String toString() {
		if (this.quanity > 1) return String.valueOf(this.characters) + '_' + this.quanity;
		return String.valueOf(this.characters);
	}
}
