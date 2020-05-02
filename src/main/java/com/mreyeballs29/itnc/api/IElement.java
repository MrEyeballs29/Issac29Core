package com.mreyeballs29.itnc.api;

public interface IElement {
	Symbol getSymbol();
	
	boolean hasSymbol();
	
	boolean isFlammable();
	
	boolean isTool();
	
	boolean isArmor();
	
	int getProcessAmount();
}