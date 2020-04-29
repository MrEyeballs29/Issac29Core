package com.mreyeballs29.itnc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mreyeballs29.itnc.block.INCBlocks;
import com.mreyeballs29.itnc.world.OreGeneration;

import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.GameRules;
import net.minecraft.world.GameRules.BooleanValue;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("itnc")
public class Isacc29Core {
    
	public static final Logger logger = LogManager.getFormatterLogger();
	
	public Isacc29Core() {
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::onClientSetup);
        bus.addListener(this::onCommonSetup);
    }
	
	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {
		MinecraftServer server = event.getServer();
		GameRules rules = server.getGameRules();
		BooleanValue ruleValue = rules.get(GameRules.DO_LIMITED_CRAFTING);
		if (!ruleValue.get()) ruleValue.set(true, server);
	}
	
	public void onCommonSetup(FMLCommonSetupEvent ev) {
		OreGeneration.addCommonOre(INCBlocks.COPPER_ORE, 9, 18, 96, 0, 0);
		OreGeneration.addCommonOre(INCBlocks.TIN_ORE, 9, 15, 56, 0, 0);
		OreGeneration.addCommonOre(INCBlocks.SILVER_ORE, 9, 9, 40, 0, 0);
		OreGeneration.addCommonOre(INCBlocks.LEAD_ORE, 9, 12, 60, 12, 0);
		OreGeneration.addCommonOre(Blocks.CLAY, 16, 8, 60, 0, 0);
		OreGeneration.addDesertOre();
		OreGeneration.addCommonOre(INCBlocks.LIGNITE_ORE, 18, 22, 160, 0, 0);
		OreGeneration.addNetherOre(INCBlocks.NETHER_GOLD_ORE, 9, 16, 100, 10, 20);
		OreGeneration.addNetherOre(INCBlocks.NETHER_IRON_ORE, 9, 8, 90, 15, 0);
		OreGeneration.addNetherOre(INCBlocks.NETHER_COPPER_ORE, 9, 13, 100, 18, 15);
		OreGeneration.addNetherOre(INCBlocks.NETHER_LEAD_ORE, 9, 11, 80, 20, 10);
		OreGeneration.addEnderOre(INCBlocks.END_TIN_ORE, 9, 10, 96);
		OreGeneration.addEnderOre(INCBlocks.END_SILVER_ORE, 9, 13, 96);
	}
	
	public void onClientSetup(FMLClientSetupEvent ev) {
		RenderTypeLookup.setRenderLayer(INCBlocks.IRON_FRAME, RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(INCBlocks.GOLD_FRAME, RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(INCBlocks.COPPER_FRAME, RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(INCBlocks.TIN_FRAME, RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(INCBlocks.SILVER_FRAME, RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(INCBlocks.LEAD_FRAME, RenderType.getCutoutMipped());
	}
}
