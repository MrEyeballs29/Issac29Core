package com.mreyeballs29.issactncore.block;

import java.util.Random;

import com.mreyeballs29.issactncore.entity.EntityFallingPowder;
import com.mreyeballs29.issactncore.init.I29CBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockPlainConcretePowder extends BlockFalling {

	private Item item;
	
	public BlockPlainConcretePowder(Item concretePowder) {
		item = concretePowder;
		setSoundType(SoundType.SAND);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return item != null ? item.delegate.get() : Items.AIR;
	}
	
    /**
	 * @param state
	 */
    protected boolean tryTouchWater(World worldIn, BlockPos pos, IBlockState state)
    {
        boolean flag = false;

        for (EnumFacing enumfacing : EnumFacing.values())
        {
            if (enumfacing != EnumFacing.DOWN)
            {
                BlockPos blockpos = pos.offset(enumfacing);

                if (worldIn.getBlockState(blockpos).getMaterial() == Material.WATER)
                {
                    flag = true;
                    break;
                }
            }
        }

        if (flag)
        {
            worldIn.setBlockState(pos, I29CBlocks.CONCRETE.getDefaultState(), 3);
        }

        return flag;
    }
    
    public void onEndFalling(World worldIn, BlockPos pos, IBlockState p_176502_3_, IBlockState p_176502_4_)
    {
        if (p_176502_4_.getMaterial().isLiquid())
        {
            worldIn.setBlockState(pos, I29CBlocks.CONCRETE.getDefaultState(), 3);
        }
    }
	
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!this.tryTouchWater(worldIn, pos, state))
        {
            super.onBlockAdded(worldIn, pos, state);
        }
    }
    
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (!this.tryTouchWater(worldIn, pos, state))
        {
            super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
        }
    }
    
    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
    	if (!worldIn.isRemote) {
    		checkFallable(worldIn, pos);
    	}
    }
    
    private void checkFallable(World worldIn, BlockPos pos)
    {
      if ((worldIn.isAirBlock(pos.down()) || canFallThrough(worldIn.getBlockState(pos.down()))) && pos.getY() >= 0)
        {
            if (!fallInstantly && worldIn.isAreaLoaded(pos.add(-32, -32, -32), pos.add(32, 32, 32)))
            {
                if (!worldIn.isRemote)
                {
                    EntityFallingPowder entityfallingblock = new EntityFallingPowder(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, worldIn.getBlockState(pos));
                    this.onStartFalling(entityfallingblock);
                    worldIn.spawnEntity(entityfallingblock);
                }
            }
            else
            {
                IBlockState state = worldIn.getBlockState(pos);
                worldIn.setBlockToAir(pos);
                BlockPos blockpos;

                for (blockpos = pos.down(); (worldIn.isAirBlock(blockpos) || canFallThrough(worldIn.getBlockState(blockpos))) && blockpos.getY() > 0; blockpos = blockpos.down())
                {
                    ;
                }

                if (blockpos.getY() > 0)
                {
                    worldIn.setBlockState(blockpos.up(), state);
                }
            }
        }
    }
    
    @Override
    public int getDustColor(IBlockState state) {
    	return 0xCDC9B2;
    }
}
