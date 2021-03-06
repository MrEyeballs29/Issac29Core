package com.mreyeballs29.itnc.world.gen.feature;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class ExtendedOreFeatureConfig implements IFeatureConfig {
	public final BlockState target;
	public final int size;
	public final BlockState state;

	public ExtendedOreFeatureConfig(BlockState target, BlockState state, int size) {
		this.size = size;
		this.state = state;
		this.target = target;
	}
	
	@Override
	public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
		return new Dynamic<>(ops, ops.createMap(ImmutableMap.of(ops.createString("size"), ops.createInt(this.size), ops.createString("target"), BlockState.serialize(ops, this.target).getValue(), ops.createString("state"), BlockState.serialize(ops, this.state).getValue()))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	public static ExtendedOreFeatureConfig deserialize(Dynamic<?> dy) {
		int i = dy.get("size").asInt(0); //$NON-NLS-1$
		BlockState target = dy.get("target").map(BlockState::deserialize).orElse(Blocks.STONE.getDefaultState()); //$NON-NLS-1$
		BlockState blockstate = dy.get("state").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState()); //$NON-NLS-1$
		return new ExtendedOreFeatureConfig(target, blockstate, i);
	}
}
