package com.mreyeballs29.itnc.block;

import java.util.function.Supplier;

import com.mreyeballs29.itnc.Isacc29Core;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class OilFluidBlock extends FlowingFluidBlock {

	public OilFluidBlock(Supplier<? extends FlowingFluid> supplier, Properties p_i48368_1_) {
		super(supplier, p_i48368_1_);
	}

	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		super.onEntityCollision(state, worldIn, pos, entityIn);
		if (entityIn instanceof LivingEntity) {
			LivingEntity entity = (LivingEntity) entityIn;
			if (!entity.isImmuneToFire() || !entity.isEntityUndead() || entity.isNonBoss() || entity.getCreatureAttribute() != CreatureAttribute.ARTHROPOD) {
				entity.attackEntityFrom(Isacc29Core.OIL, 2F);
				entity.addPotionEffect(new EffectInstance(Effects.POISON, 300));
			}
		}
	}
}
