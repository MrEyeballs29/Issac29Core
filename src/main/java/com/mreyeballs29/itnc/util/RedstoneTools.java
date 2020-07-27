package com.mreyeballs29.itnc.util;

import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.items.ItemStackHandler;

public class RedstoneTools {

	public static int calcuateTank(FluidTank tank) {
		if (tank == null || tank.getFluid().getFluid() == Fluids.EMPTY) {
			return 0;
		}
		int amount = tank.getFluidAmount();
		int max = tank.getCapacity();
		float f = (float) amount / max;
		return (int) (f * 14) + (f > 0 ? 1 : 0);
	}

	public static int calcuateEnergy(EnergyStorage storage) {
		if (storage == null) {
			return 0;
		}
		int amount = storage.getEnergyStored();
		int max = storage.getMaxEnergyStored();
		float f = (float) amount / max;
		return (int) (f*14) + (f > 0 ? 1 : 0);
	}

	public static int calcuateInventory(ItemStackHandler handler) {
		if (handler == null) {
			return 0;
		}
		int i = 0;
		float f = 0.0F;

		for (int j = 0; j < handler.getSlots(); ++j) {
			ItemStack itemstack = handler.getStackInSlot(j);
			if (!itemstack.isEmpty()) {
				f += (float) itemstack.getCount()
						/ (float) Math.min(handler.getSlotLimit(j), itemstack.getMaxStackSize());
				++i;
			}
		}

		f = f / handler.getSlots();
		return MathHelper.floor(f * 14.0F) + (i > 0 ? 1 : 0);
	}
}
