package com.mreyeballs29.itnc.block;

import com.mreyeballs29.itnc.tileentity.CrateTileEntity;
import com.mreyeballs29.itnc.tileentity.item.ManualWrapper;
import com.mreyeballs29.itnc.util.RedstoneTools;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
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
import net.minecraftforge.fml.network.NetworkHooks;

public class CrateBlock extends ContainerBlock {


	public CrateBlock(Properties properties) {
		super(properties);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
	      if (state.getBlock() != newState.getBlock()) {
	         TileEntity tileentity = worldIn.getTileEntity(pos);
	         if (tileentity instanceof CrateTileEntity) {
	        	 ManualWrapper wrapper = ((CrateTileEntity)tileentity).getContents();
	        	 worldIn.updateComparatorOutputLevel(pos, this);
	         	 for (int i = 0; i < 15; i++) {
	         		 InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), wrapper.getStackInSlot(i));
	         	 }
	         }
	     }
	     super.onReplaced(state, worldIn, pos, newState, isMoving);
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new CrateTileEntity();
	}
	
	@Deprecated
	@Override
	public boolean hasComparatorInputOverride(BlockState state) {
		return true;
	}
	
	@Deprecated
	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}
	
	@Deprecated
	@Override
	public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
	   TileEntity tile = worldIn.getTileEntity(pos);
	   if (tile instanceof CrateTileEntity) {
		   CrateTileEntity crate = (CrateTileEntity)tile;
		   return RedstoneTools.calcuateInventory(crate.getContents());
	   }
	   return 0;
	}
	
	@Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
        if (!world.isRemote) {
            TileEntity tileEntity = world.getTileEntity(pos);
            if (tileEntity instanceof INamedContainerProvider) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tileEntity, tileEntity.getPos());
            }
        }
        return ActionResultType.SUCCESS;
    }

	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return new CrateTileEntity();
	}
}
