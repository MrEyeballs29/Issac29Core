package com.mreyeballs29.itnc.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SixWayBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FiberBlock extends SixWayBlock implements IWaterLoggable {
	
	private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	FiberBlock(Properties properties) {
		super(0.0625F, properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(NORTH, Boolean.valueOf(false)).with(EAST, Boolean.valueOf(false)).with(SOUTH, Boolean.valueOf(false)).with(WEST, Boolean.valueOf(false)).with(UP, Boolean.valueOf(false)).with(DOWN, Boolean.valueOf(false)).with(WATERLOGGED, Boolean.FALSE));
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(NORTH, SOUTH, EAST, WEST, UP, DOWN, WATERLOGGED);
	}
	
	@Override
	@SuppressWarnings("resource")
	public BlockState getStateForPlacement(BlockItemUseContext context) {
	    return this.makeConnections(context.getWorld(), context.getPos());
	}
	
	private BlockState makeConnections(World world, BlockPos pos) {
		Block block = world.getBlockState(pos.down()).getBlock();
	    Block block1 = world.getBlockState(pos.up()).getBlock();
	    Block block2 = world.getBlockState(pos.north()).getBlock();
	    Block block3 = world.getBlockState(pos.east()).getBlock();
	    Block block4 = world.getBlockState(pos.south()).getBlock();
	    Block block5 = world.getBlockState(pos.west()).getBlock();
	    IFluidState ifluidstate = world.getFluidState(pos);
		return this.getDefaultState().with(DOWN, Boolean.valueOf(block.getClass() == this.getClass()))
				.with(UP, Boolean.valueOf(block1.getClass() == this.getClass()))
				.with(NORTH, Boolean.valueOf(block2.getClass() == this.getClass()))
				.with(EAST, Boolean.valueOf(block3.getClass() == this.getClass()))
				.with(SOUTH, Boolean.valueOf(block4.getClass() == this.getClass()))
				.with(WEST, Boolean.valueOf(block5.getClass() == this.getClass()))
				.with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
	}
	
	@Override
	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
	    return !state.get(WATERLOGGED).booleanValue();
	}

	@Override
	@SuppressWarnings("deprecation")
	public IFluidState getFluidState(BlockState state) {
	      return state.get(WATERLOGGED).booleanValue() ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	   }
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
	   return 1.0F;
	}
	
	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		   if (stateIn.get(WATERLOGGED).booleanValue()) {
	          worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
	       }   
		   Block block = facingState.getBlock();
	       boolean flag = block.getClass() == this.getClass();
	       return stateIn.with(FACING_TO_PROPERTY_MAP.get(facing), Boolean.valueOf(flag));
	   }
	
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		   return false;
		}
		
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return false;
	}

	@Override
	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}
	
	@Override
	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		return false;
	}
}
