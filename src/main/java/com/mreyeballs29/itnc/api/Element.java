package com.mreyeballs29.itnc.api;

public class Element implements IElement {

	private Symbol symbol;
	
	public static final Element HYDROGEN = new Element("h");
	public static final Element HEILUM = new Element("he");
	public static final Element LITHIUM = new Element("li");
	
	public Element(String str) {
		this.symbol = new Symbol(str);
	}

	@Override
	public Symbol getSymbol() {
		return this.symbol;
	}

	@Override
	public boolean hasSymbol() {
		return true;
	}

	@Override
	public boolean isFlammable() {
		return false;
	}

	@Override
	public boolean isTool() {
		return false;
	}

	@Override
	public boolean isArmor() {
		return false;
	}

	@Override
	public int getProcessAmount() {
		return 1;
	}

}
