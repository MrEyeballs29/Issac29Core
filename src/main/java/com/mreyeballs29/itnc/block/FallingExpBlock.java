package com.mreyeballs29.itnc.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.SandBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;

public class FallingExpBlock extends SandBlock {

	
	private int min;
	private int max;
	private int dustColor;
	
	public FallingExpBlock(Properties properties, int min, int max, int dustColor, int dustColor2) {
		super(dustColor, properties);
		this.dustColor = dustColor2;
		this.min = min;
		this.max = max;
	}

	@Override
	public int getDustColor(BlockState state) {
		return RANDOM.nextBoolean() ? super.getDustColor(state) : this.dustColor;
	}
	
	@Override
	public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
		return silktouch == 0 ? MathHelper.nextInt(RANDOM, this.min, this.max) : 0;
	}
}
