package com.mreyeballs29.itnc.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder("itnc")
public class INCSoundEvents {
	private static final List<SoundEvents> LIST = new ArrayList<>();

	@SubscribeEvent
	public static void onSoundEventRegistry(final RegistryEvent.Register<SoundEvent> soundRegistryEvent) {
		initalizeSoundEvents();
		IForgeRegistry<SoundEvent> itemRegistry = soundRegistryEvent.getRegistry();
		itemRegistry.registerAll(LIST.toArray(new SoundEvent[0]));
	}

	/**
	 * Initialize sounds
	 */
	private static void initalizeSoundEvents() {
		System.console();
	}
}
