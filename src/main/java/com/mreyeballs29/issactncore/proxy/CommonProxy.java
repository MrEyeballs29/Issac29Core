package com.mreyeballs29.issactncore.proxy;

import com.mreyeballs29.issactncore.util.EnumShape;

import net.minecraft.item.Item;

public abstract class CommonProxy {

	public abstract void preInit();
	
	public void init() {

	}
	
	public abstract void postInit();

	public abstract void registerModel(Item item, int meta, String type);

	public abstract void registerModel(Item item, int meta, String type, EnumShape shape, String string);

	public abstract void registerModel(Item item, int meta, String type, String add);

	public abstract void registerModel(Item item, int meta, String type, String apply, String custom);
}
