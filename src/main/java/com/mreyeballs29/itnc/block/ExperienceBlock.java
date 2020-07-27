package com.mreyeballs29.itnc.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;

public class ExperienceBlock extends Block {

	private int minimumExperence;
	private int maximumExperence;
	
	public ExperienceBlock(Properties properties, int min, int max) {
		super(properties);
		this.minimumExperence = min;
		this.maximumExperence = max;
	}

	@Override
	public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
		return silktouch == 0 ? MathHelper.nextInt(this.RANDOM, this.minimumExperence, this.maximumExperence) : 0;
	}
}
