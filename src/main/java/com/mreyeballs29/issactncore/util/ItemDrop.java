package com.mreyeballs29.issactncore.util;

import java.util.List;
import java.util.Vector;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

public abstract class ItemDrop {
	private IBlockState blockState;
	private Block block;
	private List<ItemStack> drops;
	
	public ItemDrop(HarvestDropsEvent drop) {
		blockState = drop.getState();
		block = drop.getState().getBlock();
		drops = drop.getDrops();
	}
	
	@SuppressWarnings("deprecation")
	public ItemDrop(Block newBlock, int meta) {
		blockState = newBlock.getStateFromMeta(meta);
		block = newBlock;
		drops = new Vector<ItemStack>(1);
	}
	
	public boolean equals(ItemDrop obj) {
		return obj.block == block;
	}
	
	public boolean equals(Block block) {
		return this.block == block;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	public List<ItemStack> getDrops() {
		return drops;
	}
	
	public IBlockState getBlockState() {
		return blockState;
	}
	
	public void setBlock(Block block) {
		this.block = block;
	}
	
	public void setBlockState(IBlockState blockstate) {
		blockState = blockstate;
	}

	public void apply(ItemDrop dropitem) {
		drops.clear();
		drops.addAll(dropitem.drops);
	}
	
	public abstract void apply(ItemStack stack, List<ItemStack> list);
	
	public void setDrops(ItemStack stack) {
		drops.clear();
		apply(stack, drops);
	}
	
	public Block getBlock() {
		return block;
	}
	
	class Hash {
		
	}
}
