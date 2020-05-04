package com.mreyeballs29.itnc.inventory;

import com.mreyeballs29.itnc.Isacc29Core;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder("itnc")
public class INContainerTypes {
	
	@ObjectHolder("crate")
	public static ContainerType<CrateContainer> CRATE;

	@SuppressWarnings("resource")
	@SubscribeEvent
    public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event) {
        event.getRegistry().register(IForgeContainerType.create((windowId, inv, data) -> {
            BlockPos pos = data.readBlockPos();
            return new CrateContainer(windowId, Isacc29Core.object.getWorld(), pos, inv, Isacc29Core.object.getPlayer());
        }).setRegistryName("itnc:crate"));
    }
}
