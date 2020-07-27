package com.mreyeballs29.itnc.fluid;

import com.mreyeballs29.itnc.block.INCBlocks;
import com.mreyeballs29.itnc.item.INCItems;
import com.mreyeballs29.itnc.tags.INCFluidTags;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.fluids.FluidAttributes;

public abstract class OilFluid extends FlowingFluid {
	@Override
	protected float getExplosionResistance() {
		return 50.0F;
	}

	@Override
	protected boolean canSourcesMultiply() {
		return false;
	}

	@Override
	public Item getFilledBucket() {
		return INCItems.OIL_BUCKET;
	}

	@SuppressWarnings("resource")
	@Override
	protected void beforeReplacingBlock(IWorld worldIn, BlockPos pos, BlockState state) {
		TileEntity tileentity = state.hasTileEntity() ? worldIn.getTileEntity(pos) : null;
		Block.spawnDrops(state, worldIn.getWorld(), pos, tileentity);
	}

	@Override
	protected FluidAttributes createAttributes() {
		FluidAttributes.Builder builder = FluidAttributes.builder(new ResourceLocation("itnc", "block/oil_still"), //$NON-NLS-1$ //$NON-NLS-2$
				new ResourceLocation("itnc", "block/oil_flow")); //$NON-NLS-1$ //$NON-NLS-2$
		return builder.viscosity(1412).density(840).translationKey("block.itnc.oil").build(this);//$NON-NLS-1$
	}

	@Override
	protected int getSlopeFindDistance(IWorldReader worldIn) {
		return 4;
	}

	@Override
	protected boolean canDisplace(IFluidState p_215665_1_, IBlockReader p_215665_2_, BlockPos p_215665_3_,
			Fluid p_215665_4_, Direction p_215665_5_) {
		return p_215665_5_ == Direction.DOWN && !p_215665_4_.isIn(INCFluidTags.OIL);
	}

	@Override
	protected BlockState getBlockState(IFluidState state) {
		return INCBlocks.OIL.getDefaultState().with(FlowingFluidBlock.LEVEL, Integer.valueOf(getLevelFromState(state)));
	}

	@Override
	public Fluid getStillFluid() {
		return INCFluids.OIL;
	}

	@Override
	public boolean isEquivalentTo(Fluid fluidIn) {
		return fluidIn == getFlowingFluid() || fluidIn == getStillFluid();
	}
	
	@Override
	public Fluid getFlowingFluid() {
		return INCFluids.OIL_FLOWING;
	}

	@Override
	public int getTickRate(IWorldReader p_205569_1_) {
		return 5;
	}

	@Override
	protected int getLevelDecreasePerBlock(IWorldReader worldIn) {
		return 1;
	}

	public static class Flowing extends OilFluid {
		public Flowing() {
			this.setRegistryName("flowing_oil"); //$NON-NLS-1$
		}

		@Override
		public boolean isSource(IFluidState state) {
			return false;
		}
		
		@Override
		protected void fillStateContainer(StateContainer.Builder<Fluid, IFluidState> builder) {
	         super.fillStateContainer(builder);
	         builder.add(LEVEL_1_8);
	    }

		@Override
		public int getLevel(IFluidState p_207192_1_) {
			return p_207192_1_.get(LEVEL_1_8).hashCode();
		}

	}

	public static class Source extends OilFluid {
		public Source() {
			this.setRegistryName("oil"); //$NON-NLS-1$ 
		}

		@Override
		public int getLevel(IFluidState p_207192_1_) {
			return 8;
		}

		@Override
		public boolean isSource(IFluidState state) {
			return true;
		}
	}
}
