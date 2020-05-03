package com.mreyeballs29.itnc.tileentity.fluid;

import java.util.function.Predicate;

import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.templates.FluidTank;

public class ManualTank extends FluidTank {
    public ManualTank(int arg0, Predicate<FluidStack> arg1) {
    	super(arg0, arg1);
	}
	
	public ManualTank(int capacity) {
		super(capacity);
	}
	
}
