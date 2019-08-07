package com.mreyeballs29.issactncore.item;

import com.mreyeballs29.issactncore.util.EnumSeries;
import com.mreyeballs29.issactncore.util.EnumShape;

import net.minecraft.item.Item;

public abstract class ItemElement extends Item {
	public abstract EnumSeries getSeries();
	
	public abstract int getLength();
	
	public abstract EnumShape getShape();
	
	public abstract void registerModels();

	protected ItemElement() {}
}
