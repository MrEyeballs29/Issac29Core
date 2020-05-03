package com.mreyeballs29.itnc.api;

import net.minecraft.util.text.ITextComponent;

public interface IElement {
	/**
	 * 
	 * @return the Symbol used for scanner
	 */
	Symbol getSymbol();
	
	boolean hasSymbol();
	
	boolean isFlammable();
	
	boolean isTool();
	
	boolean isArmor();
	
	int getProcessAmount();
	
	State getState();
	
	ITextComponent getDescription();
}