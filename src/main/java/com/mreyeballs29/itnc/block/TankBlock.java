package com.mreyeballs29.itnc.block;

import com.mreyeballs29.itnc.tileentity.TankTileEntity;
import com.mreyeballs29.itnc.util.RedstoneTools;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.IItemHandler;

public class TankBlock extends Block {

	protected TankBlock(Properties builder) {
		super(builder);
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new TankTileEntity();
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
	      if (state.getBlock() != newState.getBlock()) {
	         TileEntity tileentity = worldIn.getTileEntity(pos);
	         if (tileentity instanceof TankTileEntity) {
	        	 TankTileEntity tank = (TankTileEntity) tileentity;
	        	 IItemHandler input = tank.getInput();
	        	 IItemHandler output = tank.getOutput();
	        	 worldIn.updateComparatorOutputLevel(pos, this);
	             InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), input.getStackInSlot(0));
	             InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), output.getStackInSlot(0));
	         }
	     }
	     super.onReplaced(state, worldIn, pos, newState, isMoving);
	}
	
	@Deprecated
	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}
	
	@Deprecated
	@Override
	public boolean hasComparatorInputOverride(BlockState state) {
		return true;
	}
	
	@Deprecated
	@Override
	public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
	   TileEntity tile = worldIn.getTileEntity(pos);
	   if (tile instanceof TankTileEntity) {
		   TankTileEntity tank = (TankTileEntity)tile;
		   return RedstoneTools.calcuateTank(tank.getTank());
	   }
	   return 0;
	}

	@Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
        TileEntity tileEntity = world.getTileEntity(pos);
        if (FluidUtil.interactWithFluidHandler(player, hand, world, pos, result.getFace())) {
        	return ActionResultType.SUCCESS;
        }
		if (!world.isRemote) {
            if (tileEntity instanceof INamedContainerProvider) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tileEntity, tileEntity.getPos());
            }
        }
        return ActionResultType.SUCCESS;
    }
}
