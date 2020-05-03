package com.mreyeballs29.itnc.tileentity.item;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.items.ItemStackHandler;

public class ManualWrapper extends ItemStackHandler {

	public ManualWrapper(int size) {
		super(size);
	}

	public ManualWrapper(NonNullList<ItemStack> stacks) {
		super(stacks);
	}

	@Override
	public boolean isItemValid(int slot, ItemStack stack) {
		return true;
	}
	
	
}
