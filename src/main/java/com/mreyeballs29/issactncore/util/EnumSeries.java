package com.mreyeballs29.issactncore.util;

import com.mreyeballs29.issactncore.item.EnumBaseMetal;
import com.mreyeballs29.issactncore.item.EnumPreciousMetal;

import net.minecraft.block.BlockPlanks;
import net.minecraft.item.EnumDyeColor;

public enum EnumSeries {
	VANILLA(4, null),
	BASE(16, EnumBaseMetal.values()),
	PRECOUS(16, EnumPreciousMetal.values()),
	NONMETAL(8, null),
	WOOD(6, BlockPlanks.EnumType.values()),
	GEM(8, null),
	MINERAL(8, null),
	DYES(16, EnumDyeColor.values()),
	STONE(4, null),
	UNKNOWN;
	
	private Enum<?>[] enums;
	private int size;
	
	EnumSeries() {
		this(0, null);
		
	}
	
	EnumSeries(int amount, Enum<?>[] emums) {
		enums = emums;
		size = amount;
	}
	
	public int getSize() {
		return size;
	}
	
	public Enum<?>[] getEnums() {
		return enums;
	}
	
	@Override
	public String toString() {
		String str1 = this.name().toLowerCase();
		str1 = str1.replaceAll("_", " ");
		String[] starr1 = str1.split(" ");
		str1 = "";
		int i = 0;
		for (String str2 : starr1) {
			i += 1;
			if (i == starr1.length) {
				str1 += str2.toLowerCase();
			} else {
				str1 += str2.toLowerCase() + "_";
			}
		}
		return str1;
	}
}
