package com.mreyeballs29.issactncore.item;

import java.util.HashSet;
import java.util.Set;

import com.mreyeballs29.issactncore.util.Element;

import net.minecraft.item.Item;

public class ItemElementIcon extends Item {

	private final static Set<Element> ELEMENT_SET = new HashSet<Element>(Byte.MAX_VALUE);
	
	public ItemElementIcon() {
		ELEMENT_SET.add(null);
	}

}
