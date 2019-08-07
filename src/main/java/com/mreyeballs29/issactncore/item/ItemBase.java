package com.mreyeballs29.issactncore.item;

import com.mreyeballs29.issactncore.Issac29Core;
import com.mreyeballs29.issactncore.util.EnumSeries;

public abstract class ItemBase extends ItemElement {
	
	@Override
	public EnumSeries getSeries() {
		return EnumSeries.BASE;
	}
	
	@Override
	public int getLength() {
		return 16;
	}
	
	protected ItemBase() {
		this.setHasSubtypes(true);
	}
	
	@Override
	public void registerModels() {
		for (EnumBaseMetal base : EnumBaseMetal.values()) {
			Issac29Core.proxy.registerModel(this, base.getId(), "inventory", getShape(), base.getName());
		}
	}
}
