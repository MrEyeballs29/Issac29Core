package com.mreyeballs29.itnc.tileentity.fluid;

import java.util.function.Predicate;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.templates.FluidTank;

public class ManualTank extends FluidTank {
	private TileEntity tile;

	public ManualTank(int arg0, Predicate<FluidStack> arg1) {
		super(arg0, arg1);
	}

	public ManualTank(int capacity, TileEntity tile) {
		super(capacity);
		this.tile = tile;
	}

	public ManualTank(int i, TileEntity tankTileEntity, Predicate<FluidStack> object) {
		super(i, object);
		this.tile = tankTileEntity;
	}

	@Override
	protected void onContentsChanged() {
		this.tile.markDirty();
	}

	public void addFluid(int amount) {
		if (this.getFluid() == FluidStack.EMPTY)
			return;
		this.getFluid().grow(amount);
	}

	public void subtractFluid(int amount) {
		if (this.getFluid() == FluidStack.EMPTY)
			return;
		this.getFluid().shrink(amount);
	}
}
