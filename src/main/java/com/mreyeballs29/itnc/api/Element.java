package com.mreyeballs29.itnc.api;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class Element implements IElement {

	private Symbol symbol;
	private State state;
	private String name;
	
	public static final Element HYDROGEN = new Element("hydrogen", "h", State.GAS);
	public static final Element HELIUM = new Element("helium", "he", State.GAS);
	public static final Element LITHIUM = new Element("lithium", "li", State.SOLID);
	
	public Element(String name, String str, State state) {
		this.name = name;
		this.symbol = new Symbol(str);
		this.state = state;
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

	@Override
	public State getState() {
		return this.state;
	}

	@Override
	public ITextComponent getDescription() {
		return new TranslationTextComponent("desciption.database." + this.name);
	}

}
