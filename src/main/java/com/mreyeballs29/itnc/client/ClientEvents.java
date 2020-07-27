package com.mreyeballs29.itnc.client;

import com.mreyeballs29.itnc.tags.INCFluidTags;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityViewRenderEvent.FogColors;
import net.minecraftforge.client.event.EntityViewRenderEvent.FogDensity;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(value = Dist.CLIENT, bus = Bus.FORGE)
public class ClientEvents {

	@SubscribeEvent
	public static void onFogDensity(FogDensity event) {
		if (event.getInfo().getFluidState().isTagged(INCFluidTags.OIL)) {
			event.setDensity(0.075f);
			event.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	public static void onFogColors(FogColors event) {
		if (event.getInfo().getFluidState().isTagged(INCFluidTags.OIL)) {
			event.setGreen(0.0f);
			event.setRed(0.0f);
			event.setBlue(0.0f);
		}
	}
	
	
}
