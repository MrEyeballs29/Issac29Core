package com.mreyeballs29.itnc.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.minecraft.item.Item;

public class ListCreator {
	@SafeVarargs
	public static List<Item> create(Item... items) {
		List<Item> list = new ArrayList<>();
		Collections.addAll(list, items);
		return list;
	}
}
