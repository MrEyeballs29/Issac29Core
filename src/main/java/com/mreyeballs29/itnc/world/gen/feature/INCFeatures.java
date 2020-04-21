package com.mreyeballs29.itnc.world.gen.feature;

import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class INCFeatures {

	public static final Feature<ExtendedOreFeatureConfig> EXTENDED_ORE = new ExtendedOreFeature(ExtendedOreFeatureConfig::deserialize);
	
	@SubscribeEvent
	public static void onFeaturesRegistry(final RegistryEvent.Register<Feature<?>> featureRegistryEvent) {
		EXTENDED_ORE.setRegistryName("itnc:extended_ore");
		IForgeRegistry<Feature<?>> featureRegistry = featureRegistryEvent.getRegistry();
		featureRegistry.register(EXTENDED_ORE);
	}
}