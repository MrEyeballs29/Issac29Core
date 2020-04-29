package com.mreyeballs29.itnc.tileentity;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;

public class CrateTile extends TileEntity {
	
	private LazyOptional<ItemStackHandler> handler = LazyOptional.of(this::createHandler); 
	
	public CrateTile(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}
	
	@Override
	public void read(CompoundNBT compound) {
		CompoundNBT nbtinv = compound.getCompound("items");
		handler.ifPresent(h -> h.deserializeNBT(nbtinv));
		super.read(compound);
	}
	
	private ItemStackHandler createHandler() {
		return new ItemStackHandler(15);
	}
}
