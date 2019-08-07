package com.mreyeballs29.issactncore.block;

import java.awt.Color;
import java.util.Random;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockPowder extends BlockFalling {
	private ItemStack itemstack = null;
	private Color color;
	private MapColor maps;
	
	public BlockPowder(boolean dirt, Item itemtodrop, Color colorful, MapColor map) {
		blockSoundType = dirt ? SoundType.GROUND : SoundType.SAND;
		itemstack = new ItemStack(itemtodrop, 9, 0);
		color = colorful;
		maps = map;
	}
	
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return itemstack.getCount();
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return itemstack.getItem();
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}
	
	@Override
	public int getDustColor(IBlockState state) {
		return color.hashCode();
	}
	
	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return maps;
	}
}
