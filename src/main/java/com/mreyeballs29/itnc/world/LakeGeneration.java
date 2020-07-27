package com.mreyeballs29.itnc.world;

import com.mreyeballs29.itnc.block.INCBlocks;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;

public class LakeGeneration {
	public static void addLakes() {
		for (Biome biome : BiomeTypes.DESERT_BIOMES) {
			biome.addFeature(Decoration.LOCAL_MODIFICATIONS, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(INCBlocks.OIL.getDefaultState())).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(15))));
		}
	}
}
