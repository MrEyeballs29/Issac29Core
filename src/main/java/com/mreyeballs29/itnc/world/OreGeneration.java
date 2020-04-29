package com.mreyeballs29.itnc.world;

import com.mreyeballs29.itnc.block.INCBlocks;
import com.mreyeballs29.itnc.world.gen.feature.ExtendedOreFeatureConfig;
import com.mreyeballs29.itnc.world.gen.feature.INCFeatures;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;

public class OreGeneration {
	public static void addBiomeOre(Biome biome, Block block, int size, int count, int maxheight, int bottomOffset, int topOffset) {
		biome.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(FillerBlockType.NATURAL_STONE, block.getDefaultState(), size)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(count, bottomOffset, topOffset, maxheight))));
	}
	
	public static void addDesertOre() {
		Biomes.DESERT.addFeature(Decoration.TOP_LAYER_MODIFICATION, INCFeatures.EXTENDED_ORE.withConfiguration(new ExtendedOreFeatureConfig(Blocks.SAND.getDefaultState(), INCBlocks.OILSHALE_ORE.getDefaultState(), 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(16, 0, 0, 240))));
		Biomes.DESERT_HILLS.addFeature(Decoration.TOP_LAYER_MODIFICATION, INCFeatures.EXTENDED_ORE.withConfiguration(new ExtendedOreFeatureConfig(Blocks.SAND.getDefaultState(), INCBlocks.OILSHALE_ORE.getDefaultState(), 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(16, 0, 0, 240))));
		Biomes.DESERT_LAKES.addFeature(Decoration.TOP_LAYER_MODIFICATION, INCFeatures.EXTENDED_ORE.withConfiguration(new ExtendedOreFeatureConfig(Blocks.SAND.getDefaultState(), INCBlocks.OILSHALE_ORE.getDefaultState(), 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(16, 0, 0, 240))));
	}
	
	public static void addCommonOre(Block block, int size, int count, int maxheight, int bottomOffset, int topOffset) {
		for (Biome biome : Biome.BIOMES) {
			biome.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(FillerBlockType.NATURAL_STONE, block.getDefaultState(), size)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(count, bottomOffset, topOffset, maxheight))));
		}
		Biomes.COLD_OCEAN.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(FillerBlockType.NATURAL_STONE, block.getDefaultState(), size)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(count, bottomOffset, topOffset, maxheight))));
		Biomes.DEEP_COLD_OCEAN.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(FillerBlockType.NATURAL_STONE, block.getDefaultState(), size)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(count, bottomOffset, topOffset, maxheight))));
		Biomes.FROZEN_OCEAN.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(FillerBlockType.NATURAL_STONE, block.getDefaultState(), size)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(count, bottomOffset, topOffset, maxheight))));
		Biomes.DEEP_FROZEN_OCEAN.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(FillerBlockType.NATURAL_STONE, block.getDefaultState(), size)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(count, bottomOffset, topOffset, maxheight))));
		Biomes.LUKEWARM_OCEAN.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(FillerBlockType.NATURAL_STONE, block.getDefaultState(), size)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(count, bottomOffset, topOffset, maxheight))));
		Biomes.DEEP_LUKEWARM_OCEAN.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(FillerBlockType.NATURAL_STONE, block.getDefaultState(), size)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(count, bottomOffset, topOffset, maxheight))));
		Biomes.WARM_OCEAN.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(FillerBlockType.NATURAL_STONE, block.getDefaultState(), size)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(count, bottomOffset, topOffset, maxheight))));
		Biomes.DEEP_WARM_OCEAN.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(FillerBlockType.NATURAL_STONE, block.getDefaultState(), size)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(count, bottomOffset, topOffset, maxheight))));
	}
	
	public static void addNetherOre(Block block, int size, int count, int maxheight, int bottomOffset, int topOffset) {
		Biomes.NETHER.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(FillerBlockType.NETHERRACK, block.getDefaultState(), size)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(count, bottomOffset, topOffset, maxheight))));
	}
	
	public static void addSingleOre(Biome biome, Block block, Block block2) {
		biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(block.getDefaultState(), block2.getDefaultState())).withPlacement(Placement.EMERALD_ORE.configure(new NoPlacementConfig())));
	}
	
	public static void addEnderOre(Block block, int size, int count, int maxheight) {
		Biomes.END_BARRENS.addFeature(Decoration.UNDERGROUND_ORES, INCFeatures.EXTENDED_ORE.withConfiguration(new ExtendedOreFeatureConfig(Blocks.END_STONE.getDefaultState(), block.getDefaultState(), size)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(count, 16, 0, maxheight))));
		Biomes.END_HIGHLANDS.addFeature(Decoration.UNDERGROUND_ORES, INCFeatures.EXTENDED_ORE.withConfiguration(new ExtendedOreFeatureConfig(Blocks.END_STONE.getDefaultState(), block.getDefaultState(), size)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(count, 16, 0, maxheight))));
		Biomes.END_MIDLANDS.addFeature(Decoration.UNDERGROUND_ORES, INCFeatures.EXTENDED_ORE.withConfiguration(new ExtendedOreFeatureConfig(Blocks.END_STONE.getDefaultState(), block.getDefaultState(), size)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(count, 16, 0, maxheight))));
		Biomes.SMALL_END_ISLANDS.addFeature(Decoration.RAW_GENERATION, INCFeatures.EXTENDED_ORE.withConfiguration(new ExtendedOreFeatureConfig(Blocks.END_STONE.getDefaultState(), block.getDefaultState(), size)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(count, 16, 0, maxheight))));
		Biomes.THE_END.addFeature(Decoration.UNDERGROUND_ORES, INCFeatures.EXTENDED_ORE.withConfiguration(new ExtendedOreFeatureConfig(Blocks.END_STONE.getDefaultState(), block.getDefaultState(), size)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(count, 16, 0, maxheight))));
	}
}
