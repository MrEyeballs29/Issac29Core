package com.mreyeballs29.itnc.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FrameBlock extends Block {
	
	public FrameBlock(Properties properties) {
		super(properties);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
	   return 1.0F;
	}
	
	@Override
	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
	   return true;
	}

	@Override
	public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, LivingEntity entity) {
		return true;
	}
	
	/*
	@Deprecated
	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		if (!entityIn.isImmuneToFire()) {
			if (!entityIn.isInWaterRainOrBubbleColumn()) {
            	entityIn.setFire(4);
			} else {
				entityIn.playSound(SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, 0.7F, 1.6F + (new Random().nextFloat() - new Random().nextFloat()) * 0.4F);
			}
			switch (worldIn.getDifficulty()) {
			case HARD: entityIn.attackEntityFrom(DamageSource.IN_FIRE, 4.0F);
				break;
			case NORMAL: entityIn.attackEntityFrom(DamageSource.IN_FIRE, 3.0F);
				break;
			default: entityIn.attackEntityFrom(DamageSource.IN_FIRE, 2.0F);
			}
			
		}
	}
	*/
	
	@Override
	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
	   return false;
	}

	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
	   return false;
	}
	
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
	   return false;
	}
	
}
