package com.mreyeballs29.itnc.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class Config {
	private static final ForgeConfigSpec.Builder COMMON_BUILDER = new Builder();
	
	public static ForgeConfigSpec COMMON_CONFIG;
	
	public static ForgeConfigSpec.BooleanValue COPPER_GENERATE;
	public static ForgeConfigSpec.BooleanValue TIN_GENERATE;
	public static ForgeConfigSpec.BooleanValue SILVER_GENERATE;
	public static ForgeConfigSpec.BooleanValue LEAD_GENERATE;
	public static BooleanValue LOCKED_PROGRESSION;
	public static BooleanValue NETHER_GOLD_GENERATE;
	public static BooleanValue NETHER_IRON_GENERATE;
	public static BooleanValue NETHER_COPPER_GENERATE;
	public static BooleanValue END_TIN_GENERATE;
	public static BooleanValue END_SILVER_GENERATE;
	public static BooleanValue NETHER_LEAD_GENERATE;
	
	public static IntValue ORE_PROCESS;
	
	static {
		setUpConfig();
		
		COMMON_CONFIG = COMMON_BUILDER.build();
	}

	private static void setUpConfig() {
		COMMON_BUILDER.comment("World Generation Settings").push("world"); //$NON-NLS-1$ //$NON-NLS-2$
		
		
		COPPER_GENERATE = COMMON_BUILDER.comment("Should Copper Ore Generate").define("copperOre", true); //$NON-NLS-1$ //$NON-NLS-2$
		TIN_GENERATE = COMMON_BUILDER.comment("Should Tin Ore Generate").define("tinOre", true);  //$NON-NLS-1$ //$NON-NLS-2$
		SILVER_GENERATE = COMMON_BUILDER.comment("Should Silver Ore Generate").define("silverOre", true); //$NON-NLS-1$ //$NON-NLS-2$
		LEAD_GENERATE = COMMON_BUILDER.comment("Should Lead Ore Generate").define("leadOre", true); //$NON-NLS-1$ //$NON-NLS-2$
		NETHER_IRON_GENERATE = COMMON_BUILDER.comment("Should Nether Iron Ore Generate").define("netherIronOre", true); //$NON-NLS-1$ //$NON-NLS-2$
		NETHER_GOLD_GENERATE = COMMON_BUILDER.comment("Should Nether Gold Ore Generate").define("netherGoldOre", true); //$NON-NLS-1$ //$NON-NLS-2$
		NETHER_COPPER_GENERATE = COMMON_BUILDER.comment("Should Nether Copper Ore Generate").define("netherCopperOre", true); //$NON-NLS-1$ //$NON-NLS-2$
		END_TIN_GENERATE = COMMON_BUILDER.comment("Should End Tin Ore Generate").define("endTinOre", true); //$NON-NLS-1$ //$NON-NLS-2$
		END_SILVER_GENERATE = COMMON_BUILDER.comment("Should End Silver Ore Generate").define("endSilverOre", true); //$NON-NLS-1$ //$NON-NLS-2$
		NETHER_LEAD_GENERATE = COMMON_BUILDER.comment("Should Nether Lead Ore Generate").define("netherLeadOre", true); //$NON-NLS-1$ //$NON-NLS-2$
		
		COMMON_BUILDER.pop();
		
		COMMON_BUILDER.comment("General Settings").push("general"); //$NON-NLS-1$ //$NON-NLS-2$
		
		ORE_PROCESS = COMMON_BUILDER.comment("How many products be produced per ore.").defineInRange("oreProcess", 2, 1, 4); //$NON-NLS-1$ //$NON-NLS-2$
		LOCKED_PROGRESSION = COMMON_BUILDER.comment("Should crafting recipes locked on progression").define("progressionLock", true); //$NON-NLS-1$ //$NON-NLS-2$
		
		COMMON_BUILDER.pop();
	}
}
