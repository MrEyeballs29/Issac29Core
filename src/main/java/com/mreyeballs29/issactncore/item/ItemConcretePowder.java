package com.mreyeballs29.issactncore.item;

import net.minecraft.item.EnumDyeColor;

public class ItemConcretePowder extends ItemMeta {
	
	public ItemConcretePowder() {
		super(convert(0), convert(1));
	}
	
	private static String[] convert(int mode) {
		EnumDyeColor[] objects = EnumDyeColor.values();
		String[] strings = new String[objects.length];
		switch (mode) {
		case 1:
			for (int i = 0; i < objects.length; i++)
				{strings[i] = objects[i].getUnlocalizedName();}
			break;
		default:
			for (int i = 0; i < objects.length; i++)
				{strings[i] = objects[i].getName();}
		}
		return strings;
	}
}
