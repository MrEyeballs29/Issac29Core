package com.mreyeballs29.itnc.item.crafting;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(bus = Bus.MOD)
public class INCRecipeSerializers {
	public static final IRecipeSerializer<?> MORTAR = new MortarRecipe.Serializer().setRegistryName(new ResourceLocation("itnc", "mortar_and_pestling")); //$NON-NLS-1$ //$NON-NLS-2$
	
	@SubscribeEvent
	public static void onRecipeSerializersRegistry(final RegistryEvent.Register<IRecipeSerializer<?>> register) {
		IForgeRegistry<IRecipeSerializer<?>> forgeRegistry = register.getRegistry();
		forgeRegistry.register(MORTAR);
	}
}
