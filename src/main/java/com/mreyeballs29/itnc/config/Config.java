package com.mreyeballs29.itnc.config;

import java.nio.file.Path;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class Config {
	private static final ForgeConfigSpec.Builder COMMON_BUILDER = new Builder();
	
	public static ForgeConfigSpec COMMON_CONFIG;
	
	public static ForgeConfigSpec.BooleanValue COPPER_GENERATE;
	public static ForgeConfigSpec.BooleanValue TIN_GENERATE;
	public static ForgeConfigSpec.BooleanValue SILVER_GENERATE;
	public static ForgeConfigSpec.BooleanValue LEAD_GENERATE;
	
	static {
		setUpConfig();
		
		COMMON_CONFIG = COMMON_BUILDER.build();
	}

	private static void setUpConfig() {
		COMMON_BUILDER.comment("World Generation Settings").push("world");
		
		COPPER_GENERATE = COMMON_BUILDER.comment("Should Copper Ore Generate").define("copperOre", true);
		TIN_GENERATE = COMMON_BUILDER.comment("Should Tin Ore Generate").define("tinOre", true);
		SILVER_GENERATE = COMMON_BUILDER.comment("Should Silver Ore Generate").define("silverOre", true);
		LEAD_GENERATE = COMMON_BUILDER.comment("Should Lead Ore Generate").define("leadOre", true);
		
		COMMON_BUILDER.pop();
	}
	
	public static void loadConfig(ForgeConfigSpec spec, Path path) {

        @SuppressWarnings("resource")
		final CommentedFileConfig configData = CommentedFileConfig.builder(path)
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();

        configData.load();
        spec.setConfig(configData);
    }
}
