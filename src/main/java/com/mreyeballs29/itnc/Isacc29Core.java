package com.mreyeballs29.itnc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mreyeballs29.itnc.block.INCBlocks;
import com.mreyeballs29.itnc.client.gui.screen.inventory.CrateScreen;
import com.mreyeballs29.itnc.client.gui.screen.inventory.TankScreen;
import com.mreyeballs29.itnc.config.Config;
import com.mreyeballs29.itnc.fluid.INCFluids;
import com.mreyeballs29.itnc.inventory.INContainerTypes;
import com.mreyeballs29.itnc.proxy.ClientProxy;
import com.mreyeballs29.itnc.proxy.IProxy;
import com.mreyeballs29.itnc.proxy.ServerProxy;
import com.mreyeballs29.itnc.world.LakeGeneration;
import com.mreyeballs29.itnc.world.OreGeneration;

import net.minecraft.block.Blocks;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.GameRules;
import net.minecraft.world.GameRules.BooleanValue;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("itnc")
public class Isacc29Core {
    
	public static final Logger logger = LogManager.getFormatterLogger();
	
	public static final IProxy object = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);
	
	public static final DamageSource OIL = new DamageSource("oil"); //$NON-NLS-1$
	
	public Isacc29Core() {
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(Type.COMMON, Config.COMMON_CONFIG);
        bus.addListener(this::onClientSetup);
        bus.addListener(this::onCommonSetup);
    }
	
	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {
		this.equals(this);
		@SuppressWarnings("resource")
		MinecraftServer server = event.getServer();
		GameRules rules = server.getGameRules();
		BooleanValue ruleValue = rules.get(GameRules.DO_LIMITED_CRAFTING);
		if (Config.LOCKED_PROGRESSION.get().booleanValue()) {
			if (!ruleValue.get()) ruleValue.set(true, server);
		}
	}
	
	/**
	 * @param ev  
	 */
	public void onCommonSetup(FMLCommonSetupEvent ev) {
		if (Config.COPPER_GENERATE.get().booleanValue()) OreGeneration.addCommonOre(INCBlocks.COPPER_ORE, 9, 18, 96, 0, 0);
		if (Config.TIN_GENERATE.get().booleanValue()) OreGeneration.addCommonOre(INCBlocks.TIN_ORE, 9, 15, 56, 0, 0);
		if (Config.SILVER_GENERATE.get().booleanValue()) OreGeneration.addCommonOre(INCBlocks.SILVER_ORE, 9, 9, 40, 0, 0);
		if (Config.LEAD_GENERATE.get().booleanValue()) OreGeneration.addCommonOre(INCBlocks.LEAD_ORE, 9, 12, 60, 12, 0);
		OreGeneration.addCommonOre(Blocks.CLAY, 16, 8, 60, 0, 0);
		OreGeneration.addDesertOre();
		OreGeneration.addCommonOre(INCBlocks.LIGNITE_ORE, 18, 22, 160, 0, 0);
		if (Config.NETHER_GOLD_GENERATE.get().booleanValue()) OreGeneration.addNetherOre(INCBlocks.NETHER_GOLD_ORE, 9, 16, 100, 10, 20);
		if (Config.NETHER_IRON_GENERATE.get().booleanValue()) OreGeneration.addNetherOre(INCBlocks.NETHER_IRON_ORE, 9, 8, 90, 15, 0);
		if (Config.NETHER_COPPER_GENERATE.get().booleanValue()) OreGeneration.addNetherOre(INCBlocks.NETHER_COPPER_ORE, 9, 13, 100, 18, 15);
		if (Config.NETHER_LEAD_GENERATE.get().booleanValue()) OreGeneration.addNetherOre(INCBlocks.NETHER_LEAD_ORE, 9, 11, 80, 20, 10);
		if (Config.END_TIN_GENERATE.get().booleanValue()) OreGeneration.addEnderOre(INCBlocks.END_TIN_ORE, 9, 10, 96);
		if (Config.END_SILVER_GENERATE.get().booleanValue()) OreGeneration.addEnderOre(INCBlocks.END_SILVER_ORE, 9, 13, 96);
		LakeGeneration.addLakes();
	}
	
	/**
	 * @param ev  
	 */
	public void onClientSetup(FMLClientSetupEvent ev) {
		RenderTypeLookup.setRenderLayer(INCBlocks.IRON_FRAME, RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(INCBlocks.GOLD_FRAME, RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(INCBlocks.COPPER_FRAME, RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(INCBlocks.TIN_FRAME, RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(INCBlocks.SILVER_FRAME, RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(INCBlocks.LEAD_FRAME, RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(INCBlocks.BRONZE_FRAME, RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(INCFluids.OIL, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(INCFluids.OIL_FLOWING, RenderType.getTranslucent());
		ScreenManager.registerFactory(INContainerTypes.CRATE, CrateScreen::new);
		ScreenManager.registerFactory(INContainerTypes.TANK, TankScreen::new);
	}
}
