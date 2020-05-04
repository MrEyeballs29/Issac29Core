package com.mreyeballs29.itnc.inventory;

import net.minecraft.client.Minecraft;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
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
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
    public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event) {
        event.getRegistry().register(IForgeContainerType.create((windowId, inv, data) -> {
            BlockPos pos = data.readBlockPos();
            return new CrateContainer(windowId, Minecraft.getInstance().world, pos, inv, Minecraft.getInstance().player);
        }).setRegistryName("itnc:crate"));
    }
}
