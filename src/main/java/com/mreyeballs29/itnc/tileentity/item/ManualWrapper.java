package com.mreyeballs29.itnc.tileentity.item;

import com.mreyeballs29.itnc.tileentity.CrateTileEntity;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.items.ItemStackHandler;

public class ManualWrapper extends ItemStackHandler {

	private CrateTileEntity tile;
	
	public ManualWrapper(int size, CrateTileEntity tile) {
		super(size);
		this.tile = tile;
	}

	public ManualWrapper(NonNullList<ItemStack> stacks) {
		super(stacks);
	}
	
	@Override
	protected void onContentsChanged(int slot) {
		this.tile.markDirty();
	}
}
