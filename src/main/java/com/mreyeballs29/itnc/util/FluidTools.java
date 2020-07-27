package com.mreyeballs29.itnc.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;

public class FluidTools {
	@SafeVarargs
	public static Map<Fluid, Item> create(MutablePair<Fluid, Item>... pairs) {
		HashMap<Fluid, Item> map = new HashMap<>();
		for (Pair<Fluid, Item> pair : pairs) {
			map.put(pair.getLeft(), pair.getRight());
		}
		return map;
	}
}
