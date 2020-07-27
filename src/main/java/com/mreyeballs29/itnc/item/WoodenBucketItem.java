package com.mreyeballs29.itnc.item;

import java.util.Map;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import org.apache.commons.lang3.tuple.MutablePair;

import com.mreyeballs29.itnc.util.FluidTools;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class WoodenBucketItem extends Item {

	private static final Map<Fluid, Item> fluid_to_item = FluidTools.create(
		new MutablePair<Fluid, Item>(Fluids.WATER, Items.WATER_BUCKET)
	);
	
	private final Supplier<Fluid> supplier;

	public WoodenBucketItem(Properties properties, Supplier<Fluid> fluid) {
		super(properties);
		this.supplier = fluid;
	}

	public Fluid getFluid() {
		return this.supplier.get();
	}

	@Override
	public int getItemStackLimit(ItemStack stack) {
		return this.getFluid() == Fluids.EMPTY ? 16 : 1;
	}

	@Override
	public int getBurnTime(ItemStack itemStack) {
		return this.getFluid() == Fluids.EMPTY ? 300 : 0;
	}

	/**
	 * Called to trigger the item's "innate" right click behavior. To handle when
	 * this item is used on a Block, see {@link #onItemUse}.
	 */
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		RayTraceResult raytraceresult = rayTrace(worldIn, playerIn,
				this.getFluid() == Fluids.EMPTY ? RayTraceContext.FluidMode.SOURCE_ONLY
						: RayTraceContext.FluidMode.NONE);
		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn,
				itemstack, raytraceresult);
		if (ret != null)
			return ret;
		if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
			return ActionResult.resultPass(itemstack);
		} else if (raytraceresult.getType() != RayTraceResult.Type.BLOCK) {
			return ActionResult.resultPass(itemstack);
		} else {
			BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult) raytraceresult;
			BlockPos blockpos = blockraytraceresult.getPos();
			Direction direction = blockraytraceresult.getFace();
			BlockPos blockpos1 = blockpos.offset(direction);
			if (worldIn.isBlockModifiable(playerIn, blockpos)
					&& playerIn.canPlayerEdit(blockpos1, direction, itemstack)) {
				if (this.getFluid() == Fluids.EMPTY) {
					BlockState blockstate1 = worldIn.getBlockState(blockpos);
					if (blockstate1.getBlock() instanceof FlowingFluidBlock) {
						FlowingFluidBlock fluidBlock = (FlowingFluidBlock) blockstate1.getBlock();
						if (fluidBlock.getFluid().getAttributes().getTemperature() > 350)
							return ActionResult.resultPass(itemstack);
					}
					if (blockstate1.getBlock() instanceof IBucketPickupHandler) {
						Fluid fluid = ((IBucketPickupHandler) blockstate1.getBlock()).pickupFluid(worldIn, blockpos,
								blockstate1);
						if (fluid != Fluids.EMPTY) {
							playerIn.addStat(Stats.ITEM_USED.get(this));

							SoundEvent soundevent = this.getFluid().getAttributes().getEmptySound();
							if (soundevent == null)
								soundevent = SoundEvents.ITEM_BUCKET_FILL;
							playerIn.playSound(soundevent, 1.0F, 1.0F);
							ItemStack itemstack1 = fillBucket(itemstack, playerIn, fluid_to_item.get(fluid));
							if (!worldIn.isRemote) {
								CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayerEntity) playerIn,
										new ItemStack(fluid.getFilledBucket()));
							}

							return ActionResult.resultSuccess(itemstack1);
						}
					}

					return ActionResult.resultFail(itemstack);
				}
				BlockState blockstate = worldIn.getBlockState(blockpos);
				BlockPos blockpos2 = blockstate.getBlock() instanceof ILiquidContainer
						&& this.getFluid() == Fluids.WATER ? blockpos : blockpos1;
				if (this.tryPlaceContainedLiquid(playerIn, worldIn, blockpos2, blockraytraceresult)) {
					this.onLiquidPlaced(worldIn, itemstack, blockpos2);
					if (playerIn instanceof ServerPlayerEntity) {
						CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity) playerIn, blockpos2, itemstack);
					}

					playerIn.addStat(Stats.ITEM_USED.get(this));
					return ActionResult.resultSuccess(emptyBucket(itemstack, playerIn));
				}
				return ActionResult.resultFail(itemstack);
			}
			return ActionResult.resultFail(itemstack);
		}
	}

	protected static ItemStack emptyBucket(ItemStack p_203790_1_, PlayerEntity p_203790_2_) {
		return !p_203790_2_.abilities.isCreativeMode ? new ItemStack(Items.BUCKET) : p_203790_1_;
	}

	/**
	 * TODO insert here
	 * 
	 * @param worldIn
	 * @param p_203792_2_
	 * @param pos
	 */
	public void onLiquidPlaced(World worldIn, ItemStack p_203792_2_, BlockPos pos) {
		//
	}

	private static ItemStack fillBucket(ItemStack emptyBuckets, PlayerEntity player, Item fullBucket) {
		if (player.abilities.isCreativeMode) {
			return emptyBuckets;
		}
		emptyBuckets.shrink(1);
		if (emptyBuckets.isEmpty()) {
			return new ItemStack(fullBucket);
		}
		if (!player.inventory.addItemStackToInventory(new ItemStack(fullBucket))) {
			player.dropItem(new ItemStack(fullBucket), false);
		}

		return emptyBuckets;
	}

	public boolean tryPlaceContainedLiquid(@Nullable PlayerEntity player, World worldIn, BlockPos posIn,
			@Nullable BlockRayTraceResult p_180616_4_) {
		if (!(this.getFluid() instanceof FlowingFluid)) {
			return false;
		}
		BlockState blockstate = worldIn.getBlockState(posIn);
		Material material = blockstate.getMaterial();
		boolean flag = blockstate.isReplaceable(this.getFluid());
		if (blockstate.isAir(worldIn, posIn) || flag
				|| blockstate.getBlock() instanceof ILiquidContainer && ((ILiquidContainer) blockstate.getBlock())
						.canContainFluid(worldIn, posIn, blockstate, this.getFluid())) {
			if (worldIn.dimension.doesWaterVaporize() && this.getFluid().isIn(FluidTags.WATER)) {
				int i = posIn.getX();
				int j = posIn.getY();
				int k = posIn.getZ();
				worldIn.playSound(player, posIn, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F,
						2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);

				for (int l = 0; l < 8; ++l) {
					worldIn.addParticle(ParticleTypes.LARGE_SMOKE, i + Math.random(), j + Math.random(),
							k + Math.random(), 0.0D, 0.0D, 0.0D);
				}
			} else if (blockstate.getBlock() instanceof ILiquidContainer && this.getFluid() == Fluids.WATER) {
				if (((ILiquidContainer) blockstate.getBlock()).receiveFluid(worldIn, posIn, blockstate,
						((FlowingFluid) this.getFluid()).getStillFluidState(false))) {
					this.playEmptySound(player, worldIn, posIn);
				}
			} else {
				if (!worldIn.isRemote && flag && !material.isLiquid()) {
					worldIn.destroyBlock(posIn, true);
				}

				this.playEmptySound(player, worldIn, posIn);
				worldIn.setBlockState(posIn, this.getFluid().getDefaultState().getBlockState(), 11);
			}

			return true;
		}
		return p_180616_4_ == null ? false
				: this.tryPlaceContainedLiquid(player, worldIn, p_180616_4_.getPos().offset(p_180616_4_.getFace()),
						(BlockRayTraceResult) null);
	}

	protected void playEmptySound(@Nullable PlayerEntity player, IWorld worldIn, BlockPos pos) {
		SoundEvent soundevent = this.getFluid().getAttributes().getEmptySound();
		if (soundevent == null)
			soundevent = SoundEvents.ITEM_BUCKET_EMPTY;
		worldIn.playSound(player, pos, soundevent, SoundCategory.BLOCKS, 1.0F, 1.0F);
	}

	@Override
	public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack,
			@Nullable net.minecraft.nbt.CompoundNBT nbt) {
		if (this.getClass() == WoodenBucketItem.class)
			return new net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper(stack);
		return super.initCapabilities(stack, nbt);
	}

}
