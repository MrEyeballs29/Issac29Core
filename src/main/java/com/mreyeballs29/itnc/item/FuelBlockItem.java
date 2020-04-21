package com.mreyeballs29.itnc.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class FuelBlockItem extends BlockItem {

	private int burnTime;
	
	public FuelBlockItem(Block blockIn, Properties builder, int burnTime) {
		super(blockIn, builder);
		this.burnTime = burnTime >= 0 ? burnTime : 0;
	}

	@Override
	public int getBurnTime(ItemStack itemStack) {
		return this.burnTime;
	}
	
}
