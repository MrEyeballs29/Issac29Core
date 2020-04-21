package com.mreyeballs29.itnc.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FuelItem extends Item {

	private int burnTime;
	
	public FuelItem(Properties properties, int burn) {
		super(properties);
		this.burnTime = burn >= 0 ? burn : 0;
	}

	@Override
	public int getBurnTime(ItemStack itemStack) {
		return this.burnTime;
	}
}
