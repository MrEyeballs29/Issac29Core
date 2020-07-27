package com.mreyeballs29.itnc.fluid;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.fluid.Fluid;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(bus = Bus.MOD)
public class INCFluids {
	
	private static final List<Fluid> FLUID = new ArrayList<>();
	
	public static final OilFluid.Flowing OIL_FLOWING = new OilFluid.Flowing();
	public static final OilFluid.Source OIL = new OilFluid.Source();
	
	private static void initalizeFluids() {
		FLUID.add(OIL_FLOWING);
		FLUID.add(OIL);
	}

	@SubscribeEvent
	public static void onFluidsRegistry(final RegistryEvent.Register<Fluid> fluidRegistryEvent) {
		initalizeFluids();
		IForgeRegistry<Fluid> fluidRegistry = fluidRegistryEvent.getRegistry();
		fluidRegistry.registerAll(FLUID.toArray(new Fluid[0]));
	}
}
