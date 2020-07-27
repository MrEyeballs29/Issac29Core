package com.mreyeballs29.itnc.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.minecraft.item.ItemStack;

public class ListCreator {
	
	public static List<ItemStack> create(ItemStack... items) {
		List<ItemStack> list = new ArrayList<>();
		Collections.addAll(list, items);
		return list;
	}
}
