package com.mreyeballs29.itnc.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.block.TNTBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class IgnitionItem extends FlintAndSteelItem {

	public IgnitionItem(Properties builder) {
		super(builder);
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, Hand hand) {
		if (target instanceof CreeperEntity) {
			target.world.playSound(playerIn, target.getPosX(), target.getPosY(), target.getPosZ(), SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.HOSTILE, 1.0F, random.nextFloat() * 0.4F + 0.8F);
	         if (!target.world.isRemote) {
	            ((CreeperEntity)(target)).ignite();
	            stack.damageItem(1, playerIn, (p_213625_1_) -> {
	               p_213625_1_.sendBreakAnimation(hand);
	            });
	         }

	         return true;
		}
		return false;
	}
	
	@Override
	@SuppressWarnings("resource")
	public ActionResultType onItemUse(ItemUseContext context) {
	      PlayerEntity playerentity = context.getPlayer();
	      IWorld iworld = context.getWorld();
	      BlockPos blockpos = context.getPos();
	      BlockState blockstate = iworld.getBlockState(blockpos);
	      if (isUnlitCampfire(blockstate)) {
	         iworld.playSound(playerentity, blockpos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
	         iworld.setBlockState(blockpos, blockstate.with(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
	         if (playerentity != null) {
	            context.getItem().damageItem(1, playerentity, (p_219999_1_) -> {
	               p_219999_1_.sendBreakAnimation(context.getHand());
	            });
	         }
	         return ActionResultType.SUCCESS;
	      } else if (blockstate.getBlock() instanceof TNTBlock) {
	    	  TNTBlock block = (TNTBlock)blockstate.getBlock();
	    	  block.catchFire(blockstate, iworld.getWorld(), blockpos, context.getFace(), playerentity);
	    	  iworld.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 11);
	    	  if (!playerentity.isCreative()) {
	    		  context.getItem().damageItem(1, playerentity, (p_220287_1_) -> {
	                  p_220287_1_.sendBreakAnimation(context.getHand());
	              });
	    	  }
	    	  return ActionResultType.SUCCESS;
	      }
		BlockPos blockpos1 = blockpos.offset(context.getFace());
		 if (canSetFire(iworld.getBlockState(blockpos1), iworld, blockpos1)) {
		    iworld.playSound(playerentity, blockpos1, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
		    BlockState blockstate1 = ((FireBlock)Blocks.FIRE).getStateForPlacement(iworld, blockpos1);
		    iworld.setBlockState(blockpos1, blockstate1, 11);
		    ItemStack itemstack = context.getItem();
		    if (playerentity instanceof ServerPlayerEntity) {
		       CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity)playerentity, blockpos1, itemstack);
		       itemstack.damageItem(1, playerentity, (p_219998_1_) -> {
		          p_219998_1_.sendBreakAnimation(context.getHand());
		       });
		    }

		    return ActionResultType.SUCCESS;
		 }
		 return ActionResultType.FAIL;
	   }
}
